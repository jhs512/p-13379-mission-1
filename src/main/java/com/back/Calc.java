package com.back;

public class Calc {
    public static int run(String expression) {

        String[] bits = expression.split(" ");

        int current = Integer.parseInt(bits[0]);
        int result = 0;
        String operator = "+";

        for (int i = 1; i < bits.length; i += 2) {
            String op = bits[i];
            int number = Integer.parseInt(bits[i + 1]);

            if (op.equals("*")) {
                current *= number;
            } else {
                if (operator.equals("+")) result += current;
                else if (operator.equals("-")) result -= current;

                operator = op;
                current = number;
            }
        }

        if (operator.equals("+")) result += current;
        else if (operator.equals("-")) result -= current;

        return result;
    }

}