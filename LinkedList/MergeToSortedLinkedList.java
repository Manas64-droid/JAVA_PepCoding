package LinkedList;
import java.util.*;
public class MergeToSortedLinkedList{
    public static class Node{
        private Integer data;
        private Node next;
    }
    public static class CustomLinkedList{
        private int size;
        private Node root;
        private Node tail;

        public void addLast(int val){
            Node node=new Node();
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
        public void display(){
            Node temp=root;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println();
        }
        public void sort(){
            if(root==null){
                return;
            }
            int temp;
            Node current=root;
            Node index=null;
            while(current!=null){
                //! node index will point to node next to current 
                index=current.next;
                while(index!=null){
                    /*
                    ! if current nodes data is greater
                    ! then index nodes data swap the data between them
                    */
                    int a=current.data;
                    int b=index.data;
                    if(a>b){
                        temp=current.data;
                        current.data=index.data;
                        index.data=temp;
                    }
                    index=index.next;
                }
                current=current.next;
            }
        }
        //! Correct opperoch to merge the list in assending order
        public CustomLinkedList mergeTwoSortedLinkedList(CustomLinkedList lst1, CustomLinkedList lst2) {
            CustomLinkedList lst=new CustomLinkedList();
            Node first=lst1.root;
            Node second=lst2.root;
            while(first!=null && second!=null){
                if(first.data>second.data){
                    lst.addLast(first.data);
                    first=first.next;
                }
                else{
                    lst.addLast(second.data);  
                    second=second.next;
                }
            }
            while(first!=null){
                lst.addLast(first.data);
                first=first.next;
            }
            while(second!=null){
                lst.addLast(second.data);  
                second=second.next;
            }
            return lst;
        }
        public void removeDuplicate(){
            Node first=root;
            Node second=root;
            while(first!=null){
                second=first;
                while(first.next!=null && first.data==first.next.data){
                    first=first.next;
                }
                second.next=first.next;
                first=first.next;
            }
        }
    }

    public static void main(String[] args) {
        Random random=new Random();
        // int num=random.nextInt(55);
        CustomLinkedList lst1=new CustomLinkedList();
        CustomLinkedList lst2=new CustomLinkedList();
        CustomLinkedList lst3=new CustomLinkedList();
        CustomLinkedList ans=new CustomLinkedList();
        
        for(int i=0;i<10;i++){
            lst1.addLast(random.nextInt(20));
        }
        for(int i=0;i<10;i++){
            lst2.addLast(random.nextInt(55));
        }
        lst1.sort();
        lst2.sort();
        System.out.print("First List ");
        lst1.display();
        System.out.print("Second List ");
        lst2.display();
        ans=lst3.mergeTwoSortedLinkedList(lst1, lst2);
        ans.sort();
        System.out.println("Answer Sorted/Merged List");
        ans.removeDuplicate();
        ans.display();
    }
}