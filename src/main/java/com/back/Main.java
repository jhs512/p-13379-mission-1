package com.back;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc();
        Scanner scanner = new Scanner(System.in);
        calc.run(scanner.nextLine().trim());
    }
}