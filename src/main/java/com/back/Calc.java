package com.back;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    public static int run(String expression) {
        List<Integer> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        String[] str = expression.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (i % 2 == 0) {
                // 짝수 = 숫자
                numbers.add(Integer.parseInt(str[i]));
            } else {
                // 홀수 = 연산자
                operators.add(str[i]);
            }
        }

        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            String operator = operators.get(i);
            // 다음 숫자 가져오기
            int num = numbers.get(i + 1);

            if (operator.equals("+")) {
                result += num;
            } else if (operator.equals("-")) {
                result -= num;
            } else if (operator.equals("*")) {
                result *= num;
            }
        }

        return result;
    }
}
