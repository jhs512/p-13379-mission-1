package com.back;

import java.util.*;
// 17
public class Calc {
    public static int run(String expression) {
        List<String> tokens = new ArrayList<>(Arrays.asList(expression.split(" ")));

        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (token.equals("*") || token.equals("/")) {
                int left = Integer.parseInt(tokens.get(i - 1));
                int right = Integer.parseInt(tokens.get(i + 1));
                int result;

                if (token.equals("*")) {
                    result = left * right;
                } else {
                    result = left / right;
                }

                tokens.set(i - 1, String.valueOf(result));
                tokens.remove(i);
                tokens.remove(i);
                i--;
            }
        }

        int result = Integer.parseInt(tokens.get(0));
        for (int i = 1; i < tokens.size(); i += 2) {
            String nums = tokens.get(i);
            int num = Integer.parseInt(tokens.get(i + 1));

            if (nums.equals("+")) {
                result += num;
            } else if (nums.equals("-")) {
                result -= num;
            }
        }

        return result;
    }
}




