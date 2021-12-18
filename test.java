import java.io.*;
import java.util.*;
public class test {
    public static int prio(char ch){
        if(ch=='+') return 1;
        else if(ch=='-') return 1;
        else if(ch=='*') return 2;
        else if(ch=='/') return 2;
        else return 0;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Stack<String>post=new Stack<>();
        Stack<String>pre=new Stack<>();
        Stack<Character>opt=new Stack<>();
    
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(ch=='('){
                opt.push(ch);
            }
            else if((ch>='0'&&ch<=9) || (ch>='a'&&ch<='z') || (ch>='A' && ch<='Z')){
                post.push(ch+"");
                pre.push(ch+"");
            }
            else if(ch==')'){
                while(opt.size()>0 && opt.peek()!='('){
                    char operator=opt.pop();
                    String num2=pre.pop();
                    String num1=pre.pop();
                    String preResult=operator+num1+num2;
                    pre.push(preResult);
    
                    String num4=post.pop();
                    String num3=post.pop();
                    String postResult=num3+num4+operator;
                    post.push(postResult);
                }
                opt.pop();
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                while(opt.size()>0 && opt.peek()!='(' && prio(ch)<=prio(opt.peek())){
                    char operator=opt.pop();
                    String num2=pre.pop();
                    String num1=pre.pop();
                    String preResult=operator+num1+num2;
                    pre.push(preResult);
    
                    String num4=post.pop();
                    String num3=post.pop();
                    String postResult=num3+num4+operator;
                    post.push(postResult);
                }
                opt.push(ch);
            }
        }
        while(opt.size()!=0){
            char operator=opt.pop();
            String num2=pre.pop();
            String num1=pre.pop();
            String preResult=operator+num1+num2;
            pre.push(preResult);
    
            String num4=post.pop();
            String num3=post.pop();
            String postResult=num3+num4+operator;
            post.push(postResult);
        }
        System.out.println(post.peek());
        System.out.print(pre.peek());
        }    
} 
