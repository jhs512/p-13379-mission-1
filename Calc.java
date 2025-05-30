package com.back;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    public static int run(String s) {
        String[] bits = s.split(" ");

        List<String> operators = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        for(String bit : bits){
            if(bit.matches("-?[0-9]+")) numbers.add(Integer.parseInt(bit));
            else operators.add(bit);
        }

        System.out.println(operators);
        System.out.println(numbers);

        int answer = numbers.get(0);
        for(int i = 0; i<operators.size(); i++){
            answer = calculate(operators.get(i), answer, numbers.get(i+1));
        }

        return answer;
    }

    private static int calculate(String op, int left, int right) {
        switch(op){
            case "+" -> {
                return left + right;
            }
            case "-" -> {
                return left - right;
            }
            case "/" -> {
                return left / right;
            }
            case "*" -> {
                return left * right;
            }
        }
        return 0;
    }
}
