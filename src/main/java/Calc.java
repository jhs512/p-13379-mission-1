public class Calc {
    public static int run (String expression) {
        String[] parts = expression.split(" ");
        int first_num = Integer.parseInt(parts[0]);

        for (int i = 1; i < parts.length; i +=2 ){
            String op = parts[i];
            int num = Integer.parseInt(parts[i+1]);

            switch (op) {
                case "+":
                    first_num += num;
                    break;
                case "-":
                    first_num -= num;
                    break;
                case "*":
                    first_num *= num;
                    break;
                case "/":
                    first_num /= num;
                    break;
                default:
                    break;
            }
        }
        return first_num;
    }
}
