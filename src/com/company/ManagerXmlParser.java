package com.company;

import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

/**
 * Created by rusJA
 */
public class ManagerXmlParser {
    public void print(){
        ArrayList<Managers> managerList = null;
        ManagersHandler managersHandler = new ManagersHandler();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        try{
            saxParser = saxParserFactory.newSAXParser();

            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(managersHandler);
            xmlReader.parse("managers.xml");
        }catch (Exception e){
            e.printStackTrace();
        }

        managerList = managersHandler.getManagersList();
        if(managerList != null){
            for(Managers managers : managerList){
                System.out.println(managers);
            }
        }
    }
}
