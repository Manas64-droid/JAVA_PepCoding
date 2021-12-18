package Stack;
import java.util.*;
public class normalStackWithMinFunc {
    public static class CustomeStack{
        Stack<Integer>mainStack=new Stack<>();
        Stack<Integer>minStack=new Stack<>();
        CustomeStack(Stack<Integer> s1){
            this.mainStack=s1;
        }
        int top(){
            if(size()==0){  
                System.out.println("Stack Underflow");
            }
            return mainStack.peek();
        }
        int size(){
            return minStack.size();
        }
        int pop(){
            if(size()==0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                int val=mainStack.pop();
                if(val==minStack.peek()){
                    minStack.pop();
                }
                return val;
            }
        }
        void push(int val){
            mainStack.push(val);
            if(minStack.size()==0||val<=minStack.peek()){
                minStack.push(val);
            }
        }
        int min(){
            if(size()==0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return minStack.peek();
            }
        }
    }
    public static void main(String[] args) {
        Stack<Integer>s1=new Stack<>();
        
        CustomeStack st=new CustomeStack(s1);
        st.push(1235);
        st.push(25);
        st.push(135);
        st.push(13);
        st.push(123);
        st.push(15);
        System.out.println(st.min());
    }
}
