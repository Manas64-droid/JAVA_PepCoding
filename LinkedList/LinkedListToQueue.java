package LinkedList;
import java.io.*;
public class LinkedListToQueue{
    public static class Node{
        private int data;
        private Node next;
    }
    public static class CustomeLinkedList{
        private int size;
        private Node root;
        private Node tail;
        //! return size of LinkedList
        public int size(){
            return this.size();
        }
        //! add elements from last 
        public void addLast(int val){
            Node node=new Node();
            node.data=val;
            node.next=null;
            if(this.size==0){
                root=tail=node;
            }
            else{
                tail.next=node;
                tail=node;
            }
            size++;
        }
        //! remove first element from LinkedList
        public void removeFirst(){
            if(size==0){
                System.out.println("Queue is empty");
            }
            root=root.next;
            size--;
        }
        //! return data at root of LikedList
        public int getFirst(){
            return root.data;
        }
        public void display(){
            Node temp=root;
            System.out.print("[");
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println("]");
        }

    }
    public static class CustomeQueue extends CustomeLinkedList{
        /*
        ! size();
        ! add();
        ! remove();
        ! peek();
        */
        public int size(){
            return super.size;
        }
        public void add(int val){
            super.addLast(val);
        }
        public void remove(){
            super.removeFirst();
        }
        public int peek(){
            return super.getFirst();
        }
        public void display(){
            super.display();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Table Number ->");
        int num=Integer.parseInt(br.readLine());
        CustomeQueue qu=new CustomeQueue();
        for(int i=1;i<=10;i++){
            qu.add(i*num);
        }
        qu.display();
    }
}