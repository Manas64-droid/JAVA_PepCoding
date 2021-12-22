package LinkedList;

public class kthReverseElements {
    public static class Node{
        private Node next;
        private int data;
    }
    public static class CustomLinkedList{
        private Node root;
        private Node tail;
        private int size;
        //! add Functions
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
            }
            tail.next=node;
            tail=node;
            size++;
        }
        //! remove functions
        public void removeFirst(){
            root=root.next;
            size--;
        }
        public void removeLast(){
            Node temp=root;
            for(int i=0;i<size-2;i++){
                temp=temp.next;
            }
            tail=temp.next;
            tail.next=null;
            size--;
        }
        //! get functions
        public int getFirst(){
            return root.data;
        }
        public int getLast(){
            return tail.data;
        }
        public int getIndexElement(int index){
            Node temp =root;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp.data;
        }
        //! display fuction
        public void display(){
            Node temp=root;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
        public void kthReverseLL(int k){
            CustomLinkedList previous=null;
            while(this.size>0){
                CustomLinkedList current=new CustomLinkedList();
                if(this.size>=k){
                    for(int i=0;i<k;i++){
                        int val=this.getFirst();
                        this.removeFirst();
                        current.addFirst(val);
                    }
                }else{
                    int s=this.size;
                    for(int i=0;i<s;i++){
                        int val=this.getFirst();
                        this.removeFirst();
                        current.addFirst(val);
                    }
                }
                if(previous==null){
                    previous=current;
                }else{
                    previous.tail.next=current.root;
                    previous.tail=current.tail;
                    previous.size=current.size;
                }
            }
            this.root=previous.root;
            this.tail=previous.tail;
            this.size=previous.size;
        }
    }
    public static void main(String[] args) {
        CustomLinkedList lst=new CustomLinkedList();
        // lst.addFirst(4);
        for(int i=1;i<=10;i++){
            lst.addLast(i*5);
        }
        lst.display();
        System.out.println();
        lst.kthReverseLL(3);
        lst.display();
    }
}
