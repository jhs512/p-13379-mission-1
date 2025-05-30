package com.back;

public class Calc14 {
    private final String cmd;

    public Calc14 (String cmd) {
        this.cmd = cmd;
    }

    public static int run(String cmd) {


        String[] query = cmd.split(" ");
        int sum = Integer.parseInt(query[0]);





        for (int i = 1; i < query.length; i = i + 2) {
            if (query[i].equals("+"))
                sum += Integer.parseInt(query[i + 1]);
            if(query[i].equals("-"))
                sum -= Integer.parseInt(query[i + 1]);
            if (query[i].equals("*"))
                sum *= Integer.parseInt(query[i + 1]);

        }
        return sum;


    }
}
