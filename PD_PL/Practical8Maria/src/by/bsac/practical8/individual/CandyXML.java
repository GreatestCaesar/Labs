package by.bsac.practical8.individual;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CandyXML {
    public static ArrayList<Candy> getInfFromXml() throws ParserConfigurationException, IOException{
        ArrayList<Candy> candies = new ArrayList<>();
        Candy candy = null;
        try {
            File fXmlFile = new File("src\\by\\bsac\\practical8\\individual\\candy.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("candy");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                candy = new Candy();
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    candy.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    candy.setEnergy(Double.parseDouble(eElement.getElementsByTagName("energy").item(0).getTextContent()));
                    candy.setType(eElement.getElementsByTagName("type").item(0).getTextContent());
                    NodeList ingList = eElement.getElementsByTagName("ingredients");
                    for(int j = 0; j < ingList.getLength(); j++){
                        Node ingNode = ingList.item(j);
                        if(ingNode.getNodeType() == Node.ELEMENT_NODE){
                            Element ingElement = (Element) ingNode;
                            candy.setShugar(Double.parseDouble(ingElement.getElementsByTagName("shugar").item(0).getTextContent()));
                            candy.setFructose(Double.parseDouble(ingElement.getElementsByTagName("fructose").item(0).getTextContent()));
                            candy.setVanilin(Double.parseDouble(ingElement.getElementsByTagName("vanillin").item(0).getTextContent()));
                        }
                    }
                    NodeList valList = eElement.getElementsByTagName("values");
                    for(int k = 0; k < valList.getLength(); k ++){
                        Node valNode = valList.item(k);
                        if(valNode.getNodeType() == Node.ELEMENT_NODE){
                            Element valElement = (Element) valNode;
                            candy.setProteins(Double.parseDouble(valElement.getElementsByTagName("proteins").item(0).getTextContent()));
                            candy.setFats(Double.parseDouble(valElement.getElementsByTagName("fats").item(0).getTextContent()));
                            candy.setCarbohydrates(Double.parseDouble(valElement.getElementsByTagName("carbohydrates").item(0).getTextContent()));
                        }
                    }
                    candy.setProduction(eElement.getElementsByTagName("production").item(0).getTextContent());
                    candies.add(candy);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return candies;
    }
}
