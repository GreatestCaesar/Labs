package by.bsac.practical4.individual;

import java.util.Scanner;

public class StringEx {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String txt = "В тексте каждую букву заменить ее порядковым номером в алфавите.";
        String ind = "";
        char[] alp = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};

        for(int i=0;i<txt.length();i++){
            for(int j=0;j<alp.length;j++){
                if(String.valueOf(txt.charAt(i)).equalsIgnoreCase(String.valueOf(alp[j]))){
                    if(j<9){
                        ind += (j + 1) + "  ";
                        break;
                    }else{
                        ind += (j + 1) + " ";
                        break;
                    }
                }else if(j==alp.length-1 && !String.valueOf(txt.charAt(i)).equalsIgnoreCase(String.valueOf(alp[j]))){
                    ind += "?  ";
                    break;
                }
            }
        }

        for(int i=0;i<txt.length();i++){
            System.out.print(txt.charAt(i)+"  ");
        }
        System.out.println();
        System.out.println(ind);
    }
}
