package com.back;

public class Calc {
    static int run(String expression){
        expression = expression.trim();
        String[] exp = new String[2];

        int add = expression.indexOf("+");
        if(add != -1) {
            exp[0] = expression.substring(0, add).trim();
            exp[1] = expression.substring(add + 1).trim();
            return run(exp[0]) + run(exp[1]);
        }

        int sub = expression.lastIndexOf("-");
        if(sub == 0) {
            exp[1] = expression.substring(1).trim();
            return -run(exp[1]);
        } else if(sub != -1){
            exp[0] = expression.substring(0, sub).trim();
            exp[1] = expression.substring(sub + 1).trim();
            if(exp[0].charAt(exp[0].length() - 1) != '*') return run(exp[0]) - run(exp[1]);
        }

        int mul = expression.indexOf("*");
        if(mul != -1) {
            exp[0] = expression.substring(0, mul).trim();
            exp[1] = expression.substring(mul + 1).trim();
            return run(exp[0]) * run(exp[1]);
        }

        return Integer.parseInt(expression);
    }
}
