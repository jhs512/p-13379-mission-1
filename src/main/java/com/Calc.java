package com;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Calc {
    public static int run(String a) {
        String[] parts = a.split(" ");
        List<Integer> numbers = new ArrayList<>();
        List<String> cal = new ArrayList<>();

        for ( int i = 0, j = 0; i < parts.length; i += 2, j++) {
            numbers.add(parseInt(parts[i]));
        }

        for ( int i = 1, j = 0; i < parts.length; i +=2, j++) {
            cal.add(parts[i]);
        }

        for (int i = 0; i < cal.size(); i++) {
            if (cal.get(i).equals("*") || cal.get(i).equals("/")) {
                int x = numbers.get(i);
                int y = numbers.get(i + 1);

                int result = (cal.get(i).equals("*")) ? (x * y) : (x / y);

                numbers.set(i, result);
                numbers.remove(i + 1);
                cal.remove(i);

            }
        }


        int result = numbers.get(0);
        for ( int i = 0; i < cal.size(); i++) {
            String s = cal.get(i);
            int next = numbers.get(i + 1);

            result = switch (s) {
                case "+" -> result + next;
                case "-" -> result - next;
                default -> throw new IllegalStateException("Unexpected value: " + s);
            };
        }




        return result;
    }
}
