package com.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {
    public static int run(String calc){
        List<String> calcList = new ArrayList<>(Arrays.stream(calc.split(" ")).toList());
        //곱셈 우선 계산
        while(calcList.contains("*")){
            int index = calcList.indexOf("*");
            int result = Integer.parseInt(calcList.get(index-1)) * Integer.parseInt(calcList.get(index+1));
            calcList.remove(index+1);
            calcList.remove(index);
            calcList.set(index-1, result+"");
        }

        //첫 시작은 숫자, 숫자 뒤에는 연산자가 온다는 가정
        int sum = Integer.parseInt(calcList.get(0));
        for(int i=1; i<calcList.size(); i+=2){
            switch(calcList.get(i)){
                case "+":
                    sum += Integer.parseInt(calcList.get(i+1));
                    break;
                case "-":
                    sum -= Integer.parseInt(calcList.get(i+1));
                    break;
            }
        }
        return sum;
    }
}
