package by.bsac.practical5.individual.Task4.Exception;

public class NumbersInTheText extends Exception{
    private String error;

    public NumbersInTheText(String txt){
        error = txt;
    }

    @Override
    public String toString() {
        return "В тексте '" + error + "' есть цифра";
    }
}
