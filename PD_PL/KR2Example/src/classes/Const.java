package classes;

import java.util.ArrayList;

public class Const {
    private static Const aConst;

    public static synchronized Const getInstance(){
        if (aConst==null){
            aConst=new Const();
        }
        return aConst;
    }

    public static final String SALES_TABLE = "sales";
    public static final String SALES_ID = "idsales";
    public static final String SALES_MODEL = "model";
    public static final String SALES_SELLER = "seller";
    public static final String SALES_COST   = "cost";
    public static final String SALES_DATE = "date";

    public static ArrayList<String> sellers = new ArrayList<>();
    public static ArrayList<String> models = new ArrayList<>();

    private Const(){
        sellers.add("Иванов");
        sellers.add("Смирнов");
        sellers.add("Соболев");
        sellers.add("Сидоров");
        sellers.add("Петров");

        models.add("LG");
        models.add("Samsung");
        models.add("Panasonic");
        models.add("Horizont");
    }
}
