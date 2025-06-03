package com.back;

public class Calc {

    static int run(String input) {
        // 숫자 인식
        String[] stringNumbers = input.split("\\s+[+\\-*/]\\s+");
        //연산자 인식
        String[] stringOperators = input.split("\\s*\\d+\\s*|\\s*-\\d+\\s*");

        // 숫자 String -> int 형변환
        int[] numbers = new int[stringNumbers.length];

        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }

        // 덧셈 뺄셈 계산
        int result = numbers[0]; // 결과값 선언 및 초기 설정

        for (int i = 1; i < stringOperators.length; i++) {

            switch (stringOperators[i]) {
                case "+" -> result += numbers[i];
                case "-" -> result -= numbers[i];
                case "*" -> result *= numbers[i];
            }
        }

        return result;
    }
}
