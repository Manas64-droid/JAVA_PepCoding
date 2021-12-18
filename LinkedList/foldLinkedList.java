package LinkedList;

public class foldLinkedList {
    public static class Node{
        private int data;
        private Node next;
    }
    public static class CustomeLinkedList{
        private Node head;
        private Node tail;
        private int size;

        public void addLast(int val){
            Node node =new Node();
            node.data=val;
            node.next=null;
            if(size==0){
                head=tail=node;
            }
			tail.next=node;
			tail=node;
			size++;
        }
		public void addFirst(int val){
			Node node=new Node();
			node.data=val;
			node.next=head;
			head=node;
			if(size==0){
				tail=node;
			}
			size--;
		}
		public void display(){
			Node temp=head;
			while(temp!=null){
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
            System.out.println();
		}
		
		Node left;
		public void foldLL(){
			left=head;
			foldLL_Helper(head,0);
		}
		public void foldLL_Helper(Node right,int floor){
			if(right==null){
				return;
			}
			foldLL_Helper(right.next,floor+1);
			if(floor>size/2){
				Node temp=left.next;
				left.next=right;
				right.next=temp;
				left=temp;
			}
			else if(floor==size/2){
				tail=right;
				tail.next=null;
			}
		}
		public void unfoldLL(Node head){
			if(head==null || head.next==null)return;
			Node firstHead=head;
			Node firstPointer=firstHead;
			Node secondHead=head.next;
			Node secondPointer=secondHead;

			while(secondPointer!=null && secondPointer.next!=null){
				Node forward=secondHead.next;
				firstPointer=forward;
				secondPointer=forward.next;

				firstPointer=firstPointer.next;
				secondPointer=secondPointer.next;
				// forward=forward.next;
			}
			firstPointer.next=null;
			secondHead=reveseLinkeedListRecursive(secondHead);
			firstPointer.next=secondHead;
		}
		private Node reveseLinkeedListRecursive(Node secondHead) {
			if(secondHead==null){
				return secondHead;
			}
			reveseLinkeedListRecursive(secondHead.next);
			return secondHead;
		}
		
    }

	public static void main(String[]args){
		CustomeLinkedList lst=new CustomeLinkedList();
		// for(int i=1;i<=10;i++){
		// 	lst.addLast(i*5);
		// }
		// lst.display();		
		// lst.foldLL();
		// lst.display();
		CustomeLinkedList unfold=new CustomeLinkedList();
		unfold.addLast(5);
		unfold.addLast(50); 
		unfold.addLast(10); 
		unfold.addLast(45); 
		unfold.addLast(15); 
		unfold.addLast(40); 
		unfold.addLast(20); 
		unfold.addLast(35); 
		unfold.addLast(25); 
		unfold.addLast(30);
		unfold.display();
		CustomeLinkedList ans=new CustomeLinkedList();
		ans.unfoldLL(unfold.head);
		ans.display();
	}
}
