package Queue;
import java.io.*;
import java.util.*;
public class Stack_toQueue_Efficient{
    public static class Stack_toQ{
        Stack<Integer> mainSt=new Stack<>();
        Stack<Integer> helperSt=new Stack<>();

        public void add(int val){
            mainSt.push(val);
            while(mainSt.size()>0){
                helperSt.push(mainSt.pop());
            }
            while(helperSt.size()>0){
                mainSt.push(helperSt.pop());
            }
        }
        public int remove(){
            while(mainSt.size()>1){
                helperSt.push(mainSt.pop());
            }
            int val=mainSt.pop();
            while(helperSt.size()>0){
                mainSt.push(helperSt.pop());
            }
            return val;
        }
        public int peek(){
            while(mainSt.size()>1){
                helperSt.push(mainSt.pop());
            }
            int val=mainSt.pop();
            helperSt.push(val);
            while(helperSt.size()>0){
                mainSt.push(helperSt.pop());
            }
            return val;
        }
    }
    public static void main(String[] args) throws IOException{
        Stack_toQ stq=new Stack_toQ();
        for(int i=1;i<=30;i++){
            for(int j=1;j<=10;j++){
                stq.add(j*i);
            }
        }
        System.out.println(stq.mainSt);
    }
}