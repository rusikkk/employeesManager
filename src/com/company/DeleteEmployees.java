package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rusJA.
 */
public abstract class DeleteEmployees {
    String file;
    String body;

    public DeleteEmployees(String file, String body) {
        this.file = file;
        this.body = body;
    }

    public void begin() throws ParserConfigurationException, SAXException, IOException,
            TransformerException{
        File xmlFile = new File(file);
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader(System.in));
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            System.out.println("Enter id: ");
            int id = Integer.parseInt(input.readLine());
            boolean result = deleteEmployeesFromXml(document, id);
            if (result) {
                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(document);
                StreamResult sResult = new StreamResult(xmlFile);
                transformer.transform(source, sResult);
                System.out.println("Deleted successfully. Press Enter");
            } else {
                System.out.println("Not exist");
            }
        } finally {
            if (input != null) {
                input.readLine();
            }
        }
    }

    private boolean deleteEmployeesFromXml(Document doc, int id) {

        NodeList list = doc.getElementsByTagName(body);
        boolean result = false;
        int lenght = list.getLength();
        for (int i = 0; i < lenght; i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.getAttribute("id").equals(String.valueOf(id))) {
                    Node prev = node.getPreviousSibling();
                    if (prev != null && prev.getNodeType() == Node.TEXT_NODE && prev.getNodeValue().trim().length() == 0) {
                        doc.getDocumentElement().removeChild(prev);
                    }
                    doc.getDocumentElement().removeChild(element);
                    result = true;
                    break;
                }
            }
        }

        return result;
    }
}
