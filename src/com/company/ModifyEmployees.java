package com.company;

import jdk.nashorn.internal.runtime.ParserException;
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
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rusJA.
 */
public class ModifyEmployees {

    public void begin() throws ParserConfigurationException, SAXException, IOException, TransformerException {
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader(System.in));
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document workers = builder.parse("workers.xml");
            Document other = builder.parse("other.xml");
            System.out.println("Enter id: ");
            int id = Integer.parseInt(input.readLine());
            boolean result = ModifyEmployees(workers,other ,id);
            if (result) {
                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(workers);
                StreamResult sResult = new StreamResult("other.xml");
                transformer.transform(source, sResult);
                System.out.println("Modification successfully");
            } else {
                System.out.println("Not exist");
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

        private boolean ModifyEmployees (Document worker, Document other,  int id) throws ParserConfigurationException,SAXException, IOException{

            NodeList list = worker.getElementsByTagName("worker");
            boolean result = false;
            int lenght = list.getLength();
            for(int i=0; i<lenght; i++) {
                Node node = list.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (element.getAttribute("id").equals(String.valueOf(id))) {
                        Node prev = node.getPreviousSibling();
                        if (prev != null && prev.getNodeType() == Node.TEXT_NODE && prev.getNodeValue().trim().length() == 0) {
                            Node copy = other.importNode(prev, true);
                            other.getDocumentElement().appendChild(copy);
                        }
                        other.getDocumentElement().removeChild(element);
                        result = true;
                        break;
                    }
                }
            }
            return result;
        }


}
