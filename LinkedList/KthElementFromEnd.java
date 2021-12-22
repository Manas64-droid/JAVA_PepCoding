package LinkedList;
import java.io.*;
public class KthElementFromEnd {
    public static class Node{
        private int data;
        private Node next;
        // private Node privious;
    }
    public static class CustomeLinkedList{
        private Node head;
        private Node tail;
        private int size;

        public void addLast(int val){
            Node node=new Node();
            node.data=val;
            node.next=null;
            if(size==0){
                head=tail=node;
            }
            else{
                tail.next=node;
                tail=node;
            }
            size++;
        }
        public int KthElementFromEnd(int index){
            Node slow=head;
            Node fast=head;
            for(int i=1;i<=index;i++){
                fast=fast.next;
            }
            while(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
            return slow.data;
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
        System.out.println(lst.KthElementFromEnd(7));
    }
}
