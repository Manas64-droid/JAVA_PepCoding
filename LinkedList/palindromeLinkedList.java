package LinkedList;
public class palindromeLinkedList {
    public static  class Node{
        private int data;
        private Node next;
    }
    public static class CustomLinkedList{
        private Node root;
        private Node tail;
        private int size;

        public void addLast(int val){
            Node node=new Node();
            node.data=val;
            node.next=null;
            if(size==0){
                root=tail=node;
            }
            tail.next=node;
            tail=node;
            size++;
        }
        public void display(){
            Node temp=root;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        Node left;
        public boolean isPalindrome(){
            left=root;
            return isPalindrome_Helper(root);
        }
        private boolean isPalindrome_Helper(Node right) {
            if(right==null){
                return true;
            }
            boolean right_result=isPalindrome_Helper(right.next);
            if(right_result==false){
                return false;
            }
            else if(right.data!=left.data){
                return false;
            }
            else{
                left=left.next;
                return true;
            }
        }
    }
    public static void main(String[] args) {
        CustomLinkedList lst=new CustomLinkedList();
        // for(int i=1;i<10;i++){
        // }
        lst.addLast(4);
        lst.addLast(5);
        lst.addLast(4);
        lst.addLast(6);
        lst.addLast(5);
        lst.addLast(4);
        lst.display();
        boolean ispalindrome=lst.isPalindrome();
        if(ispalindrome){
            System.out.println("LinkedList Is Palindrome");
        }
        else{
            System.out.println("LinkedList Is Not Palindrome");
        }
    }
}
