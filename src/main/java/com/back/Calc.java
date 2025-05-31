package com.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {
    public static int run(String expression) {
        // 주어진 문자열 식을 공백 기준으로 요소를 나눈다. (식을 리스트화)
        List<String> elements = initExpression(expression);

        // 1. 곱셈 연산을 진행
        multiply(elements);

        // 2. 덧셈 및 뺄셈 연산을 진행
        plusOrMinus(elements);

        // 3. 해당 식의 정답을 반환한다.
        return Integer.parseInt(elements.get(0));
    }

    private static void multiply(List<String> elements) {
        for(int i = 0; i < elements.size(); i++) {
            if(elements.get(i).equals("*")) {
                // 연산자를 기준으로 i - 1과 i + 1번의 요소를 추출
                int num1 = Integer.parseInt(elements.get(i - 1).trim());
                int num2 = Integer.parseInt(elements.get(i + 1).trim());

                int input = num1 * num2; // 넣을값 (추출한 요소들의 곱)

                elements.set(i - 1, Integer.toString(input));

                // 뒤에 있는 두 개의 수를 날려준다.
                elements.remove(i);
                elements.remove(i);

                // i - 1번에 숫자를 삽입했기 때문에 i - 1번째로 이동
                i--;
            }
        }
    }

    private static void plusOrMinus(List<String> elements) {
        for(int i = 0; i < elements.size(); i++) {
            if(elements.get(i).equals("+")) {
                // 연산자를 기준으로 i - 1과 i + 1번의 요소를 추출
                int num1 = Integer.parseInt(elements.get(i - 1).trim());
                int num2 = Integer.parseInt(elements.get(i + 1).trim());

                int input = num1 + num2; // 넣을값 (추출한 요소들의 합)

                elements.set(i - 1, Integer.toString(input));

                // 뒤에 있는 두 개의 수를 날려준다.
                elements.remove(i);
                elements.remove(i);

                // i - 1번에 숫자를 삽입했기 때문에 i - 1번째로 이동
                i--;
            } else if(elements.get(i).equals("-")) {
                // 연산자를 기준으로 i - 1과 i + 1번의 요소를 추출
                int num1 = Integer.parseInt(elements.get(i - 1).trim());
                int num2 = Integer.parseInt(elements.get(i + 1).trim());

                int input = num1 - num2; // 넣을값 (추출한 요소들의 차)

                elements.set(i - 1, Integer.toString(input));

                // 뒤에 있는 두 개의 수를 날려준다.
                elements.remove(i);
                elements.remove(i);

                // i - 1번에 숫자를 삽입했기 때문에 i - 1번째로 이동
                i--;
            }
        }
    }

    // 문자열로 받은 식을 리스트화 하는 메서드
    static List<String> initExpression(String expression) {
        // 입력받은 식을 괄호를 제거한 형태로 변환
        String newExpression = normalization(expression);
        List<String> expressionToList = Arrays.asList(newExpression.split(" "));
        /* 위의 리스트를 리턴하는 경우 요소를 추가,수정 및 제거하는 경우,
        에러가 발생하므로 아래와 같이 리스트를 다시 감싸서 리턴하였다.*/
        return new ArrayList<>(expressionToList);
    }

    /** 괄호 지우기
     * 괄호를 지운 형식으로 변환한 방법
     * 1. 가장 깊숙하게 있는 열린괄호와 열린괄호에서 가장 가까운 닫힌 괄호를 찾는다.
     * 2. 열린괄호 + 1 지점부터 닫힌 괄호 - 1 번까지의 값을 추출한다. (10 + 20) -> 10 + 20
     * 3. 추출한 데이터를 계산후, 다음과 같은 String 데이터로 다시 저장한다.
     * String 데이터 형식 -> {시작 지점 ~ 열린괄호 - 1 지점} + {계산한 데이터} + {닫힌괄호 + 1 ~ 마지막 지점}
     * 4. 1 ~ 3번 방식을 괄호가 존재하지 않을 때까지 진행
     * 5. 최종적으로 괄호가 제거된 식을 return 한다.
      */
    private static String normalization(String expression) {
        while(expression.contains("(")) {
            int start = expression.lastIndexOf("(");
            int end = expression.indexOf(")", start);
            String inner = expression.substring(start + 1, end);
            int res = run(inner);
            String newExpression = expression.substring(0, start) + res + expression.substring(end + 1);
            return normalization(newExpression);
        }

        return expression;
    }
}
