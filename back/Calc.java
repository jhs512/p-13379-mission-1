package com.back;

import java.util.ArrayList;

public class Calc {
    public static int run(String s) {

        String[] parts = s.split(" ");

        ArrayList<String> op = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();

        //초기값 nums에 넣기
        nums.add(Integer.parseInt(parts[0]));


        //i는 1 3
        for(int i =1;i<parts.length;i+=2) {
            op.add(parts[i]);
            nums.add(Integer.parseInt(parts[i+1]));
        }

        //op[i] = *이면 nums의 i와 i+1
        for(int i =0;i<op.size();i++) {
            if (op.get(i).equals("*")) {
                int num1 = nums.get(i);
                int num2 = nums.get(i+1);
                int result = num1*num2;
                //이제 이걸 i칸에 덮어쓰기
                nums.set(i,result);
                nums.remove(i+1);
                op.remove(i);
                i--;

            }
        }
        //정답은 일단 nums처음
        int answer = nums.get(0);
        //다시 덧셈뺄셈
        for (int i = 0; i < op.size(); i++) {
            String oper = op.get(i);
            int nextNum = nums.get(i + 1);
            if (oper.equals("+")) {
                answer += nextNum;
            } else if (oper.equals("-")) {
                answer -= nextNum;
            }
        }


        return answer;
    }

}