package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Created by rusJA.
 */
public class MainMenu extends Menu {
    AddEmploeesMenu addEmploeesMenu = new AddEmploeesMenu(0, 5, false);
    ShowEmployeesMenu showEmployeesMenu = new ShowEmployeesMenu(0,5, false);
    DeleteEmployeesMenu deleteEmployeesMenu = new DeleteEmployeesMenu(0,5, false);


    public MainMenu(int min, int max, boolean exit) {
        super(min, max, exit);
    }

    @Override
    public void runMenu() throws ParserConfigurationException, TransformerException, SAXException, IOException {
        super.runMenu();
    }

    @Override
    public void printMenu() {
        System.out.println("1. Add Employees");
        System.out.println("2. Show Employees");
        System.out.println("3. Delete Employees");
        System.out.println("0. Exit");
    }

    @Override
    public void performAction(int choice) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        switch (choice){
            case 0:
                System.out.println("Good-By");
                System.exit(0);
                break;
            case 1:
                addEmploeesMenu.runMenu();
                break;
            case 2:
                showEmployeesMenu.runMenu();
            case 3:
                deleteEmployeesMenu.runMenu();
            default:
                System.out.println("Unknown error has occured");
        }
    }

    @Override
    public int getMenuChoice() {
        return super.getMenuChoice();
    }
}
