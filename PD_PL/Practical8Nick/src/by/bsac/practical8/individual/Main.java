package by.bsac.practical8.individual;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<FlatWare> flatWares = new ArrayList<>(FlatXML.XML());
        for(FlatWare f : flatWares){
            System.out.println(f);
        }
    }
}
