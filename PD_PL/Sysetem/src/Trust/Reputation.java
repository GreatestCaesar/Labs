package Trust;

import Robots.*;
import java.util.ArrayList;
/**
 * Created by Vasovski on 19.07.2017.
 */
public class Reputation {
    private double[][] notNormReputation;
    public static double[][] reputation;
    public Reputation(int countRobots) {
        notNormReputation = new double[countRobots][countRobots];
        reputation = new double[countRobots][countRobots];
    }
    public void reReputation(int iteration, ArrayList<ArrayList<Robot>>
            swarms) {
        for (ArrayList<Robot> swarm : swarms) {
            for (Robot obj : swarm) {
                for (Robot sub : swarm) {
                    if (obj.id != sub.id) {
                        if (iteration > 0) {
                            if (Verity.normVerity[obj.id][sub.id] >= 0.5) {
                                166
                                notNormReputation[obj.id][sub.id] +=
                                        Verity.normVerity[obj.id][sub.id];
                            } else {
                                notNormReputation[obj.id][sub.id] =
                                        notNormReputation[obj.id][sub.id] - ((notNormReputation[obj.id][sub.id] /
                                                (iteration) - Math.pow(2.7, -1 * (iteration + 1) * (1 -
                                                Verity.normVerity[obj.id][sub.id]))));
                            }
                        } else {
                            notNormReputation[obj.id][sub.id] +=
                                    Verity.normVerity[obj.id][sub.id];
                        }
                    }
                }
            }
        }
        for (ArrayList<Robot> swarm : swarms) {
            for (Robot obj : swarm) {
                for (Robot sub : swarm) {
                    if (obj.id != sub.id) {
                        if (iteration > 0) {
                            reputation[obj.id][sub.id] =
                                    notNormReputation[obj.id][sub.id] / (Verity.meetengs[obj.id][sub.id]);
                        } else {
                            reputation[obj.id][sub.id] =
                                    notNormReputation[obj.id][sub.id];
                        }
                    }
                }
            }
        }
    }
}

