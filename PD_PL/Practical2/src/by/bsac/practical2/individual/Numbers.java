package by.bsac.practical2.individual;

public class Numbers {
    public static void main(String[] args){
        int[] arr = new int[100];

        for(int i=0;i<arr.length;i++){
            arr[i] = (int)((Math.random()*20000)-10000);
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        int temp=0;
        String str1="";
        String str2="";
        for(int i=0;i<arr.length;i++){
            str1="";
            for(int j=i+1;j<arr.length;j++) {
                str2="";
                if(arr[i]<0){
                    if(arr[j]<0){
                        str1=arr[i]+"";
                        str2=arr[j]+"";
                        if(str1.substring(1,str1.length()).length()>str2.substring(1,str2.length()).length()){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                        str1="";
                        str2="";
                    }else{
                        str1=arr[i]+"";
                        str2=arr[j]+"";
                        if(str1.substring(1,str1.length()).length()>str2.substring(0,str2.length()).length()){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                        str1="";
                        str2="";
                    }
                    str1="";
                    str2="";
                }else{
                    if(arr[j]<0){
                        str1=arr[i]+"";
                        str2=arr[j]+"";
                        if(str1.substring(0,str1.length()).length()>str2.substring(1,str2.length()).length()){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                        str1="";
                        str2="";
                    }else{
                        str1=arr[i]+"";
                        str2=arr[j]+"";
                        if(str1.substring(0,str1.length()).length()>str2.substring(0,str2.length()).length()){
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                        str1="";
                        str2="";
                    }
                    str1="";
                    str2="";
                }
            }
        }

        System.out.println("\n---------------------------------------------------------------------------------------\nSorted:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
