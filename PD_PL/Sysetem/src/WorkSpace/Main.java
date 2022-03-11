package WorkSpace;

import Data.*;
import Graphic.ExperimentFrame;

import java.awt.*;
import java.io.File;
import java.math.BigDecimal;

import static sun.security.util.KnownOIDs.Data;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        deleteOldResult();
        //В этих 2-х строках выкидывает ошибку NullPointer (я умнее Кати )
        ExperimentFrame f = new ExperimentFrame();
        Graphics g = f.getGraphics();
        defineSaboteurType( f, g);
    }
    private static void defineSaboteurType( ExperimentFrame f, Graphics g )
            throws InterruptedException{
        Input.A = new BigDecimal("0");
        getExperiment(f, g);
    }
    private static void getExperiment( ExperimentFrame f, Graphics g) throws
            InterruptedException {
        double[] result = new double[3];
        double[] currentResult = new double[2];
        currentResult[0]=0; currentResult[1]=0;
        result[0] = 0; result[1] = 0; result[2] = 0;
        while (Input.haveNext(currentResult[0], currentResult[1])){
            currentResult = Iteration.iteration(f, g);
        }
    }
    private static void deleteOldResult(){
        File file = new File("result.csv");
        if(file.delete()){
            System.out.println("Старый файл удален");
        }else System.out.println("Файла не обнаружено");
    }
}
