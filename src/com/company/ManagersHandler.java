package com.company;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;


/**
 * Created by rusJA
 */
public class ManagersHandler extends DefaultHandler {
    private String currentTagName;
    private Managers managers;

    private ArrayList<Managers> managersList = new ArrayList<>();

    public ArrayList<Managers> getManagersList() {
        return this.managersList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.currentTagName = qName;
        //if current tag is new worker, create a new object
        if ("manager".equals(this.currentTagName)) {
            this.managers = new Managers();
            this.managers.setId(Integer.parseInt(attributes.getValue("id")));
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if("name".equals(this.currentTagName)){
            String name = new String(ch, start, length);
            this.managers.setName(name);
        }
        else if("surname".equals(this.currentTagName)){
            String surname = new String(ch, start, length);
            this.managers.setSurname(surname);
        }
        else if("birthday".equals(this.currentTagName)){
            String birthday = new String(ch, start, length);
            this.managers.setBirthday(birthday);
        }
        else if("startwork".equals(this.currentTagName)){
            String startwork = new String(ch, start, length);
            this.managers.setStartwork(startwork);
        }else if("workers".equals(this.currentTagName)){
            String workers = new String(ch, start, length);
            this.managers.workersId.add(workers);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("manager".equals(qName)){
            this.managersList.add(this.managers);
            this.managers = null;
        }
        this.currentTagName = null;
    }

}


