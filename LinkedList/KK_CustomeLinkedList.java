package LinkedList;

public class KK_CustomeLinkedList {
    public static class CustomeLinkedList{
        private Node head;
        private Node tell;
        private int size;
        CustomeLinkedList(){
            this.size=0;
        }
        private static class Node{
            private int value;
            private Node next;
            public Node(int value){
                this.value=value;
            }
            public Node(int value,Node next){
                this.value=value;
                this.next=next;
            }
        }
        //! -> insert into first postion 
        public void insertFirst(int val){
            Node node=new Node(val);
            if(tell==null){
                tell=head;
            }
            node.next=head;
            head=node;
            this.size+=1;
        }
        //! -> insert at last 
        public void insertLast(int val) {
            if(tell==null){
                insertFirst(val);
                return;
            }
            Node node=new Node(val);
            tell.next=node;
            tell=node;
            this.size+=1;
        }
        //! -> insert in Between
        public void insertInbetween(int val,int index){
            if(index==0){
                insertFirst(val);
                return;
            }
            if(index==size){
                insertLast(val);
                return;
            }
            Node temp=head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }            
            Node node=new Node(val, temp.next);
            temp.next=node;
            this.size+=1;
        }
        //! remove fisrt element
        public void removeFirst(){
            head.next=head;
            
        }
        //! -> display function
        public void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.value+"->");
                temp=temp.next;
            }
            System.out.println("END");
        }
    }
    public static void main(String[] args) throws NullPointerException{
        CustomeLinkedList l1=new CustomeLinkedList();
        l1.insertFirst(3);
        l1.insertFirst(5);
        l1.insertFirst(9);
        l1.insertFirst(6);
        l1.insertFirst(10);
        l1.insertLast(17);
        l1.insertInbetween(166,2);
        l1.display();
        System.out.println(l1.size);
    }
}
