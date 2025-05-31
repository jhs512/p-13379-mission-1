package me.kimtaekyung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {

    /*static int run(String str){
        String[] strSplit = str.trim().split(" ");

        int result=getInt(strSplit[0]);

        for(int i=1;i<strSplit.length;i+=2){
            int o=getInt(strSplit[i+1]);
            switch (strSplit[i]){
                case "+":
                    result+=o;
                    break;
                case "-":
                    result-=o;
                    break;
                case "*":
                    result*=o;
                    break;
            }
        }

        return result;
    }*/

    static int run(String str){
        str=str.replaceAll("[()]","");
        String[] strSplit=str.trim().split(" ");
        List<String> strList = new ArrayList<>(Arrays.asList(strSplit));

        int result = calc(strList);

        return result;
    }

    static int calc(List<String> list) {

        for (int i = 1; i < list.size(); i += 2) {
            if(list.get(i).equals("*")){
                list.set(i - 1, String.valueOf(getInt(list.get(i - 1)) * getInt(list.get(i + 1))));
                list.remove(i+1);
                list.remove(i);
                 return calc(list);
            }else if(list.get(i).equals("/")){
                list.set(i - 1, String.valueOf(getInt(list.get(i - 1)) / getInt(list.get(i + 1))));
                list.remove(i+1);
                list.remove(i);
                return calc(list);
            }
        }
        int result=getInt(list.get(0));

        for(int i=1;i<list.size();i+=2){
            int o = getInt(list.get(i + 1));
            switch (list.get(i)){
                case "+":
                    result+=o;
                    break;
                case "-":
                    result-=o;
                    break;
            }
        }
        return result;

    }
    static int getInt(String str){
        return Integer.parseInt(str.trim());
    }

}
