package com.back;

public class Calc {
    public static int run(String input) {
        String[] split = input.split(" ");
        return switch (split[1]) {
            case "+" -> Integer.parseInt(split[0]) + Integer.parseInt(split[2]);
            case "-" -> Integer.parseInt(split[0]) - Integer.parseInt(split[2]);
            default -> 0;
        };
    }
}
