package Stack;
import java.io.*;
import java.util.*;
public class prefixExpression {
    public static int operation(int num1,int num2,char op){
        if(op=='+') return num1+num2;
        else if(op=='-') return num1-num2;
        else if(op=='*') return num1*num2;
        else if(op=='/') return num1-num2;
        else return 0;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> val=new Stack<>();
        Stack<String> infix=new Stack<>();
        Stack<String> postfix=new Stack<>();

        String str=br.readLine();
        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);

            if(ch=='+' || ch=='-' || ch=='*' ||ch=='/'){
                int v2=val.pop();
                int v1=val.pop();
                int result=operation(v1, v2, ch);
                val.push(result);

                String in2=infix.pop();
                String in1=infix.pop();
                String inRes="("+in1+ch+in2+")";
                infix.push(inRes);

                String post2=postfix.pop();
                String post1=postfix.pop();
                String postRes=post1+post2+ch;
                postfix.push(postRes);
            }
            else{
                val.push(ch-'0');
                infix.push(ch+"");
                postfix.push(ch+"");
            }
        }
        System.out.println(val.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());
    }
}
