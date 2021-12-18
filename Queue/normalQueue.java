package Queue;
import java.util.*;

import Arrays.addTwoArrays;

import java.io.*;
public class normalQueue {
    public static class CustomeQueue{
        int data[];
        int front;
        int rear;
        int size;
        CustomeQueue(int len){
            data=new int[len];
            this.front=0;
            this.rear=0;
        }
        void add(int val){
            int arr[]=new int[data.length*2];
            for(int i=0;i<data.length;i++){
                arr[i]=data[i];
            }
            data=arr;
            if(size==data.length){
                System.out.println("Queue Oveflow");
            }
            rear=(front+size)%data.length;
            data[rear++]=val;
            size+=1;
        }
        int remove(){
            if(size==0){
                System.out.println("Queue Underflow");
                return -1;
            }
            int val=data[front];
            front=(front+1)%data.length;
            size--;
            return val;
        }
        void display(){
            System.out.print("[");
            for(int i=0;i<size;i++){
                if(data[i]==0){
                    continue;
                }
                int index=(front+1)%data.length;
                System.out.print(data[i]+" ");
            }
            System.out.println("]");
        }
        int peek(){
            if(size==0){
                System.out.println("Queue Underflow");
                return -1;
            }
            return data[front];
        }
    }
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        //! add-> Should accenpt new data if there is space available
        //! or print Queue Overflosw
        CustomeQueue qu=new CustomeQueue(4);
        for(int i=1;i<=4;i++){
            qu.add(i*2);
        }
        qu.display();
        // qu.remove();
        // qu.remove();
        // qu.remove();
        // qu.remove();
        // qu.remove();
        // qu.display();
        for(int i=1;i<=8;i++){
            qu.add(i*2);
        }
        qu.display();
        // System.out.println(qu.peek());
    }
}
