package com.company;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by rusJA
 */
public class OthersHandler extends DefaultHandler {
    private String currentTagName;
    private Others others;

    ArrayList<Others> othersList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.currentTagName = qName;
        if ("other".equals(this.currentTagName)) {
            this.others = new Others();
            this.others.setId(Integer.parseInt(attributes.getValue("id")));
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if("name".equals(this.currentTagName)){
            String name = new String(ch, start, length);
            this.others.setName(name);
        }
        else if("surname".equals(this.currentTagName)){
            String surname = new String(ch, start, length);
            this.others.setSurname(surname);
        }
        else if("birthday".equals(this.currentTagName)){
            String birthday = new String(ch, start, length);
            this.others.setBirthday(birthday);
        }
        else if("startwork".equals(this.currentTagName)) {
            String startwork = new String(ch, start, length);
            this.others.setStartwork(startwork);
        }
        else if("description".equals(this.currentTagName)){
            String description = new String(ch, start, length);
            this.others.setDescription(description);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("other".equals(qName)){
            this.othersList.add(this.others);
            this.others = null;
        }
        this.currentTagName = null;

    }

    public ArrayList<Others> getOthersList() {
        return this.othersList;
    }
}