package Targets;

import Point.Point;

public class Target {
    public Point coor;
    public int id,
            need,
            currentNeed;
    public Target(Point coordinates, int id, int need){
        this.coor = coordinates;
        this.id=id;
        this.need = need;
        this.currentNeed = need;
    }
    @Override
    public String toString() {return "Target "+id+" :"+coor+" "+need;}
}
