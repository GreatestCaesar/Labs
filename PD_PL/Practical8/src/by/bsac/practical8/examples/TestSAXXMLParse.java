package by.bsac.practical8.examples;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
/*
Чтение XML документа, используя SAX парсер
*/
class TestSAXXMLParser {
    public static void main(String[] args) {
        InputStream inputStream = null;
        Reader reader = null;
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler();
            inputStream = new FileInputStream("E:\\PD&PL\\Practical8\\src\\by\\bsac\\practical8\\examples\\test.xml");
            reader = new InputStreamReader(inputStream, "UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");
            saxParser.parse(is, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    System.out.println("Error closing InputStreamReader: " + e);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    System.out.println("Error closing FileInputStream: "+e);
                }
            }
        }
    }
}
