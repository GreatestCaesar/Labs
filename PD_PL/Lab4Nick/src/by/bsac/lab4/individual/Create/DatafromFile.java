package by.bsac.lab4.individual.Create;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DatafromFile {
    public static String readFile(String filePath){
        FileInputStream fis = null;
        File file;
        byte[] buf;
        String txt = "";
        try{
            file = new File(filePath);
            fis = new FileInputStream(file);
            buf = new byte[fis.available()];
            fis.read(buf);
            fis.close();
            txt = new String(buf);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return txt;
    }
}
