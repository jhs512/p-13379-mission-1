package com.back;

import java.util.Arrays;
import java.util.Collections;

public class Calc {

    public static int run(String exp) {
        String[] tokens = exp.split("\\s+");
        Collections.reverse(Arrays.asList(tokens));

        // 시작값
        int answer = Integer.parseInt(tokens[0]);

        // 연산자 별로 수행
        for (int i = 1; i < tokens.length; i+=2) {
            switch (tokens[i]) {
                case "*" -> answer *= Integer.parseInt(tokens[i+1]);
                // case "/" -> answer /= Integer.parseInt(tokens[i+1]);
                case "+" -> answer += Integer.parseInt(tokens[i+1]);
                case "-" -> answer -= Integer.parseInt(tokens[i+1]);
                default -> throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
            }
        }

        return answer;
    }
}