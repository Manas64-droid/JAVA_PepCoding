package LinkedList;
import java.io.*;
public class MiddleOfLinkedList {
    public static class Node{
        private int data;
        private Node next;
    }
    public static class CustomeLinkedList{
        private int size;
        private Node root;
        private Node tail;
        
        public void addLast(int val){
            Node node =new Node();
            node.data=val;
            node.next=null;
            if(size==0){
                root=tail=node;
            }
            else{
                tail.next=node;
                tail=node;
            }
            size++;
        }
        //! my approch
        public int middleLinkedList(){
            Node temp=root;
            int len=(size-1)/2;
            for(int i=0;i<len;i++){
                temp=temp.next;
            }
            return temp.data;
        }
        public int middleLinkedList1(){
            Node slow=root;
            Node fast=root;
            while(fast.next!=null && fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow.data;
        }
        void display(){
            Node temp=root;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Table Number ->");
        int num=Integer.parseInt(br.readLine());
        CustomeLinkedList lst=new CustomeLinkedList();
        for(int i=1;i<=10;i++){
            lst.addLast(num*i);
        }
        lst.display();
        System.out.println(lst.middleLinkedList());
        System.out.println(lst.middleLinkedList1());
    }
}
