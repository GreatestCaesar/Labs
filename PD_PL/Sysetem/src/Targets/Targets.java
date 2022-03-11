package Targets;

import Data.Constants;
import Robots.*;
import java.util.ArrayList;
import java.util.Random;
import Point.*;

public class Targets {
    public ArrayList<Target> targets = new ArrayList<Target>();
    final static Random random = new Random();
    public void levelUp(int countRobots){
        int countTargets = random.nextInt(5)+5;
        targets.clear();
        //Общая потребность целей 100%
        int needCurrentTarget;
        for (int i = 0; i < countTargets-1; i++) {
            Data.Constants.updateTargetNeedPercent();
            needCurrentTarget = (countRobots/countTargets)*
                    Constants.targetNeedPercent/100;
            targets.add(new Target(new Point(random.nextInt(Swarms.mapSize),
                    random.nextInt(Swarms.mapSize)), i, needCurrentTarget));
        }
        Data.Constants.updateTargetNeedPercent();
        needCurrentTarget = (countRobots -
                (countRobots/countTargets)*(countTargets-1))*Constants.targetNeedPercent/100;
        targets.add(new Target(new Point(random.nextInt(Swarms.mapSize),
                random.nextInt(Swarms.mapSize)), countTargets-1, needCurrentTarget));
    }
}

