package Trust;

import Data.Constants;
import Data.Input;
import Robots.*;
import Targets.*;
import java.util.ArrayList;
import java.util.Random;
public class Verity {
    public static double[][] normVerity;
    public static double[][] meetengs;
    int countRobots;
    final static Random random = new Random();
    public Verity(int countRobots) {
        this.countRobots = countRobots;
        normVerity = new double[countRobots][countRobots];
        meetengs = new double[countRobots][countRobots];
    }
    public double[][][] reVerity(ArrayList<ArrayList<Robot>> swarms,
                                 ArrayList<Target> targets, int iteration){
        double[][][] verity = new
                double[countRobots][countRobots][targets.size()];
        168
        // Выставения всем значения отсутсвия данных.
        for (int i = 0; i < countRobots; i++) {
            for (int j = 0; j < countRobots; j++) {
                for (int k = 0; k < targets.size(); k++) {
                    verity[i][j][k] = 0.5;
                }
            }
        }
        // Заполнение массива встреч
        for (ArrayList<Robot> swarm: swarms) {
            for (Robot obj : swarm) {
                for (Robot sub : swarm) {
                    if (obj.id != sub.id) {
                        meetengs[obj.id][sub.id]=meetengs[obj.id][sub.id]+1;
                    }
                }
            }
        }
// System.out.println("Выставление");
        //Выставление истинности соседей в зоне видимости
        for (ArrayList<Robot> swarm: swarms) {
            for (Robot obj : swarm) {
                for (Robot sub : swarm) {
                    if (obj.id != sub.id) {
                        if (obj.coor.distanceTo(sub.coor) <=
                                Constants.radiusVision) {
                            for (Target target : targets) {
// ВЫЗОВ МЕТОДА ВЫСТАВЛЕНИЯ ИСТИННОСТИ
                                verity[obj.id][sub.id][target.id] =
                                        getVerity(obj, sub, target, iteration);
// if (!obj.isGood){
// System.out.println(obj.id+" ->
                                "+sub.id+" = "+verity[obj.id][sub.id][target.id]);
// }
                            }
                        }
                    }
                }
            }
        }
// System.out.println("Опрос");
// Выставление истинности через опрос соседей
        for (Target target: targets) {
            for (ArrayList<Robot> swarm : swarms) {
                for (Robot obj : swarm) {
                    for (Robot sub : swarm) {
                        int count = 0;
                        if (obj.id != sub.id) {
                            if ((obj.coor.distanceTo(sub.coor) >
                                    Constants.radiusVision) && (obj.coor.distanceTo(sub.coor) <
                                    Constants.radiusVision+Constants.radiusInteraction)) {
                                for (Robot neighbor : swarm) {
                                    if ((obj.coor.distanceTo(neighbor.coor) <
                                            Constants.radiusInteraction) && (sub.coor.distanceTo(neighbor.coor) <
                                            Constants.radiusVision) && (verity[neighbor.id][sub.id][target.id] != 0.5)) {
                                        if ((obj.id != neighbor.id) &&
                                                (sub.id != neighbor.id)) {
                                            verity[obj.id][sub.id][target.id]
                                                    += verity[neighbor.id][sub.id][target.id];
                                            count++;
                                        }
                                        169
                                    }
                                }
                                if (count != 0) {
                                    verity[obj.id][sub.id][target.id] -= 0.5;
                                    verity[obj.id][sub.id][target.id] /=
                                            count;
                                }
                            }
                        }
                    }
                }
            }
        }
// Нормирование истинности по количеству целей
        for (int i = 0; i < countRobots; i++) {
            for (int j = 0; j < countRobots; j++) {
                double sum=0;
                for (int k = 0; k < targets.size(); k++) {
                    sum+= verity[i][j][k];
                }
                normVerity[i][j] = sum/targets.size();
            }
        }
        return verity;
    }
    private double getVerity(Robot obj, Robot sub, Target target, int
            iteration){
        if (obj.isGood){
            if (sub.checkDistance(target)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            switch(obj.saboteurType) {
                case BALLOT_STUFFING:
                    return 1;
                case BAD_MOUTH:
                    return 0;
                case inversion:
                    return inversion(sub, target);
                case ON_OFF:
                    return random.nextInt(2) == 0 ? legitimate(sub, target) :
                            inversion(sub, target);
                case smartTrust:
                    return legitimate(sub, target);
                case smartDist:
                    return smartDist(obj, sub, target, iteration);
                case none:
                    return legitimate(sub, target);
                case smartsmart:
                    return smartDist(obj, sub, target, iteration);
                default:
                    return 0;
            }
        }
    }
    private int smartDist(Robot obj, Robot sub, Target target, int
            iteration){
        if ((iteration == 0)){
            170
            return legitimate(sub, target);
        } else{
            if (sub.checkDistance(target)) {
                if(((1-
                        Input.A.doubleValue())*Reputation.reputation[obj.id][sub.id]+Input.A.doubleVa
                lue()<=0.6)&&(1-
                        Input.A.doubleValue())*Reputation.reputation[obj.id][sub.id]+Input.A.doubleVa
                lue()>=0.5){
                    return inversion(sub, target);
                }else {
                    return legitimate(sub, target);
                }
            } else{
                if(((1-
                        Input.A.doubleValue())*Reputation.reputation[obj.id][sub.id]<=0.5)&&(1-
                        Input.A.doubleValue())*Reputation.reputation[obj.id][sub.id]>=0.4){
                    return inversion(sub, target);
                }else {
                    return legitimate(sub, target);
                }
            }
        }
    }
    private int legitimate(Robot sub, Target target){
        if (sub.checkDistance(target)) {
            return 1;
        } else {
            return 0;
        }
    }
    private int inversion(Robot sub, Target target){
        if (sub.checkDistance(target)) {
            return 0;
        } else {
            return 1;
        }
    }
}
