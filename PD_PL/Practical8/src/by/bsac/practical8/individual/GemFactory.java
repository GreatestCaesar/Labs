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

public class GemFactory {
    public static ArrayList<Gem> getInfFromXml() throws ParserConfigurationException, IOException, SAXException {
        ArrayList<Gem> gems = new ArrayList<>();
        Gem gem = null;
        try {
            File fXmlFile = new File("src\\by\\bsac\\practical8\\individual\\gem.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("gem");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                gem = new Gem();
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    gem.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    gem.setPreciousness(eElement.getElementsByTagName("preciousness").item(0).getTextContent());
                    gem.setOrigin(eElement.getElementsByTagName("origin").item(0).getTextContent());
                    NodeList parList = eElement.getElementsByTagName("visual_parameters");
                    for(int j = 0; j < parList.getLength(); j++){
                        Node parNode = parList.item(j);
                        if(parNode.getNodeType() == Node.ELEMENT_NODE){
                            Element parElement = (Element) parNode;
                            gem.setColor((parElement.getElementsByTagName("color").item(0).getTextContent()));
                            gem.setTransparence(Double.parseDouble(parElement.getElementsByTagName("transparence").item(0).getTextContent()));
                        }
                    }
                    gem.setValue(Integer.parseInt(eElement.getElementsByTagName("value").item(0).getTextContent()));
                    gems.add(gem);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return gems;
    }
}
