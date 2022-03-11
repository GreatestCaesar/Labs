package IPW2.Example3;

public class FileThread extends Thread{
    String str;
    SynchroFile sf;
    public FileThread(String str,SynchroFile sf){
        this.str=str;
        this.sf=sf;
    }
    public void run(){
        for(int i=0;i<10;i++){
            sf.writing(str,i);
        }
    }
}
