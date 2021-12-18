package Stack;

import java.util.*;
public class balancedBrackets {
    static boolean handleClosing(Stack<Character> st,char currsopondingChar){
        if(st.size()==0){
            return false;
        }
        else if(st.peek()!=currsopondingChar){
            return false;
        }
        else{
            
            st.pop();
            return true;
        }
    }
    public static void main(String[] args) {
        Stack<Character> st=new Stack<>();
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();

        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(ch=='(' || ch=='{'||ch=='['){
                st.push(ch);
            }else if(ch==')'){
                boolean val=handleClosing(st, '(');
                if(val==false){
                    System.out.println(val);
                    return;
                }
            }else if(ch=='{'){
                boolean val=handleClosing(st, '}');
                if(val==false){
                    System.out.println(val);
                    return;
                }
            }else if(ch=='}'){
                boolean val=handleClosing(st, ']');
                if(val==false){
                    System.out.println(val);
                    return; 
                }
            }
        }
        if(st.size()==0){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
