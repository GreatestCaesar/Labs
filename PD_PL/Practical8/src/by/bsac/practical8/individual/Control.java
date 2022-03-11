package by.bsac.practical8.individual;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.ArrayList;

public class Control {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Gem> gems = new ArrayList<>();
        try {
            gems = GemFactory.getInfFromXml();
            for(Gem g : gems){
                System.out.println(g);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
