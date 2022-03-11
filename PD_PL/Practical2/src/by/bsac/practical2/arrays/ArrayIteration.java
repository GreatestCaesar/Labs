package by.bsac.practical2.arrays;

public class ArrayIteration{
    public static void main(String []args)
    {
        int myarr[] = { 2, 5 , 10 ,35 ,100 };
        int result = 0;
        int i;

        for(i = 0; i < 5; i++)
        {
            result = result + myarr[i];
        }
        System.out.println("Sum = "+ result);
    }
}