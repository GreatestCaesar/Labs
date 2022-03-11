package by.bsac.practical.individual;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XMLMedicine {
    public ArrayList<Medicine> xml(){
        ArrayList<Medicine> medicines = new ArrayList<>();
        Medicine medicine;
        try{
            File fXmlFile = new File("src/by/bsac/practical/individual/medicine.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("drug");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                medicine = new Medicine();
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    medicine.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    medicine.setPharm(eElement.getElementsByTagName("pharm").item(0).getTextContent());
                    medicine.setGroup(eElement.getElementsByTagName("group").item(0).getTextContent());
                    medicine.setAnalogs(eElement.getElementsByTagName("analogs").item(0).getTextContent());
                    medicine.setVersions(eElement.getElementsByTagName("versions").item(0).getTextContent());
                    medicine.setCertificate(eElement.getElementsByTagName("certificate").item(0).getTextContent());
                    medicine.setPackagee(eElement.getElementsByTagName("package").item(0).getTextContent());
                    medicine.setDosage(eElement.getElementsByTagName("dosage").item(0).getTextContent());
                    medicines.add(medicine);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return medicines;
    }
}
