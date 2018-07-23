package com.company;


import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

/**
 * Created by rusJA.
 */
public class WorkersXmlParser {
    public void print(){
        ArrayList<Workers> workerList = null;
        WorkersHandler workersHandler = new WorkersHandler();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        try{
            saxParser = saxParserFactory.newSAXParser();

            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(workersHandler);
            xmlReader.parse("workers.xml");
        }catch (Exception e){
            e.printStackTrace();
        }

        workerList = workersHandler.getWorkersList();
        if(workerList != null){
            for(Workers workers : workerList){
                System.out.println(workers);
            }
        }
    }
}
