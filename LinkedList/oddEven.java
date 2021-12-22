package LinkedList;
public class oddEven {
    //! Genral LinkedList Functions
    public static class Node {
        int data;
        Node next;
    }
    public static class LinkedList {
        Node head;
        Node tail;
        int size;
    
        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
    
            if (size == 0) {
                head = tail = temp;
            } else {
            tail.next = temp;
            tail = temp;
            }
            size++;
        }
    
        public int size() {
            return size;
        }
    
        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
            }
    
        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }
    
        public int getFirst() {
            if (size == 0) {
            System.out.println("List is empty");
            return -1;
            } else {
            return head.data;
            }
        }
    
        public int getLast() {
            if (size == 0) {
            System.out.println("List is empty");
            return -1;
            } else {
            return tail.data;
            }
        }
    
        public int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                temp = temp.next;
                }
            return temp.data;
            }
        }
    
        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;
            if (size == 0) {
                tail = temp;
            }
            size++;
        }
        public void addAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;
                temp.next = node;
                size++;
            }
        }
    
        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
                }
                tail = temp;
                tail.next = null;
                size--;
            }
        }
    
        public void removeAt(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }
        /*
        ? >>>>>>>>>>>>>>>>>>
        ! All Problem Codes
        ? >>>>>>>>>>>>>>>>>>
        */
        //! Intrative Approch for Reversing LinkedList
        private Node getNodeAt(int idx) {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
            }
        public void reverseDI() {
            int li = 0;
            int ri = size - 1;
            while (li < ri) {
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);
                int temp = left.data;
                left.data = right.data;
                right.data = temp;
                li++;
                ri--;
            }
        }
    
        public void reversePI() {
            if (size <= 1) {
            return;
            }
            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node temp = head;
            head = tail;
            tail = temp;
        }
        //! finding element from last of the LinkedList
        public int kthFromLast(int k) {
            Node slow = head;
            Node fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
    
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow.data;
        }
        //! Mid Element of Linkedlist
        public int mid() {
            Node f = head;
            Node s = head;
            while (f.next != null && f.next.next != null) {
                f = f.next.next;
                s = s.next;
            }
            return s.data;
        }
        //! Code for Merging Two Lists
        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            LinkedList ml = new LinkedList();
            Node one = l1.head;
            Node two = l2.head;
            while (one != null && two != null) {
                if (one.data < two.data) {
                ml.addLast(one.data);
                one = one.next;
                } else {
                ml.addLast(two.data);
                two = two.next;
                }
            }
            while (one != null) {
                ml.addLast(one.data);
                one = one.next;
            }
            while (two != null) {
                ml.addLast(two.data);
                two = two.next;
            }
            return ml;
        }
        //! Merge Sort With midNode Code
        public static Node midNode(Node head, Node tail){
            Node f = head;
            Node s = head;
            while(f != tail && f.next != tail){
                f = f.next.next;
                s = s.next;
            }
            return s;
        }
        public static LinkedList mergeSort(Node head, Node tail){
            if(head == tail){
                LinkedList br = new LinkedList();
                br.addLast(head.data);
                return br;
            }
    
            Node mid = midNode(head, tail);
            LinkedList fsh = mergeSort(head, mid);
            LinkedList ssh = mergeSort(mid.next, tail);
            LinkedList sl = mergeTwoSortedLists(fsh, ssh);
            return sl;
        }
        //! Remove Duplicates from LinkedList
        public void removeDuplicates(){
            LinkedList res = new LinkedList();
    
            while(this.size() > 0){
                int val = this.getFirst();
                this.removeFirst();
                if(res.size() == 0 || val != res.tail.data){
                res.addLast(val);
                }
            }
            this.head = res.head;
            this.tail = res.tail;
            this.size = res.size;
        }
        //! Odd-Even Printable LinkedList
        public void oddEven(){
            LinkedList odd=new LinkedList();
            LinkedList even=new LinkedList();
            while(this.size>0){
                int val=this.getFirst();
                this.removeFirst();
                if(val%2==0){
                    even.addLast(val);
                }
                else{
                    odd.addLast(val);
                }
            }
            if(odd.size>0 && even.size>0){
                odd.tail.next=even.head;
                this.head=odd.head;
                this.tail=even.head;
                this.size=odd.size+even.size;
            }else if(odd.size>0){
                this.head=odd.head;
                this.tail=odd.tail;
                this.size=odd.size;
            }else{
                this.head=even.head;
                this.tail=even.tail;
                this.size=even.size;
            }
        }
        //! k^th reversal on LinkedList
        public void kthReverseLL(int k){
            LinkedList previous=null;
            while(this.size>0){
                LinkedList current=new LinkedList();
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
                    previous.tail.next=current.head;
                    previous.tail=current.tail;
                    previous.size=current.size;
                }
            }
            this.head=previous.head;
            this.tail=previous.tail;
            this.size=previous.size;
        }
        //! All 3 Approches to revese the Linkedlist
        private void reveseLinkeedListRecursively(Node head){
            reveseLinkeedListRecursivelyHelper(head);
        }

        private void reveseLinkeedListRecursivelyHelper(Node node) {
            if(node==null){
                return;
            }
            reveseLinkeedListRecursivelyHelper(node.next);
            System.out.print(node.data+" ");
        }
        private void reveseLLRecursively_Another(Node head){
            reveseLLRecursively_AnotherHelper(head);
            head=null;
            Node temp=head;
            head=tail;
            tail=temp;
        }

        private void reveseLLRecursively_AnotherHelper(Node node) {
            if(node==null){
                return;
            }
            reveseLLRecursively_AnotherHelper(node.next);
            if(tail==node){
                // do nothing here
            }
            else{
                node.next.next=node;
            }
            System.out.print(node.data+" ");
        }
        Node left;
        public void reveseLLRecursively_Another1(){
            left=head;
            reveseLLRecursively_AnotherHelper1(head,0);
        }

        private void reveseLLRecursively_AnotherHelper1(Node right, int floor) {
            if(right==null){
                return;
            }
            reveseLLRecursively_AnotherHelper1(right.next,floor+1);
            if(floor>=size/2){
                int temp=right.data;
                right.data=left.data;
                left.data=temp;
                left=left.next;
            }
        }
        /*
        !    1 2 3 4 5 6 7 8 9
        !  p c f
        !    p c f
        !    9 8 7 6 5 4 3 2 1
        */
        public static Node reveseLLRecursively_Another2(Node head){
            if(head==null || head.next==null){
                return head;
            }
            Node current=head;
            Node previous=null;
            Node forward=null;
            while(current!=null){
                forward=current.next;
                current.next=previous;
                previous=current;
                current=forward;
            }
            return previous;
        }
        //! Problem Cheak for Palindrome of LinkedList
        Node left_var;
        public boolean isPalindrome(){
            left_var=head;
            return isPalindrome_Helper(head);
        }

        private boolean isPalindrome_Helper(Node right_var) {
            if(right_var==null){
                return true;
            }
            boolean recurssion=isPalindrome_Helper(right_var.next);
            if(recurssion==false){
                return false;
            }
            else if(right_var.data!=left_var.data){
                return false;
            }
            else{
                left_var=left_var.next;
                return true;
            }
        }
        //! fold the LinkedList
        Node leftN;
		public void foldLL(){
			leftN=head;
			foldLL_Helper(head,0);
		}
		public void foldLL_Helper(Node right,int floor){
			if(right==null){
				return;
			}
			foldLL_Helper(right.next,floor+1);
			if(floor>size/2){
				Node temp=leftN.next;
				leftN.next=right;
				right.next=temp;
				left=temp;
			}
			else if(floor==size/2){
				tail=right;
				tail.next=null;
			}
		}
        //! add two LinkedList
        Node leftO;
        public static LinkedList addTwoLL(LinkedList lst1,LinkedList lst2){
            LinkedList lst=new LinkedList();
            int c=addTwoLL_Helper(lst1.head,lst1.size, lst2.head,lst2.size,lst);
            if(c>0){
                lst.addFirst(c);
            }
            return lst;
        }

        public static int addTwoLL_Helper(Node first, int firstSize, Node second, int secondSize, LinkedList lst) {
            if(first==null && second==null){
                return 0;
            }
            int digit=0;
            if(firstSize>secondSize){
                int carry=addTwoLL_Helper(first.next, firstSize-1, second, secondSize, lst);
                digit=first.data+carry;
            }
            else if(firstSize<secondSize){
                int carry=addTwoLL_Helper(first, firstSize, second.next, secondSize-1, lst);
                digit=second.data+carry;
            }
            else{
                int carry=addTwoLL_Helper(first.next, firstSize-1, second.next, secondSize-1, lst);
                digit=first.data+second.data+carry;
            }
            int new_digit=digit%10;
            int new_carry=digit/10;
            lst.addFirst(new_digit);
            return new_carry;
        }
    }
    public static void main(String[] args) {
        LinkedList lst=new LinkedList();
        LinkedList lst1=new LinkedList();
        LinkedList ans=new LinkedList();
        for(int i=1;i<=10;i++){
            lst.addLast(i*2);
        }
        lst.reveseLLRecursively_Another2(lst.head);
        // lst.display();
        /*
        ! for odd even
        ```2 8 9 1 5 4 3
        -> 9 1 5 3 2 8 4
        */
        
        // boolean isPaindrome=lst1.isPalindrome();
        // if(isPaindrome){
        //     System.out.println("Palindrome");
        //     lst1.display();
        // }
        // else{
        //     System.out.println("Not Palindrome");
        //     lst1.display();
        // }
    }
}
