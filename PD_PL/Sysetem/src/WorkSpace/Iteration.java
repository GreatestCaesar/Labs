package WorkSpace;

import java.util.ArrayList;
import Data.Input;
import Robots.*;
import java.util.concurrent.TimeUnit;
import Robots.Robot;
import Statistic.Error1Kind;
import Statistic.Error2Kind;
import Targets.Targets;
import Trust.*;
import java.awt.*;
import Graphic.ExperimentFrame;
public class Iteration {
    public static double[] iteration(ExperimentFrame f, Graphics g) throws
            InterruptedException {
        //Начальный блок генерации карты
        Swarm swarm = new Swarm();
        Swarms swarms = new Swarms();
        171
        Targets targets = new Targets();
        Error1Kind error1 = new Error1Kind();
        Error2Kind error2 = new Error2Kind();
        //Создание карты, целей
        swarms.generateMap();
        targets.levelUp(swarms.countRobots);
        //Графика
        if (swarms.swarms == null) {
            TimeUnit.SECONDS.sleep(5);
        }
        try {
            f.updateData(swarms.swarms, targets.targets, swarms.countRobots,
                    error1.get(), error2.get(), true, 0);
            f.paint(g);
            TimeUnit.SECONDS.sleep(4);
        } catch (NullPointerException e) {
            System.out.println("Error");
        }
        //Начальный блок доверия
        Verity verity = new Verity(swarms.countRobots);
        Reputation reputation = new Reputation(swarms.countRobots);
        Trust trust = new Trust();
        for (int i = 0; i < Input.getCountLevels(); i++) {
            System.out.print(".");
            swarms.filingDistanceToTargets(targets.targets);
            ////Определение параметров доверия - каждую итерацию
            double[][][] verityTable = verity.reVerity(swarms.swarms,
                    targets.targets, i);
            reputation.reReputation(i, swarms.swarms);
            double[][] trustTable = trust.reTrust(swarms.swarms, verityTable,
                    swarms.countRobots, targets.targets.size());
            for (ArrayList<Robot> currentSwarm : swarms.swarms) {
                currentSwarm = swarm.auction(currentSwarm, targets.targets,
                        trustTable);
            }
            //Распределение роботов по новым роям
            swarms.swarms =
                    swarms.RedistributionOfRobotsInSwarms(targets.targets);
            //Создание целей
            targets.levelUp(swarms.countRobots);
        }
        double[] result = new double[4];
        result[0] = error1.get();
        result[1] = error2.get();
        return result;
    }
}

