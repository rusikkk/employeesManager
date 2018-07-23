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
import java.util.Scanner;

/**
 * Created by rusJA.
 */
public class AddManager {
    public void begin() throws IOException, ParserConfigurationException, SAXException, TransformerException {

        File file = new File("managers.xml");

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
            System.out.println("Enter workers ID: ");

            Managers managers = new Managers();
            managers.setName(name);
            managers.setSurname(surname);
            managers.setBirthday(birthday);
            managers.setStartwork(startWork);
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextInt()){
                managers.workersId.add(sc.next());
            }



            Element element = getManagerNode(managers, document);
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

    private static Element getManagerNode(Managers managers, Document document){
        Element element = document.createElement("manager");
        NodeList list = document.getElementsByTagName("manager");
        int count = list.getLength();
        element.setAttribute("id", String.valueOf(++count));

        Element name = getPropertyNode("name", document, managers.getName());
        element.appendChild(name);
        Element surname = getPropertyNode("surname", document, managers.getSurname());
        element.appendChild(surname);
        Element birthday = getPropertyNode("birthday", document, managers.getBirthday());
        element.appendChild(birthday);
        Element startwork = getPropertyNode("startwork", document, managers.getStartwork());
        element.appendChild(startwork);
        Element workers = getPropertyNode("workers", document, String.valueOf(managers.workersId));
        element.appendChild(workers);

        return element;

    }

    private static Element getPropertyNode(String property, Document document, String value){
        Element element = document.createElement(property);
        element.setTextContent(value);
        return element;
    }


}


