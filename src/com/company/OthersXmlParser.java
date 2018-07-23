package com.company;


import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

/**
 * Created by rusJA
 */
public class OthersXmlParser {
    public void print(){
        ArrayList<Others> otherList = null;
        OthersHandler othersHandler = new OthersHandler();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser;
        try{
            saxParser = saxParserFactory.newSAXParser();

            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(othersHandler);
            xmlReader.parse("other.xml");
        }catch (Exception e){
            e.printStackTrace();
        }

        otherList = othersHandler.getOthersList();
        if(otherList != null){
            for(Others others : otherList){
                System.out.println(others);
            }
        }
    }

}
