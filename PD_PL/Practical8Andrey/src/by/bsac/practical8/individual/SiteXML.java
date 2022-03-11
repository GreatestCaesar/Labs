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

public class SiteXML {
    public static ArrayList<Site> fromXml(ArrayList<Site> sites) throws ParserConfigurationException, IOException, SAXException {
        Site site;
        try {
            File fXmlFile = new File("src/by/bsac/practical8/individual/sites.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("site");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                site = new Site();
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    site.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
                    site.setType(eElement.getElementsByTagName("type").item(0).getTextContent());
                    NodeList cList = eElement.getElementsByTagName("chars");
                    for(int temp1 = 0; temp1 < cList.getLength(); temp1++){
                        Node cNode = cList.item(temp1);
                        if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element cElement = (Element) cNode;
                            site.setEmail(cElement.getElementsByTagName("e-mail").item(0).getTextContent());
                            site.setNews(cElement.getElementsByTagName("news").item(0).getTextContent());
                            site.setFree(cElement.getElementsByTagName("free").item(0).getTextContent());
                        }
                    }
                    site.setAuthorize(eElement.getElementsByTagName("authorize").item(0).getTextContent());
                    sites.add(site);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return sites;
    }
}
