package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.ArrayList;


/**
 * Created by rusJA.
 */
public class WorkersHandler extends DefaultHandler {
    private String currentTagName;
    private Workers workers;

    private ArrayList<Workers> workersList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.currentTagName = qName;
        if("worker".equals(this.currentTagName)){
            this.workers = new Workers();
            this.workers.setId(Integer.parseInt(attributes.getValue("id")));

        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if("name".equals(this.currentTagName)){
            String name = new String(ch, start, length);
            this.workers.setName(name);
        }
        else if("surname".equals(this.currentTagName)){
            String surname = new String(ch, start, length);
            this.workers.setSurname(surname);
        }
        else if("birthday".equals(this.currentTagName)){
            String birthday = new String(ch, start, length);
            this.workers.setBirthday(birthday);
        }
        else if("startwork".equals(this.currentTagName)){
            String startwork = new String(ch, start, length);
            this.workers.setStartwork(startwork);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("worker".equals(qName)){
            this.workersList.add(this.workers);
            this.workers = null;
        }
        this.currentTagName = null;
    }

    public ArrayList<Workers> getWorkersList(){
        return this.workersList;
    }
}
