import java.util.*;
public class practiceAll {
    public static class Node{
        int data;
        public Node(){

        }
        public Node(int data){
            this.data=data;
        }
        ArrayList<Node> children=new ArrayList<>();
    }
    public static void display(Node node){
        String str=node.data+"->";
        for(Node child:node.children){
            str+=child.data+",";
        }
        System.out.println(str+" ");
        for(Node child:node.children){
            display(child);
        }
    }
    public static int size(Node node){
        int size=0;
        for(Node child:node.children){
            int childSize=size(child);
            size+=childSize;
        }
        size++;
        return size;
    }
    public static int max(Node node){
        int max=0;
        for(Node child:node.children){
            int ifChild=max(child);
            if(child.data>max){
                max=child.data;
            }
            if(ifChild>max){
                max=ifChild;
            }
        }
        return max;
    }
    public static int edgeHight(Node node){
        int edgeH=-1;
        for(Node child:node.children){
            int ifChild=edgeHight(child);
            edgeH=Math.max(ifChild, edgeH);
        }
        edgeH++;
        return edgeH;
    }
    public static int nodeHeight(Node node){
        int nodeH=0;
        for(Node child:node.children){
            int ifChild=nodeHeight(child);
            nodeH=Math.max(nodeH, ifChild);
        }
        nodeH++;
        return nodeH;
    }
    public static void traversal(Node node){
        System.out.println("NODE PRE "+node.data);
        for(Node child:node.children){
            System.out.println("EDGE PRE "+child.data);
            traversal(child);
            System.out.println("EDGE POST "+child.data);
        }
        System.out.println("NODE POST "+node.data);
    }
    public static void levelOrderTraveral(Node node){
        Queue<Node> qu=new ArrayDeque<>();
        qu.add(node);
        while(qu.size()>0){
            node=qu.remove();
            System.out.print(node.data+" ");
            for(Node child:node.children){
                qu.add(child);
            }
        }
    }
    public static void levelOrderLinewise1(Node node){
        Queue<Node> mainQ=new ArrayDeque<>();
        Queue<Node> childQ=new ArrayDeque<>();
        mainQ.add(node);
        while(mainQ.size()>0){
            node=mainQ.remove();
            System.out.print(node.data+" ");
            for(Node child:node.children){
                childQ.add(child);
            }
            if(mainQ.isEmpty()){
                mainQ=childQ;
                childQ=new ArrayDeque<>();
                System.out.println();
            }
        }
    }
    public static void levelOrderLinewise2(Node node){
        Queue<Node> mainQ=new ArrayDeque<>();
        mainQ.add(node);
        mainQ.add(new Node(-1));
        while(mainQ.size()>0){
            node=mainQ.remove();
            if(node.data!=-1){
                System.out.print(node.data+" ");
                for(Node child:node.children){
                    mainQ.add(child);
                }
            }
            else{
                if(mainQ.size()>0){
                    mainQ.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }
    public static void zigzagLinewise(Node node){
        Stack<Node> mainSt=new Stack<>();
        mainSt.push(node);
        int level=1;
        Stack<Node> childSt=new Stack<>();
        while(mainSt.size()>0){
            node=mainSt.pop();
            System.out.print(node.data+" ");
            if(level%2!=0){
                //odd
                for(int i=0;i<node.children.size();i++){
                    Node ch=node.children.get(i);
                    childSt.push(ch);
                }
            }
            else{
                for(int i=node.children.size()-1;i>=0;i--){
                    Node ch=node.children.get(i);
                    childSt.push(ch);
                }
            }
            if(mainSt.size()==0){
                mainSt=childSt;
                childSt=new Stack<>();
                level++;
                System.out.println();
            }
        }
        
    }
    public static void mirror(Node node){
        if(node.children.size()!=0){
            Collections.reverse(node.children);
        }
        for(Node child:node.children){
            mirror(child);
        }
    }
    public static void removeLeves(Node node){
        for(int i=node.children.size()-1;i>=0;i--){
            Node ifChild=node.children.get(i);
            if(ifChild.children.size()==0){
                node.children.remove(ifChild);
            }
        }
        for(Node child:node.children){
            removeLeves(child);
        }
    }
    public static void linearizeGT1(Node node){
        for(Node child:node.children){
            linearizeGT1(child);
        }
        while(node.children.size()>1){
            Node lastChild=node.children.remove(node.children.size()-1);
            Node secondLast=node.children.get(node.children.size()-1);
            Node secondLastTail=findTail(secondLast);
            secondLastTail.children.add(lastChild);
        }
    }
    private static Node findTail(Node secondLast) {
        while(secondLast.children.size()==1){
            secondLast=secondLast.children.get(0);
        }
        return secondLast;
    }

    public static Node linearizeGT2(Node node){
        if(node.children.size()==0){
            return node;
        }
        Node lastTail=linearizeGT2(node.children.get(node.children.size()-1));
        while(node.children.size()>1){
            Node last=node.children.remove(node.children.size()-1);
            Node second=node.children.get(node.children.size()-1);
            Node secondLastTail=linearizeGT2(second);
            secondLastTail.children.add(last);
        }
        return lastTail;
    }
    public static boolean findElement(Node node,int target){
        // base case 
        if(node.children.size()==0 && target==node.data){
            return true;
        }
        for(Node child:node.children){
            boolean ifChild=findElement(child, target);
            if(ifChild){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[]={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Stack<Node> st=new Stack<>();
        Node head=null;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                st.pop();
            }
            else{
                Node node=new Node();
                node.data=arr[i];

                if(st.size()>0){
                    st.peek().children.add(node);
                }
                else{
                    head=node;
                }
                st.push(node);
            }
        }
        // display(head);
        // System.out.println(size(head));
        // System.out.println(max(head));
        // System.out.println(edgeHight(head));
        // System.out.println(nodeHeight(head));
        
        // traversal(head);
        // levelOrderTraveral(head);
        // levelOrderLinewise1(head);
        // levelOrderLinewise2(head);
        // System.out.println();
        // zigzagLinewise(head);
        
        // mirror(head);
        // levelOrderLinewise1(head);

        // removeLeves(head);
        // levelOrderLinewise1(head);

        // linearizeGT1(head);
        // linearizeGT2(head);
        // levelOrderLinewise1(head);

        if(findElement(head, 40)){
            System.out.println("Element Found");
        }
        else{
            System.out.println("Element Not Found");
        }

    }
}
