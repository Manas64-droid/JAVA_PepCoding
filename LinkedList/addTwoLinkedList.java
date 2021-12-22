package LinkedList;
public class addTwoLinkedList {
    public static class Node{
        private Node next;
        private int data;
    }
    public static class CustomLinkedList{
        private Node root;
        private Node tail;
        private int size;

        public void addFirst(int val){
            Node node=new Node();
            node.data=val;
            node.next=root;
            root=node;
            if(size==0){
                tail=node;
            }
            size++;
        }
        public void addLast(int val){
            Node node=new Node();
            node.data=val;
            node.next=null;
            if(size==0){
                root=tail=node;
            }else{    
                tail.next=node;
                tail=node;
            }
            size++;
        }
        public void display(){
            Node temp=root;
            while(temp!=null){
                System.out.print(temp.data);
                temp=temp.next;
            }
            System.out.println();
        }
        public static CustomLinkedList addTwoLL(CustomLinkedList lst1,CustomLinkedList lst2){
            CustomLinkedList lst=new CustomLinkedList();
            int c=addTwoLL_Helper(lst1.root,lst1.size, lst2.root,lst2.size,lst);
            if(c>0){
                lst.addFirst(c);
            }
            return lst;
        }
        public static int addTwoLL_Helper(Node first, int firstSize, Node second, int secondSize, CustomLinkedList lst) {
            if(first==null && second==null){
                return 0;
            }
            int data=0;
            if(firstSize>secondSize){
                int carry=addTwoLL_Helper(first.next, firstSize-1, second, secondSize, lst);
                data=first.data+carry;
            }
            else if(firstSize<secondSize){
                int carry=addTwoLL_Helper(first, firstSize, second.next, secondSize-1, lst);
                data=second.data+carry;
            }
            else{
                int carry=addTwoLL_Helper(first.next, firstSize-1, second.next, secondSize-1, lst);
                data=first.data+second.data+carry;
            }
            int new_data=data%10;
            int new_carry=data/10;
            lst.addFirst(new_data);
            return new_carry;
        }
    }
    public static void main(String[] args) {
        CustomLinkedList lst1=new CustomLinkedList();
        CustomLinkedList lst2=new CustomLinkedList();
        CustomLinkedList ans=new CustomLinkedList();
        lst1.addLast(1000);
        lst2.addLast(64);
        ans=CustomLinkedList.addTwoLL(lst1, lst2);
        lst1.display();
        System.out.println("+");
        lst2.display();
        System.out.println("____________");
        ans.display();
    }
}
