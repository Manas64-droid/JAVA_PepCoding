package LinkedList;
public class reveseLinkeedListRecursive {
    public static class Node{
        private Node next;
        private int data;
    }
    public static class CustomArrayList{
        private Node root;
        private Node tail;
        private int size;

        public void addLast(int val){
            Node node =new Node();
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
        // ! Method 1 : Normal Reverse
        private void reveseLLRecursively(Node root){
            reveseLLRecursivelyHelper(root);
            System.out.println();
        }
        private void reveseLLRecursivelyHelper(Node node) {
            if(node==null){
                return;
            }
            reveseLLRecursivelyHelper(node.next);
            System.out.print(node.data+" ");
        }
        //! Method 2 : pointer Recursive:- By Exchanging Pointers
        private void reveseLLRecursively_Another(){
            reveseLLRecursively_AnotherHelper(root);
            root.next=null;
            Node temp=root;
            root=tail;
            tail=temp;
        }
        private void reveseLLRecursively_AnotherHelper(Node node){
            if(node==null){
                return;
            }
            reveseLLRecursively_AnotherHelper(node.next);
            if(node==tail){
                //nothing to do
            }
            else{
                node.next.next=node;
            }
        }
        //! METHOD 2 : Data Recursive:- By Exchanging Data
        Node left;
        public void reveseLLRecursively_Another1(){
            left=root;
            reveseLLRecursively_AnotherHelper1(root,0);
        }
        private void reveseLLRecursively_AnotherHelper1(Node right,int floor) {
            if(right==null){
                return;
            }
            reveseLLRecursively_AnotherHelper1(right.next,floor+1);
            if(floor>=size/2){
                //! SWAP 
                int temp=right.data;
                right.data=left.data;
                left.data=temp;
                //! Increment left
                left=left.next;
                // System.out.print(temp+" "+left.data+" ");
            }
        }
    }
    public static void main(String[] args) {
        CustomArrayList lst=new CustomArrayList();
        for(int i=1;i<=10;i++)
        {
            lst.addLast(i*5);  
        }
        lst.display();
        // lst.reveseLLRecursively(lst.root);
        lst.reveseLLRecursively_Another();
        // lst.reveseLLRecursively_Another1();
        lst.display();
    }
}
