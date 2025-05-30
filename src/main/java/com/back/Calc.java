package com.back;

public class Calc {

    public static int run(String s) {
        String[] cmdBits = s.split(" ");
        int result = Integer.parseInt(cmdBits[0]);

        for (int index = 1; index < cmdBits.length; index+=2) {
            int num2 = Integer.parseInt(cmdBits[index+1]);

            switch (cmdBits[index]) {
                case "+" :
                    result = plus(result, num2);
                    break;
                case "-" :
                    result = minus(result, num2);
                    break;
                case "*" :
                    result = multiply(result, num2);
                    break;
            }
        }

        return result;
    }

    public static int plus(int num1, int num2) {
        return num1 + num2;
    }

    public static int minus(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

}
