package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
public class AddOther {
    public void begin() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        File file = new File("other.xml");

        BufferedReader input = null;
        try{
            input = new BufferedReader(new InputStreamReader(System.in));
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            System.out.println("Enter name: ");
            String name = input.readLine();
            System.out.println("Enter surname: ");
            String surname = input.readLine();
            System.out.println("Enter date of Birth (dd/mm/yyyy): ");
            String birthday = input.readLine();
            System.out.println("Enter start date (dd/mm/yyyy): ");
            String startWork = input.readLine();
            System.out.println("Enter description: ");
            String description = input.readLine();
            Others others = new Others();
            others.setName(name);
            others.setSurname(surname);
            others.setBirthday(birthday);
            others.setStartwork(startWork);
            others.setDescription(description);

            Element element = getOthersNode(others, document);
            document.getDocumentElement().appendChild(element);

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult sResult = new StreamResult(file);
            transformer.transform(source, sResult);
            System.out.println("Added successfully. Press Enter");

        }finally {
            if(input != null){
                input.readLine();
            }
        }
    }

    private static Element getOthersNode(Others others, Document document){
        Element element = document.createElement("other");
        NodeList list = document.getElementsByTagName("other");
        int count = list.getLength();
        element.setAttribute("id", String.valueOf(++count));

        Element name = getPropertyNode("name", document, others.getName());
        element.appendChild(name);
        Element surname = getPropertyNode("surname", document, others.getSurname());
        element.appendChild(surname);
        Element birthday = getPropertyNode("birthday", document, others.getBirthday());
        element.appendChild(birthday);
        Element startwork = getPropertyNode("startwork", document, others.getStartwork());
        element.appendChild(startwork);
        Element description = getPropertyNode("description", document, others.getDescription());
        element.appendChild(description);
        return element;

    }

    private static Element getPropertyNode(String property, Document document, String value){
        Element element = document.createElement(property);
        element.setTextContent(value);
        return element;
    }


}
