package by.bsac.practical8.examples;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
/*
Чтение XML документа, используя DOM парсер
*/
public class TestDOMXMLParser {
    public static Integer totalStudents = 0;
    public static Integer totalTeacher = 0;
    public static void main(String argv[]) {
        try {
            File fXmlFile = new File("src\\by\\bsac\\practical8\\examples\\test.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            //optional, but recommended
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("student");
            System.out.println("----------------------------");
            totalStudents = nList.getLength();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("First Name : " +
                            eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " +
                            eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Class : " +
                            eElement.getElementsByTagName("class").item(0).getTextContent());
                }
            }
            System.out.println("Students total count: " + totalStudents);
            totalStudents = 0;
            nList = doc.getElementsByTagName("teacher");
            System.out.println("----------------------------");
            totalTeacher = nList.getLength();
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("First Name : " +
                            eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " +
                            eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Salary : " +
                            eElement.getElementsByTagName("salary").item(0).getTextContent());
                }
            }
            System.out.println("Teachers total count: " + totalTeacher);
            totalTeacher = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
