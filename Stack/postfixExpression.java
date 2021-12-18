package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class postfixExpression {
    public static int priority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public static int finaloperation(int num1, int num2, char operate) {
        if (operate == '+') {
            return num1 + num2;
        } else if (operate == '-') {
            return num1 - num2;
        } else if (operate == '*') {
            return num1 * num2;
        } else if (operate == '/') {
            return num1 / num2;
        } else {
            return 0;
        }
    }

    public static void main(String[] args, Object Chracter) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> value = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                value.push(ch-'0');
                infix.push(ch+"");
                prefix.push(ch+"");
            }
            else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                char operate=ch;
                int num2=value.pop();
                int num1=value.pop();
                value.push(finaloperation(num1, num2, operate));

                String num4=infix.pop();
                String num3=infix.pop();
                String infixResult="("+num3+operate+num4+")";
                infix.push(infixResult);

                String num6=prefix.pop();
                String num5=prefix.pop();
                String prefixResult=operate+num5+num6;
                prefix.push(prefixResult);
            }
        }
        System.out.println(value.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());
    }
}
