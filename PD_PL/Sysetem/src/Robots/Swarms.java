package Robots;

import java.util.ArrayList;
import java.util.Random;
import Data.Constants;
import Data.Input;
import Point.Point;
import Targets.Target;
public class Swarms {
    public ArrayList<ArrayList<Robot>> swarms = new
            ArrayList<ArrayList<Robot>>();
    final static Random random = new Random();
    public static int mapSize;
    public int countSwarms,
            countRobots;
    public void generateMap() {
        int index = 0;
        Point nextRobot;
        countSwarms = Data.Input.getCountSwarms();
        countRobots = Data.Input.getCountRobots();
        mapSize = mapSize(countRobots);
        ArrayList<Integer> countRobotsInSwarms =
                countRobotsInSwarms(countSwarms, countRobots),
                countBadRobotsInSwarms =
                        countBadRobotsInSwarms(countSwarms, countRobotsInSwarms);
        for (int i = 0; i < countSwarms; i++) {
            ArrayList<Robot> swarm = new ArrayList<Robot>();
            if (Data.Input.getPercentBadRobots() == 100){
                swarm.add(new Robot(CoorFirstRobotinSwarm(i, mapSize), false,
                        index++, Input.getSaboteurType()));
            } else {
                162
                swarm.add(new Robot(CoorFirstRobotinSwarm(i, mapSize), true,
                        index++, Input.Saboteur.none));
            }
            for (int j = 1; j < countRobotsInSwarms.get(i); j++) {
                nextRobot = coorNextRobot(swarm.get(swarm.size() - 1).coor,
                        i, mapSize);
                if (Data.Input.getPercentBadRobots()!=0 && j %
                        (100/Data.Input.getPercentBadRobots()) != 0) {
                    swarm.add(new Robot(nextRobot, true, index++,
                            Input.Saboteur.none));
                } else {
                    swarm.add(new Robot(nextRobot, false, index++,
                            Input.getSaboteurType()));
                }
            }
            swarms.add(swarm);
        }
    }
    private void clearDistanceToTargets(){
        for (ArrayList<Robot> swarm: swarms ) {
            for (Robot robot: swarm) {
                robot.DtTs.clear();
            }
        }
    }
    public void filingDistanceToTargets(ArrayList<Target> targets){
        clearDistanceToTargets();
        for (ArrayList<Robot> swarm: swarms ) {
            for (Robot robot: swarm) {
                robot.distanceToTarget(targets);
            }
        }
    }
    private int mapSize(int countRobots){
        return 2*((int)Math.sqrt(countRobots)-
                1)*Constants.radiusInteraction;
    }
    private ArrayList<Integer> countRobotsInSwarms(int countSwarms, int
            countRobots){
        ArrayList<Integer> countRobotsInSwarms = new ArrayList<Integer>();
        for (int i = 0; i < countSwarms-1; i++) {
            countRobotsInSwarms.add(countRobots/countSwarms);
        }
        countRobotsInSwarms.add(countRobots -
                (countRobots/countSwarms)*(countSwarms-1));
        return countRobotsInSwarms;
    }
    private ArrayList<Integer> countBadRobotsInSwarms(int countSwarms,
                                                      ArrayList<Integer> countRobotsInSwarms){
        ArrayList<Integer> countBadRobotsInSwarms = new ArrayList<Integer>();
        for (int i = 0; i < countSwarms; i++) {

            countBadRobotsInSwarms.add(Data.Input.getPercentBadRobots()*countRobotsInSwar
                    ms.get(i)/100);
        }
        return countBadRobotsInSwarms;
    }
163
    private Point CoorFirstRobotinSwarm(int numberOfSwarm, int mapSize) {
        int x = random.nextInt(mapSize);
        int y = random.nextInt(mapSize);
        while (!checkPoint(new Point(x,y))) {
            x = random.nextInt(mapSize);
            y = random.nextInt(mapSize);
        }
        return new Point(x, y);
    }
    private Point coorNextRobot(Point X, int numberOfSwarm, int mapSize){
        int y = X.y(),
                x = X.x();
        int x1 = x+random.nextInt(2* Constants.radiusInteraction)-
                Constants.radiusInteraction;
        int y1 = y+random.nextInt(2* Constants.radiusInteraction)-
                Constants.radiusInteraction;
// Проверка точки
        while (!checkPoint(new Point(x1,y1))){
            x1 = x+random.nextInt(2* Constants.radiusInteraction)-
                    Constants.radiusInteraction;
            y1 = y+random.nextInt(2* Constants.radiusInteraction)-
                    Constants.radiusInteraction;
        }
        return new Point(x1,y1);
    }
    private boolean checkPoint(Point p){
        for (ArrayList<Robot> swarm: swarms){
            for (Robot robot: swarm) {
                if (p.distanceTo(robot.coor)<=Constants.radiusInteraction*3){
                    return false;
                }
            }
        }
        if ((p.x()<5) || (p.x()>mapSize-5) || (p.y()<5) || (p.y()>mapSize5)){
            return false;
        }
        return true;
    }
    public ArrayList<ArrayList<Robot>>
    RedistributionOfRobotsInSwarms(ArrayList<Target> targets){
        int amountSwarms = swarms.size(),
                amountRobots;
        Robot robotStorage;
        for (int i = 0; i < targets.size(); i++) {
            swarms.add(new ArrayList<Robot>());
        }
        for (int i = 0; i < amountSwarms; i++) {
            amountRobots = swarms.get(i).size();
            for (int j = 0; j < amountRobots; j++) {
                if (!swarms.get(i).get(j).isFree){
                    robotStorage = swarms.get(i).get(j);
                    swarms.get(i).remove(swarms.get(i).get(j));

                    swarms.get(amountSwarms+findTarget(robotStorage,targets)).add(robotStorage);
                    j--;
                    amountRobots--;
                    if (swarms.get(i).size()==0){
                        164
                        break;
                    }
                }
            }
        }
        deleteNullSwarm(amountSwarms);
        changeStatus();
        return swarms;
    }
    private int findTarget(Robot robot, ArrayList<Target> targets){
        for (Target target: targets) {
            if(target.coor == robot.coor){
                return target.id;
            }
        }
        return -1;
    }
    private void deleteNullSwarm(int amountSwarms){
        for (int i = 0; i < amountSwarms; i++) {
            if (swarms.get(i).size() == 0){
                swarms.remove(swarms.get(i));
                amountSwarms--;
                i--;
            }
        }
    }
    private void changeStatus(){
        for (ArrayList<Robot> swarm: swarms) {
            for (Robot robot: swarm) {
                robot.isFree = true;
            }
        }
    }
}

