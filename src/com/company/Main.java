package com.company;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException, SAXException {

    /* MainMenu mainMenu = new MainMenu(0,3, false);
      mainMenu.runMenu();*/
     ModifyEmployees modifyEmployees = new ModifyEmployees();
     modifyEmployees.begin();
        }
    }

