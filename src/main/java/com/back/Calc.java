package com.back;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    public static int addNumbers(String expression) {
        String[] expressionBits =  expression.split(" \\+ ");

        int num1 = Integer.parseInt(expressionBits[0]);
        int num2 = Integer.parseInt(expressionBits[1]);
        return num1 + num2;
    }

    public static int subtractNumbers(String expression) {
        String[] expressionBits =  expression.split(" \\- ");

        int num1 = Integer.parseInt(expressionBits[0]);
        int num2 = Integer.parseInt(expressionBits[1]);
        return num1 - num2;
    }

    public static int addThreeNumbers(String expression) {
        String[] expressionBits =  expression.split(" \\+ ");

        int num1 = Integer.parseInt(expressionBits[0]);
        int num2 = Integer.parseInt(expressionBits[1]);
        int num3 = Integer.parseInt(expressionBits[2]);
        return num1 + num2 + num3;
    }

    public static int calculateExpression(String expression) {
        String[] expressionBits = expression.split(" ");
        int result = Integer.parseInt(expressionBits[0]);
        for (int i = 1; i < expressionBits.length; i += 2) {
            String operator = expressionBits[i];
            int number = Integer.parseInt(expressionBits[i + 1]);
            if (operator.equals("+")) {
                result += number;
            } else if (operator.equals("-")) {
                result -= number;
            }
        }
        return result;
    }
    public static int productExpression(String expression) {
        String[] expressionBits = expression.split(" ");
        int result = Integer.parseInt(expressionBits[0]);
        for (int i = 1; i < expressionBits.length; i += 2) {
            String operator = expressionBits[i];
            int number = Integer.parseInt(expressionBits[i + 1]);
            if (operator.equals("*")) {
                result *= number;
            }
        }
       return result;
    }
}
