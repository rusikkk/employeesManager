package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by rusJA.
 */
public abstract class Menu {
    int min;
    int max;
    boolean exit;

    public Menu(int min, int max, boolean exit) {
        this.min = min;
        this.max = max;
        this.exit = exit;
    }

    public void runMenu() throws ParserConfigurationException, IOException, SAXException, TransformerException {
        while(!exit){
            printMenu();
            int choice = getMenuChoice();
            performAction(choice);
        }

    }

    public void printMenu(){

    }

    public int getMenuChoice(){
        int choice = -1;
        do{
            try {
                choice = Integer.parseInt(keyboard("Enter youre choice "));
            }catch (NumberFormatException e){
                System.out.println("Invalid selection. Numbers only, please");
            }
            if(choice<min || choice>max){
                System.out.println("Choice outside of range. Please chose again");
            }
        } while (choice<min || choice>max);

        return choice;
    }
    public void performAction(int choice) throws ParserConfigurationException, TransformerException, SAXException, IOException {

    }
    private String keyboard(String message) {
        System.out.println(message + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
