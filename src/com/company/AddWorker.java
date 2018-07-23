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
public class AddWorker  {
    public void begin() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        File file = new File("workers.xml");

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
            Workers workers = new Workers();
            workers.setName(name);
            workers.setSurname(surname);
            workers.setBirthday(birthday);
            workers.setStartwork(startWork);

            Element element = getWorkerNode(workers, document);
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

    private static Element getWorkerNode(Workers workers, Document document){
        Element element = document.createElement("worker");
        NodeList list = document.getElementsByTagName("worker");
        int count = list.getLength();
        element.setAttribute("id", String.valueOf(++count));

        Element name = getPropertyNode("name", document, workers.getName());
        element.appendChild(name);
        Element surname = getPropertyNode("surname", document, workers.getSurname());
        element.appendChild(surname);
        Element birthday = getPropertyNode("birthday", document, workers.getBirthday());
        element.appendChild(birthday);
        Element startwork = getPropertyNode("startwork", document, workers.getStartwork());
        element.appendChild(startwork);
        return element;

    }

    private static Element getPropertyNode(String property, Document document, String value){
        Element element = document.createElement(property);
        element.setTextContent(value);
        return element;
    }


    }

