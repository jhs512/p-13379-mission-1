package com.back;

public class Calc {
    private static String[] op;

    public static int run(String expr) {
        String temp = expr.replace("(", "( ");
        temp = temp.replace(")", " )");
        op = temp.trim().split("\\s+");

        return calc(0, op.length);
    }

    private static int calc(int start, int end) {
        //좌변
        int[] temp = para(start, end);
        int left = temp[0];
        int cur = temp[1];

        //우변
        rightLoop:
        while(cur < end) {
            switch(op[cur++]) {
                case "*" -> {
                    temp = para(cur, end);
                    left *= temp[0];
                    cur = temp[1];
                }
                case "+" -> {
                    left += calc(cur, end);
                    break rightLoop;
                }
                case "-" -> {
                    op[cur] = "-" + op[cur];
                    left += calc(cur, end);
                    break rightLoop;
                }
            }
        }

        return left;
    }

    private static int[] para(int start, int end) {
        int left, cur = start;

        if(op[start].equals("(")) {
            cur = slice(cur+1, end);
            left = calc(start+1, cur-1);
        }
        else if(op[start].equals("-(")) {
            cur = slice(cur+1, end);
            left = -calc(start+1, cur-1);
        }
        else {
            left = Integer.parseInt(op[start]);
        }

        return new int[]{left, cur};
    }

    private static int slice(int start, int end) {
        int count = 0;

        for(int i=start; i<end; i++) {
            if(op[i].equals("(")) {
                count++;
            }
            else if(op[i].equals(")")) {
                if(count==0)
                    return i+1;
                count--;
            }
        }

        return -1;
    }
}
