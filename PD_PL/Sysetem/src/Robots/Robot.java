package Robots;

import java.util.ArrayList;
import Point.*;
import Targets.*;
import Data.Input;
public class Robot {
    public Boolean isGood;
    public int id;
    public Point coor;
    public ArrayList<Double> DtTs = new ArrayList<Double>();
    public boolean isFree;
    public Input.Saboteur saboteurType;
    private double trustInMe=0;
    public Robot(Point coordinates, boolean goodness, int id, Input.Saboteur
            sabType){
        this.coor = coordinates;
        this.isGood = goodness;
        this.id=id;
        this.saboteurType = sabType;
    }
    @Override
    public String toString() {return "Robots " +id+" :"+coor+" "+isGood+"
        "+isFree;}
        public boolean checkDistance(Target target){
            if (coor.distanceTo(target.coor)==DtTs.get(target.id)){
                return true;
            } else {
                return false;
            }
        }
        public void setTrustInMe(double trustInMe) {
            this.trustInMe = trustInMe;
        }
        public void distanceToTarget(ArrayList<Target> targets) {
            for (Target target : targets) {
                if (isGood) {
                    DtTs.add(coor.distanceTo(target.coor));
                } else {
                    if ((Input.saboteurType!=Input.Saboteur.smartTrust) &&
                            (Input.saboteurType!=Input.Saboteur.smartsmart)) {
                        DtTs.add(coor.distanceTo(target.coor) / 2);
                    } else {
                        if (trustInMe >= 0.8) {
                            DtTs.add(0.1);
                        } else {
                            DtTs.add(coor.distanceTo(target.coor));
                        }
                    }
                }
            }
        }
    }

