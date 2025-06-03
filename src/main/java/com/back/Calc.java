package com.back;

public class Calc {

    public static int run(String input) {
        String[] tokens = input.split(" ");

        int operatorIndex = 1;

        int result = Integer.parseInt(tokens[0]);
        for (operatorIndex = 1; operatorIndex < tokens.length; operatorIndex+=2) {
            if (tokens[operatorIndex].equals("+")) {
                result = result + Integer.parseInt(tokens[operatorIndex + 1]);
                continue;
            }
            if (tokens[operatorIndex].equals("-")) {
                result = result - Integer.parseInt(tokens[operatorIndex + 1]);
                continue;
            }
            if (tokens[operatorIndex].equals("*")) {
                result = result * Integer.parseInt(tokens[operatorIndex + 1]);
                continue;
            }
            if (tokens[operatorIndex].equals("/")) {
                result = result / Integer.parseInt(tokens[operatorIndex + 1]);
            }
        }

        return result;
    }
}
