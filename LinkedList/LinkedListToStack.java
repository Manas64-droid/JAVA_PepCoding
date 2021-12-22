package LinkedList;

public class LinkedListToStack {
    public static class Node{
        private int data;
        private Node next;
    }
    public static class CustomeLinkedList{
        private Node head;
        private Node tell;
        private int size;
        
        public void addFirst(int val){
            Node node=new Node();
            node.data=val;
            node.next=head;
            head=node;
            size++;
        }
        public int removeFirst(){
            head=head.next;
            size--;
            return head.data;
        }
        public int getFirst(){
            return head.data;
        }
        public void display(){
            Node temp=head;
            while(head!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println();
        }
        public int size(){
            return this.size;
        }
    }
    public static class Stack extends CustomeLinkedList{
        int size;
        public int size(){
            return super.size;
        }
        public void push(int val){
            addFirst(val);
        }
        public int pop(){
            return removeFirst();
        }
        public int top(){
            return getFirst();
        }
        public void display(){
            System.out.print("[");
            super.display();
            System.out.print("]");
        }
    }
    public static void main(String[] args) throws NullPointerException{
        Stack st=new Stack();
        for(int i=1;i<=10;i++){
            st.push(5*i);
        }
        st.display();
        System.out.println(st.pop());
        st.display();
    }
}
