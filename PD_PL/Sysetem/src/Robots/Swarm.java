package Robots;

import Data.Input;
import Targets.Target;
import Point.*;
import Statistic.Error1Kind;
import Statistic.Error2Kind;
import java.util.ArrayList;

public class Swarm {
    public ArrayList<Robot> auction(ArrayList<Robot> swarm, ArrayList<Target>
            targets, double[][] trust){
        boolean[] opinion = setOpinion(swarm, trust);
        Point centre = new Point(0,0);
        if (swarm.size()>0) {
            centre = getCenterOfSwarm(swarm);
        }
        double p=0;
        int idTarget, idRobot;
        for (Robot robot: swarm) {
            robot.isFree = true;
        }
        nullSwarm: while (sizeSwarm(swarm)) {
            idTarget = getNearestTarget(p, centre, targets);
            if (idTarget == -1){
                break;
            }
            p = centre.distanceTo(targets.get(idTarget).coor);
            for (int i = 0; i < targets.get(idTarget).need; i++) {
                idRobot = getNearestRobot(swarm, targets.get(idTarget),
                        opinion);
                if (idRobot == -1){
                    break nullSwarm;
                }
                moveRobot(swarm.get(idRobot), targets.get(idTarget));
                if (swarm.get(idRobot).isGood) {
                    targets.get(idTarget).currentNeed--;
                }
            }
        }
        return swarm;
    }
    private Point getCenterOfSwarm(ArrayList<Robot> swarm){
        int meanX = 0,
                meanY = 0;
        for (Robot robot: swarm) {
            meanX += robot.coor.x();
            meanY += robot.coor.y();
        }
        if (swarm.size()==0){
            System.out.println(swarm);
            160
        }
        meanX /= swarm.size();
        meanY /= swarm.size();
        return new Point(meanX,meanY);
    }
    private int getNearestTarget(double distance, Point center,
                                 ArrayList<Target> targets){
        int idMin = -1;
        double min = 1000000000;
        for (Target target: targets) {
            if ((center.distanceTo(target.coor) < min) &&
                    (center.distanceTo(target.coor)>distance)) {
                min = center.distanceTo(target.coor);
                idMin = targets.indexOf(target);
            }
        }
        return idMin;
    }
    private boolean sizeSwarm(ArrayList<Robot> swarm){
        int size=0;
        for (Robot robot: swarm) {
            if (robot.isFree){
                size++;
            }
        }
        if (size > 0){
            return true;
        } else {
            return false;
        }
    }
    private int getNearestRobot(ArrayList<Robot> swarm,Target target,
                                boolean[] opinion){
        int idRobot = -1;
        double min = 1000000000;
        for (Robot robot: swarm) {
            if ((robot.coor.distanceTo(target.coor) < min) &&
                    (opinion[swarm.indexOf(robot)]) && (robot.isFree)){
                min = robot.coor.distanceTo(target.coor);
                idRobot = swarm.indexOf(robot);
            }
        }
        if (idRobot != -1) {
            swarm.get(idRobot).isFree = false;
        }
        return idRobot;
    }
    private void moveRobot(Robot robot, Target target){
        robot.coor = target.coor;
    }
    private boolean[] setOpinion(ArrayList<Robot> swarm, double[][] trust){
        boolean[] opinion = new boolean[swarm.size()];
        for (Robot robot: swarm) {
            opinion[swarm.indexOf(robot)] = checkTrust(robot, trust,
                    swarm.size());
        }
        return opinion;
    }
161
    private boolean checkTrust(Robot robot, double[][] trust, int
            swarmSize){
        if (trust[robot.id][0] >= Input.getEdge()) {
            if (swarmSize>1) {
                if (robot.isGood) {
                    Error1Kind.update(true);
                } else {
                    Error2Kind.update(true);
                }
            }
            return true;
        } else {
            if (swarmSize>1) {
                if (robot.isGood) {
                    Error1Kind.update(false);
                } else {
                    Error2Kind.update(false);
                }
            }
            return false;
        }
    }
}

