package com.back;

import java.util.*;
import java.util.stream.*;

public class Calc {
    public static int run(String s) {
        String[] tokens = s.split(" ");

        List<String> nums = IntStream.range(0, tokens.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> tokens[i])
                .toList();

        List<String> op = IntStream.range(0, tokens.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> tokens[i])
                .toList();

        int result = Integer.parseInt(nums.get(0));

        for (int i = 0; i < op.size(); i++) {
            switch (op.get(i)) {
                case "+":
                    result += Integer.parseInt(nums.get(i + 1));
                    break;
                case "-":
                    result -= Integer.parseInt(nums.get(i + 1));
                    break;
                case "*":
                    if( i != 0){
                        result = Integer.parseInt(nums.get(i)) * Integer.parseInt(nums.get(i + 1));
                    }
                    result *= Integer.parseInt(nums.get(i + 1));

            }
        }

        return result;
    }
}
