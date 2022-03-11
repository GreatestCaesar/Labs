package by.bsac.practical6.individual;

public class Main {
    public static void main(String[] args){
        PlaceOfWork placeOfWork = new PlaceOfWork();
        Privileges privileges = new Privileges();
        Rewards rewards = new Rewards();
        placeOfWork.create();
        privileges.create();
        rewards.create();
        new Synch(placeOfWork);
        new Synch(privileges);
        new Synch(rewards);
    }
}
