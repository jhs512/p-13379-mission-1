package com.back;

import java.util.ArrayList;
import java.util.List;

public class Calc {


    static int run(String s) {
        List<String> numList = new ArrayList<>();
        List<String> signList = new ArrayList<>();
        int cnt =0;



        signList = findSign(s, signList);
        numList = findNum(s);


        int result = Integer.parseInt(numList.get(cnt));
        numList.remove(cnt);



        result = calc(cnt, numList, signList, result);


        return result;
    }

    private static int calc(int cnt, List<String> numList, List<String> signList, int result) {

        if(numList.isEmpty()) return result;

        String op = signList.get(cnt);
        int num = Integer.parseInt(numList.get(cnt));

        switch(op) {
            case "+" -> result += num;
            case "-" -> result -= num;
            case "*" -> result *= num;
        }

        numList.remove(cnt);
        signList.remove(cnt);
        return calc(cnt,numList,signList, result);


    }

    private static List<String> findNum(String s) {
        String[] trim = s.split(" "); // [10, *, -10]
        List<String> sortNum = new ArrayList<>();

        for(String x : trim) {
            if(!x.equals("+") && !x.equals("-") && !x.equals("*")) {
                sortNum.add(x);
            }
        }
        return sortNum;
    }




    private static List<String> findSign(String s, List<String> signList) {
        //1+1
        String[] trim = s.split(" "); // [10,*,-10]

        for(String x : trim) { //1+1
            try {
                Integer.parseInt(x);
            } catch (NumberFormatException e) {
                signList.add(x);
            }
        }

        return signList;
    }
}
