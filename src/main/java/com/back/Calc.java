package com.back;

public class Calc {
    public static int run(String cValue) {

        String[] c = cValue.split(" ");
        int result = Integer.parseInt(c[0]);

        for(int i = 1; i < c.length; i+=2){
            if(c[i].equals("*")){
                result *= Integer.parseInt(c[i+1]);
            }else if(c[i].equals("/")){
                result /= Integer.parseInt(c[i+1]);
            }else if(c[i].equals("+")){
                result += Integer.parseInt(c[i+1]);
            }else if(c[i].equals("-")){
                result -= Integer.parseInt(c[i+1]);
            } else{
                System.out.println("error");
            }
        }
        return result;
    }
}
