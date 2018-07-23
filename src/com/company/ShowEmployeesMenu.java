package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Created by rusJA
 */
public class ShowEmployeesMenu extends Menu {

    public ShowEmployeesMenu(int min, int max, boolean exit) {
        super(min, max, exit);
    }

    @Override
    public void runMenu() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        super.runMenu();
    }

    @Override
    public void printMenu() {
        System.out.println("1. Show workers");
        System.out.println("2. Show managers");
        System.out.println("3. Show other");
        System.out.println("4. Back to Main menu");
        System.out.println("0. Exit");
    }

    @Override
    public int getMenuChoice() {
        return super.getMenuChoice();
    }

    @Override
    public void performAction(int choice) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        WorkersXmlParser workersXmlParser = new WorkersXmlParser();
        ManagerXmlParser managerXmlParser = new ManagerXmlParser();
        OthersXmlParser othersXmlParser = new OthersXmlParser();
        switch (choice) {
            case 0:
                System.out.println("Good-By");
                System.exit(0);
                break;
            case 1:
                workersXmlParser.print();
                break;
            case 2:
                managerXmlParser.print();
                break;
            case 3:
                othersXmlParser.print();
                break;
            case 4:
                MainMenu mainMenu = new MainMenu(0,3, false);
                mainMenu.runMenu();
                break;
            default:
                System.out.println("Unknown error has occurred");
        }

    }
}
