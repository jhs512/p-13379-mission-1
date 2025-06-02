package com.back;

public class Calc {
    public static void main(String[] args) {
        run("1+1");
    }

    public static int run(String exp) {
        // 괄호 처리
        while (exp.contains("(")) {
            int openBracketIndex = exp.lastIndexOf("(");
            int closeBracketIndex = exp.indexOf(")", openBracketIndex);
            String subExp = exp.substring(openBracketIndex + 1, closeBracketIndex);
            int subResult = run(subExp);
            exp = exp.substring(0, openBracketIndex) + subResult + exp.substring(closeBracketIndex + 1);
        }

        // 곱셈 처리
        while (exp.contains("*")) {
            String[] parts = exp.split("\\*", 2);
            String left = parts[0].trim();
            String right = parts[1].trim();

            // 왼쪽 부분의 마지막 숫자 찾기
            String[] leftParts = left.split(" ");
            int leftNum = Integer.parseInt(leftParts[leftParts.length - 1]);

            // 오른쪽 부분의 첫 번째 숫자 찾기
            String[] rightParts = right.split(" ");
            int rightNum = Integer.parseInt(rightParts[0]);

            int result = leftNum * rightNum;

            // 결과로 대체
            exp = left.substring(0, left.length() - String.valueOf(leftNum).length()) +
                    result +
                    right.substring(String.valueOf(rightNum).length());
        }

        // 덧셈과 뺄셈 처리
        String[] tokens = exp.split(" ");
        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);

            if (operator.equals("+")) {
                result += operand;
            } else if (operator.equals("-")) {
                result -= operand;
            }
        }

        return result;
}
}
