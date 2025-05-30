package com;

import java.util.Arrays;

public class Calc {
    public static int run(String input) {
        String[] parts = input.split(" ");
        int result = 0;
        int j;
        if (input.contains("*") || input.contains("/")) {
            for (j = 0; j < parts.length; j++){
                if (parts[j].equals("*")) {
                    int number1 = Integer.parseInt(parts[j-1].trim());
                    int number2 = Integer.parseInt(parts[j+1].trim());
                    int sum = number1 * number2;
                    parts[j+1] = String.valueOf(sum);
                    parts[j-1] = "0";
                }
            }
            if (!input.contains("+") && !input.contains("-")) {
                return Integer.parseInt(parts[j-1].trim());
            }
        }
        for (int i = 0; i < parts.length; i++) {
            if(parts[i].equals("+")){
                i++;
                result += Integer.parseInt(parts[i]);
            }else if(parts[i].equals("-")){
                i++;
                result -= Integer.parseInt(parts[i]);
            } else if (parts[i].equals("*") || parts[i].equals("/")) {
                System.out.println("*");
                continue;
            } else {
                result += Integer.parseInt(parts[i]);
            }
        }
        return result;
    }
}