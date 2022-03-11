package Trust;

import Data.Input;
import Robots.*;
import java.util.ArrayList;
import java.util.Map;
public class Trust {
    public double[][] reTrust(ArrayList<ArrayList<Robot>> swarms,double[][][]
            verity, int countRobots, int countTargets){
        double A = Input.getAlpha();
        double B = 1-A;
        double[][][] confidence = new
                double[countRobots][countRobots][countTargets];
        double[][] normConfidence = new double[countRobots][countTargets];
        for (ArrayList<Robot> swarm: swarms) {
            for (Robot obj : swarm) {
                for (Robot sub : swarm) {
                    for (int i=0; i<countTargets; i++ ) {
                        if (obj.id!=sub.id) {
                            double v = verity[obj.id][sub.id][i], r =
                                    Reputation.reputation[obj.id][sub.id];
                            confidence[obj.id][sub.id][i] =
                                    167
                            Math.sqrt(v*v+r*r)-Math.sqrt((1-v)*(1-v)+(1-r)*(1-r));
                            //вес
//confidence[obj.id][sub.id][i] = (A *
                            verity[obj.id][sub.id][i] + B * Reputation.reputation[obj.id][sub.id]);
                        }
                    }
                }
            }
        }
        for (ArrayList<Robot> swarm: swarms) {
            for (Robot obj: swarm) {
                for (int j = 0; j < countTargets; j++) {
                    double sum=0;
                    int count = 0;
                    for (Robot sub: swarm) {
                        if ((obj.id != sub.id)) {
                            sum += confidence[sub.id][obj.id][j];
                            count++;
                        }
                    }
                    if (count != 0) {
                        normConfidence[obj.id][j] = sum / count;
                    }
                    obj.setTrustInMe(normConfidence[obj.id][j]);
                }
            }
        }
        return normConfidence;
    }
}

