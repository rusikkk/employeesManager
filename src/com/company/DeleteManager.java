package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Created by rusJA
 */
public class DeleteManager extends DeleteEmployees {
    public DeleteManager(String file, String body) {
        super(file, body);
    }

    @Override
    public void begin() throws ParserConfigurationException, SAXException, IOException, TransformerException {
        super.begin();
    }
}
