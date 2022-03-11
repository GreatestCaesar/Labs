package by.bsac.practical8.individual;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        ArrayList<Site> sites = new ArrayList<>();
        sites = SiteXML.fromXml(sites);
        for(Site s : sites){
            System.out.println(s);
        }
    }
}
