package com.back;

public class Calc {
    public static int run(String input) {
        String[] split = input.split(" ");
        return Integer.parseInt(split[0]) + Integer.parseInt(split[2]);
    }
}
