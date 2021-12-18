package Queue;
import java.util.*;
import java.io.*;
public class Queue_toStack_Efficient {
    public static class QtoStack{
        Queue<Integer> mainQ=new ArrayDeque<>();
        Queue<Integer> helperQ=new ArrayDeque<>();

        public int size(){
            return mainQ.size();
        }
        public void push(int val){
            while(mainQ.size()>0){
                helperQ.add(mainQ.remove());
            }
            mainQ.add(val);
            while(helperQ.size()>0){
                mainQ.add(helperQ.remove());
            }
        }
        public int pop(){
            while(mainQ.size()>1){
                helperQ.add(mainQ.remove());
            }
            int val=mainQ.remove();
            while(helperQ.size()>0){
                mainQ.add(helperQ.remove());
            }
            return val;
        }
        public int top(){
            while(mainQ.size()>1){
                helperQ.add(mainQ.remove());
            }
            int val=mainQ.remove();
            helperQ.add(val);
            while(helperQ.size()>0){
                mainQ.add(helperQ.remove());
            }
            return val;
        }
    }
    public static void main(String[] args) {
        QtoStack qts=new QtoStack();
        
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=1;i<=10;i++){
            q.add(i*10);
            qts.push(i*10);
        }
        System.out.println(q.toString());
        System.out.println(qts.mainQ);
        System.out.println(qts.pop());
    }
}
