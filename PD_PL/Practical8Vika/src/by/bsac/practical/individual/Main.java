package by.bsac.practical.individual;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Medicine> medicines = new ArrayList<>(new XMLMedicine().xml());
        for(Medicine m : medicines){
            System.out.println(m);
        }
    }
}
