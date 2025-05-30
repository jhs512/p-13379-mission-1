package com.back;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Calc {
    public static int run(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        List<String> tokens = new ArrayList<>();

        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }

        // *
        List<String> multiplication = new ArrayList<>();

        int i = 0;

        while (i < tokens.size()) {
            String token = tokens.get(i);

            if (token.equals("*")) {
                int prev = Integer.parseInt(multiplication.remove(multiplication.size() - 1));
                int next = Integer.parseInt(tokens.get(++i));
                multiplication.add(String.valueOf(prev * next));
            } else {
                multiplication.add(token);
            }

            i++;
        }

        // +, -
        int result = Integer.parseInt(multiplication.get(0));

        for (i = 1; i < multiplication.size(); i += 2) {
            String op = multiplication.get(i);
            int num = Integer.parseInt(multiplication.get(i + 1));

            if (op.equals("+")) {
                result += num;
            } else if (op.equals("-")) {
                result -= num;
            }
        }

        return result;
    }
}