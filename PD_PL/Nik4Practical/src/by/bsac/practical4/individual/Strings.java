package by.bsac.practical4.individual;

public class Strings {
    public static void main(String[] args) {
        char[] symbols = {'!','@','#','$','%','^','&','*','(',')','_','+','"','№',';',':','?','-','=',',','.','«','»','—'};
        StringBuffer text = new StringBuffer("«На какое дело хочу покуситься и в то же время каких пустяков боюсь! " +
                "— подумал он с странною улыбкой. — Гм... да... всё в руках человека, и всё-то он мимо носу " +
                "проносит, единственно от одной трусости... это уж аксиома... Любопытно, чего люди больше всего " +
                "боятся? Нового шага, нового собственного слова они всего больше боятся... А впрочем, я слишком много " +
                "болтаю. Оттого и ничего не делаю, что болтаю. Пожалуй, впрочем, и так: оттого болтаю, что ничего не делаю. " +
                "Это я в этот последний месяц выучился болтать, лежа по целым суткам в углу и думая... о царе Горохе. Ну зачем я " +
                "теперь иду? Разве я способен на это? Разве это серьезно? Совсем не серьезно. Так, ради фантазии сам себя тешу; игрушки! " +
                "Да, пожалуй что и игрушки!»");

        if(text.indexOf(" ") == -1){
            text.insert((int) (Math.random()*text.length()+0)," ");
        }

        while(avail(text, symbols)){
            for(int i=0;i< symbols.length;i++){
                if(text.indexOf(String.valueOf(symbols[i])) != -1) {
                    text.deleteCharAt(text.indexOf(String.valueOf(symbols[i])));
                }
            }
        }

        System.out.println(text);
    }

    public static boolean avail(StringBuffer t, char[] symbols){
        for(int i=0;i<t.length();i++){
            for(int j=0;j< symbols.length;j++){
                if(symbols[j] == t.charAt(i)){
                    return true;
                }
            }
        }
        return false;
    }
}
