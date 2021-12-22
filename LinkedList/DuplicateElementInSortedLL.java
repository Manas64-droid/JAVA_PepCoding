package LinkedList;
public class DuplicateElementInSortedLL {
    public static class Node{
        public Node(int i) {
            this.data=i;
        }
        private int data;
        private Node next;
    }
    public static class CustomLinkedList{
        private Node head;
        private Node tail;
        private int size;

        public void addLast(int val){
            Node node =new Node(val);
            node.data=val;
            node.next=null;
            if(this.size==0){
                head=tail=node;
            }
            else{
                tail.next=node;
                tail=node;
            }
            size++;
        }
        public void sort(){
            if(head==null){
                return;
            }
            Node current=head;
            Node index=null;
            int temp;
            while(current!=null){
                index=current.next;
                while(index!=null){
                    if(current.data>index.data){
                        temp=current.data;
                        current.data=index.data;
                        index.data=temp;
                    }
                    index=index.next;
                }
                current=current.next;
            }
        }
        public void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.println();
        }
        public int size(){
            return this.size;
        }
        public int getFirst(){
            return head.data;
        }
        public void removeFirst(){
            head=head.next;
            size--;
        }
        public void removeDuplicate(CustomLinkedList l){
            Node temp=l.head;
            Node second=l.head;
            while(temp!=null){
                second=temp;
                while(temp.next!=null && temp.data==temp.next.data){
                    temp=temp.next;
                }
                second.next=temp.next;
                temp=temp.next;
            }
        }
        public void removeDuplicate_another(){
            CustomLinkedList lst=new CustomLinkedList();
            while(this.size()>0){
                int val=getFirst();
                removeFirst();
                if(lst.size()==0 || lst.tail.data!=val){
                    lst.addLast(val);
                }
            }
            this.head=lst.head;
            this.tail=lst.tail;
            this.size=lst.size;
            // return lst;
        }
    }
    public static void main(String[] args) throws NullPointerException{
        CustomLinkedList lst=new CustomLinkedList();
        CustomLinkedList ans=new CustomLinkedList();
        lst.addLast(3);
        lst.addLast(1);
        lst.addLast(2);
        lst.addLast(2);
        lst.addLast(1);
        lst.addLast(3);
        lst.addLast(4);
        lst.addLast(7);
        lst.addLast(4);
        lst.addLast(6);

        lst.sort();
        // lst.removeDuplicate(lst);
        lst.removeDuplicate_another();
        lst.display();
    }
}
