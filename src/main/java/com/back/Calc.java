package com.back;

public class Calc {

    public static int run(String exp) {
        //공백 제거
        exp = exp.replaceAll(" ","");

        StringBuilder numberBulider = new StringBuilder();

        int result = 0;
        int currentNum = 0;
        char currentOp = '+';

        //문자열 처음부터 하나씩 꺼내기
        for (int i = 0; i < exp.length() ; i++){
            char ch = exp.charAt(i);

            if (Character.isDigit(ch) || ch =='-'){
                numberBulider.append(ch);

                if (i == exp.length()-1 || "+-*".indexOf(exp.charAt(i+1)) >= 0){
                    currentNum = Integer.parseInt(numberBulider.toString());
                    numberBulider.setLength(0);

                    if (currentOp == '+') result += currentNum;
                    else if (currentOp == '-') result -= currentNum;
                    else if (currentOp == '*') result *= currentNum;
                }

            } else if ("+-*".indexOf(ch) >= 0) {
                currentOp = ch;

            }
        }

        return result;

    }
}
