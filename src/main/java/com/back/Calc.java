package com.back;

public class Calc {

    public static int run(String expression) {

        while(expression.contains("(") && expression.contains(")")) {
            String extracted = extract(expression);
            int result = run(extracted);
            expression = expression.replace("(" + extracted + ")", String.valueOf(result));
        }

        String[] split = expression.split(" ");

        int result = 0;

        String[] str = new String[split.length / 2];
        int[] num = new int[split.length / 2 + 1];

        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 0) {
                num[i / 2] = Integer.parseInt(split[i]);
            } else {
                str[i / 2] = split[i];
            }
        }
        int temp = 0;



        for (int i = 0; i < str.length; i++) {
            if(str[i].equals("*")){
                temp = i;
                break;
            }
        }

        result = recursiveCalc(num, str);

        return result;
    }

    static int recursiveCalc(int[] num, String[] str) {
        if(str.length == 0){
            return num[0];
        }

        int index = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i].equals("*")){
                index = i;
                break;
            }
        }

        int result = calc(num[index], num[index + 1], str[index]);

        int[] newNum = new int[num.length - 1];

        for (int i = 0, j = 0; i < num.length; i++) {
            if(i == index) continue;
            newNum[j++] = num[i];
        }

        newNum[index] = result;

        String[] newStr = new String[str.length - 1];

        for (int i = 0, j = 0; i < str.length; i++) {
            if(i == index) continue;
            newStr[j++] = str[i];
        }
        return recursiveCalc(newNum, newStr);
    }

    static int calc(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
        }
        return 0;
    }

    static String extract(String expression) {
        int start = expression.lastIndexOf('(');
        int end = expression.indexOf(')', start);

        if(start != -1 && end != -1 && start < end) {
            return expression.substring(start + 1, end);
        } else{
            return "";
        }

    }

}
