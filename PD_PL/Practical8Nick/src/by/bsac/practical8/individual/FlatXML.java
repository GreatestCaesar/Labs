package by.bsac.practical8.individual;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FlatXML {
    public static ArrayList<FlatWare> XML() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<FlatWare> flatWares = new ArrayList<>();
        FlatWare flatWare;
        try {
            File fXmlFile = new File("src/by/bsac/practical8/individual/FlatWare.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("flatware");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                flatWare = new FlatWare();
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    flatWare.setType(eElement.getElementsByTagName("type").item(0).getTextContent());
                    flatWare.setOrigin(eElement.getElementsByTagName("origin").item(0).getTextContent());
                    NodeList visualList = eElement.getElementsByTagName("visual");
                    for(int j = 0; j < visualList.getLength(); j++){
                        Node visNode = visualList.item(j);
                        if(visNode.getNodeType() == Node.ELEMENT_NODE){
                            Element visElement = (Element) visNode;
                            flatWare.setType1(visElement.getElementsByTagName("type").item(0).getTextContent());
                            flatWare.setLength(Double.parseDouble(visElement.getElementsByTagName("length").item(0).getTextContent()));
                            flatWare.setWidth(Double.parseDouble(visElement.getElementsByTagName("width").item(0).getTextContent()));
                            flatWare.setMaterial(visElement.getElementsByTagName("material").item(0).getTextContent());
                        }
                    }
                    flatWare.setValue(eElement.getElementsByTagName("value").item(0).getTextContent());
                    flatWares.add(flatWare);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return flatWares;
    }
}
