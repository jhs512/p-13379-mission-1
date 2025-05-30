package com.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {

    public static int run(String expression) {
        //-1 * ( 8 + 2 ) * -1 * ( 7 + 3 ) + 5
        expression = expression
                .replaceAll("-\\(", "-1 * (")
                .replaceAll("\\(", "( ")
                .replaceAll("\\)", " )");

        List<String> tokens = new ArrayList<>(Arrays.asList(expression.split(" ")));

        dps(tokens);

        return Integer.parseInt(tokens.getFirst());
    }

    private static void dps(List<String> tokens) {
        if(tokens.size() ==1) return;
        //-1 * ( 8 + 2 ) * -1 * ( 7 + 3 ) + 5
        if (tokens.contains("(")) {
            int openIndex = tokens.lastIndexOf("(");
            int closeIndex = -1;
            for (int i = openIndex + 1; i < tokens.size(); i++) {
                if (tokens.get(i).equals(")")) {
                    closeIndex = i;
                    break;
                }
            }
            if(closeIndex == -1) {
                System.out.println("식이 틀렸습니다");
                return;
            }
            List<String> subExpression = tokens.subList(openIndex + 1, closeIndex);
            int result = run(String.join(" ", subExpression));

            tokens.add(openIndex , Integer.toString(result));
            for (int i = closeIndex + 1; i > openIndex; i--) {
                tokens.remove(i);
            }

            dps(tokens);
        } else if (tokens.contains("*")) {
            int operatorIndex = tokens.indexOf("*");
            int leftOperand = Integer.parseInt(tokens.get(operatorIndex - 1));
            int rightOperand = Integer.parseInt(tokens.get(operatorIndex + 1));
            int result = leftOperand * rightOperand;

            tokens.add(operatorIndex -1, Integer.toString(result));
            tokens.remove(operatorIndex);
            tokens.remove(operatorIndex);
            tokens.remove(operatorIndex);

            dps(tokens);
        } else {
            int token = Integer.parseInt(tokens.getFirst());
            String operator = tokens.get(1);
            int nextToken = Integer.parseInt(tokens.get(2));

            int result = operator.equals("+") ? token + nextToken : token - nextToken;

            tokens.removeFirst();
            tokens.removeFirst();
            tokens.removeFirst();
            tokens.addFirst(Integer.toString(result));

            dps(tokens);
        }
    }
}
