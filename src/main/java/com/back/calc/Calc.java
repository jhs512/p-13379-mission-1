package com.back.calc;

import java.util.Arrays;
import java.util.List;

public class Calc {
    public static int run(String input) {
        int count = 0;
        int parenthesesCount = 0;
        input = input.replace("(", "");

        input = input.replace(")", "");
        String[] parts = input.split(" ");
        int result2 = 0;
        int result = 0;
        int result3 = 0;


        int length = parts.length;


        if (length == 3) {

            result= Integer.parseInt(parts[0]);

            result2 = Integer.parseInt(parts[2]);
            String operator = parts[1];
            return CalcInput(result, result2, operator);


        }
        for (int i = 1; i < length; i+=2) {
            if(parts[i].equals("*") || parts[i].equals("/")) {
                result = Integer.parseInt(parts[i-1]);
                result2 = Integer.parseInt(parts[i+1]);
                result3 = CalcInput(result, result2, parts[i]);

                parts[i-1] = String.valueOf(result3);
                for(int j= i; j < length-2; j++) {
                    parts[j] = parts[j+2];


                }
                length -= 2;
                if(length == 3){
                    result = Integer.parseInt(parts[0]);
                    result2 = Integer.parseInt(parts[2]);
                    String operator = parts[1];
                    return CalcInput(result, result2, operator);
                }


            }
        }
        result = Integer.parseInt(parts[0]);
        result2 = Integer.parseInt(parts[2]);

        result3 = CalcInput(result, result2, parts[1]);
        String[] frontParts = Arrays.copyOfRange(parts, 3, length);
        String newinput = result3 + " " + String.join(" " , frontParts);
        return run(newinput);



    }

    public static int CalcInput(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

}
