package by.bsac.practical4.strings;

public class RefStringBuilder {
    public static void changeStr(StringBuilder s) {
        s.append(" Certified");
    }
    public static void main(String[ ] args) {
        StringBuilder str = new StringBuilder("Oracle");
        changeStr(str);
        System.out.println(str);
    }
}
