package com.back;

import java.util.Stack;


public class Calc {

    public static int run(String expr) {
        return evaluate(expr);
    }

    private static int evaluate(String expr) {
        Stack<Integer> nums = new Stack<>(); // 숫자
        Stack<Character> ops = new Stack<>(); // 연산자
        int num = 0;
        boolean hasNum = false; // 뭘 읽고 있는지 (숫자 = 1)
        boolean expectOperand = true; // 피연산자이면 연산자가 와야함 =  fals, 연산자이면 피연산자가 와야함 = true

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch ==' ') {
                continue;
            }

            if (Character.isDigit(ch)) { // 숫자인 경우
                num = num * 10 + (ch - '0'); // 파싱
                hasNum = true; // 숫자 읽는 중
                expectOperand = false; // 피연산자 다음 -> 연산자가 와야 함
            } else { // 숫자가 아니면 이전의 숫자를 push해야함
                if (hasNum) {
                    nums.push(num);
                    num = 0;
                    hasNum = false;
                }

                if (ch == '(') {  //괄호는 바로 push하고, 다음 숫자를 받아야함
                    ops.push(ch);
                    expectOperand = true;
                } else if (ch == ')') { //
                    while (!ops.isEmpty() && ops.peek() != '(') {
                        compute(nums, ops);
                    }
                    if (!ops.isEmpty() && ops.peek() == '(') {
                        ops.pop();
                    } else {
                        // 여는 괄호 없이 닫는 괄호가 나온 경우
                        throw new IllegalArgumentException("짝이 맞지 않습니다. 위치: " + i);
                    }
                    expectOperand = false; // 닫는 괄호 다음 -> 연산자 와야함
                } else if (isOperator(ch)) { // 연산자인 경우
                    if (ch == '-' && expectOperand) { // - 이면서 피연산자가 와야한다면? -> 음수
                        nums.push(0);
                        ops.push(ch);
                    } else {
                        // 현재 연산자보다 우선순위가 높거나 같은 연산자를 먼저 계산
                        while (!ops.isEmpty() && ops.peek() != '(' && prior(ops.peek()) >= prior(ch)) {
                            compute(nums, ops);
                        }
                        ops.push(ch);
                    }
                    expectOperand = true; // 연산자 다음, 피연산자 기대
                }
            }
        }

        if (hasNum) { //남은 숫자 푸시
            nums.push(num);
        }

        // 남은 거 계산
        while (!ops.isEmpty()) {
            if (ops.peek() == '(') {
                throw new IllegalArgumentException("괄호가 잘못 입력됨.");
            }
            compute(nums, ops);
        }

        if (nums.size() != 1 || !ops.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력");
        }

        return nums.pop(); // 최종 결과 반환
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int prior(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    // 두 개의 피연산자와 하나의 연산자 계산
    private static void compute(Stack<Integer> nums, Stack<Character> ops) {

        if (nums.size() < 2 || ops.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력");
        }
        int b = nums.pop();
        int a = nums.pop();
        char op = ops.pop();

        switch (op) {
            case '+' -> nums.push(a + b);
            case '-' -> nums.push(a - b);
            case '*' -> nums.push(a * b);
            case '/' -> {
                if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                nums.push(a / b);
            }
        }
    }
}