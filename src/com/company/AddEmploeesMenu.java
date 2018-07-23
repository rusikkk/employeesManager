package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Created by rusJA.
 */
public class AddEmploeesMenu extends Menu {
    AddWorker addWorker = new AddWorker();
    AddManager addManager = new AddManager();
    AddOther addOther = new AddOther();

    public AddEmploeesMenu(int min, int max, boolean exit) {
        super(min, max, exit);
    }

    @Override
    public void runMenu() throws ParserConfigurationException, TransformerException, SAXException, IOException {
        super.runMenu();
    }

    @Override
    public void printMenu() {
        System.out.println("1. Add worker");
        System.out.println("2. Add manager");
        System.out.println("3. Add other");
        System.out.println("4. Back to main menu");
        System.out.println("0. Exit");
    }

    @Override
    public int getMenuChoice() {
        return super.getMenuChoice();
    }

    @Override
    public void performAction(int choice) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        switch (choice) {
            case 0:
                System.out.println("Good-By");
                System.exit(0);
                break;
            case 1:
                addWorker.begin();
                break;
            case 2:
                addManager.begin();
                break;
            case 3:
                addOther.begin();
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
