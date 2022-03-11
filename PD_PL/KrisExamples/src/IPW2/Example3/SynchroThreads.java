package IPW2.Example3;

public class SynchroThreads {
    public static void main(String [ ] args){
        SynchroFile sf= new SynchroFile();//объектклассаSynchroFile
        FileThread ft1=new FileThread("FisrtThread",sf);//первыйпоток
        FileThread ft2=new FileThread("SecondThread",sf);//второйпоток
        ft1.start(); //стартовать первый поток
        ft2.start(); //стартовать второй поток
    }
}
