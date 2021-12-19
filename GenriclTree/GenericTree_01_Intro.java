package GenriclTree;
import java.util.*;
public class GenericTree_01_Intro {
    public static class Node{
        int data;
        Node(){
        }
        Node(int data){
            this.data=data;
        }
        ArrayList<Node> children=new ArrayList<>();
    }
    public static class Pair{
        private Node node;
        private int level;
        Pair(){
        }
        Pair(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }
    //! for printeing data of node 
    public static void display(Node node){
        String str=node.data+"->";
        for(Node child:node.children){
            str+=child.data+" ";
        }
        System.out.println(str);
        //! for printing sub child nodes data
        for(Node sub_childs:node.children){
            display(sub_childs);
        }
    }
    //! return size of tree
    public static int size(Node node){
        int size=0;
        for(Node child:node.children){
            int childSize=size(child);
            size=size+childSize;
        }
        size++;
        return size;
    }
    public static int maximum(Node node){
        int max=0;
        for(Node child:node.children){
            int childMax=maximum(child);
            if(child.data>max){
                max=child.data;
            }
            if(max<childMax){
                max=childMax;
            }
        }
        return max;
    }
    public static int edgeHight(Node node){
        int nodeHight=-1;
        for(Node child:node.children){
            int childrenHight=edgeHight(child);  
            nodeHight= Math.max(childrenHight, nodeHight);
        }
        nodeHight++;
        return nodeHight;
    }
    public static int nodeHeight(Node node){
        int nh=0;
        for(Node child:node.children){
            int ch=nodeHeight(child);
            if(ch>nh){
                nh=ch;
            }
        }
        nh++;
        return nh;
    }
    public static void traversal(Node node){
        /*
        ! PRE
        ! Euler path @ Nodes left side before going deep in recursion
        ? POST
        ? Euler path @ Nodes Right side  while comming out of recurssion
        */
        System.out.println("Node Pre "+node.data);
        for(Node childe:node.children){
            System.out.println("Edge Pre "+node.data+"-->"+childe.data);
            traversal(childe);
            System.out.println("Edge Post "+node.data+"-->"+childe.data);
        }
        System.out.println("Node Post "+node.data);

    }
    public static void levelOrderTraveral(Node node){
        Queue<Node> qu=new ArrayDeque<>();
        qu.add(node);
        while(qu.size()>0){
            node=qu.remove();
            System.out.print(node.data+" ");
            for(Node child:node.children){
                // levelOrderTraveral(child);
                qu.add(child);
            }
        }
    }
    public static void levelOrderLinewise1(Node node){
        Queue<Node> root=new ArrayDeque<>();
        Queue<Node> leaf=new ArrayDeque<>();
        //! remove print addChildren
        root.add(node);
        while(root.size()>0){
            node=root.remove();
            System.out.print(node.data+" ");
            for(Node child:node.children){
                leaf.add(child);
            }
            if(root.size()==0){
                root=leaf;
                leaf=new ArrayDeque<>();
                System.out.println();
            }
        }
    }
    private static void levelOrderLinewise2(Node node) {
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
    private static void levelOrderLinewise3(Node node){
        Queue<Node>qu=new ArrayDeque<>();
        qu.add(node);
        while(qu.size()>0){
            int len=qu.size();
            for(int i=0;i<len;i++){
                node=qu.remove();
                System.out.print(node.data+" ");
                for(Node child:node.children){
                    qu.add(child);
                }
            }
            System.out.println();
        }
    }
    private static void levelOrderLinewise4(Node node){
        Queue<Pair> qu=new ArrayDeque<>();
        qu.add(new Pair(node,1));
        int level=1;
        while(qu.size()>0){
            Pair p=qu.remove();
            System.out.print(p.node.data+" ");
            if(p.level>level){
                level=p.level;
                System.out.println();
            }
            for(Node child:p.node.children){
                Pair cn=new Pair(child,p.level+1);
                qu.add(cn);
            }
        }
    }
    public static void zigzagLinewise(Node node){
        Stack<Node> mainStack=new Stack<>();
        mainStack.push(node);
        Stack<Node> smallStack=new Stack<>();
        int level=1;
        while(mainStack.size()>0){
            node=mainStack.pop();
            System.out.print(node.data+" ");
            if(level%2==1){
                //! if level is odd
                for(int i=0;i<node.children.size();i++){
                    Node child=node.children.get(i);
                    smallStack.push(child);
                }
            }
            else{
                //! else level is even
                for(int j=node.children.size()-1;j>=0;j--){
                    Node child=node.children.get(j);
                    smallStack.push(child);
                }
            }
            if(mainStack.size()==0){
                mainStack=smallStack;
                smallStack=new Stack<>();
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
        //! traverse loop backwards 
        //! if child dont have childs remove sub-child
        for(int i=node.children.size()-1;i>=0;i--){
            Node child=node.children.get(i);
            if(child.children.size()==0){
                node.children.remove(child);
            }
        }
        //! call recurssion
        for(Node child:node.children){
            removeLeves(child);
        }
    }

    public static void linearizeGT1(Node node){
        //! traversing from root so root will have to only one children -(multilecel chid)
        for(Node child:node.children){
            linearizeGT1(child);
        }
        while(node.children.size()>1){
            //! find last child
            Node lastChild=node.children.remove(node.children.size()-1);
            //! find second last child
            Node secondLastChild=node.children.get(node.children.size()-1);
            //! get tail of second last child
            Node secondLastTail=getTail(secondLastChild);
            //! join tail to first child
            secondLastTail.children.add(lastChild);
        }
    }
    private static Node getTail(Node secondLastChild) {
        while(secondLastChild.children.size()==1){
            secondLastChild=secondLastChild.children.get(0);
        }
        return secondLastChild;
    }

    public static Node linearizeGT2(Node node){
        if(node.children.size()==0){
            return node;//! return becoz its leaf
        }
        Node lastTail=linearizeGT2(node.children.get(node.children.size()-1));
        while(node.children.size()>1){
            Node last=node.children.remove(node.children.size()-1);
            Node secondLast=node.children.get(node.children.size()-1);
            Node secondLastTail=linearizeGT2(secondLast);
            secondLastTail.children.add(last);
        }
        return lastTail;
    }

    public static boolean findElement(Node node,int target){
        if(node.children.size()==0 && node.data==target){
            return true;//! it may be leaf with target value
        }
        for(Node child:node.children){
            boolean firstChild=findElement(child, target);
            if(firstChild){
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        //! in case it itself contains that data
        if(node.data==data){
            ArrayList<Integer> list=new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for(Node child:node.children){
            ArrayList<Integer> childTillPath=nodeToRootPath(child, data);
            if(childTillPath.size()>0){
                childTillPath.add(node.data);
                return childTillPath;
            }
        }
        return new ArrayList<>();
    }
    public static int commanAncestor(Node node,int num1,int num2){
        ArrayList<Integer> path1=nodeToRootPath(node, num1);
        ArrayList<Integer> path2=nodeToRootPath(node, num2);
        int i=path1.size()-1;
        int j=path2.size()-1;
        while(i>=0 && j>=0 && path1.get(i)==path2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return path1.get(i);
    }
    public static int distanceBetweenNodes(Node node,int num1,int num2){
        ArrayList<Integer> path1=nodeToRootPath(node, num1);
        ArrayList<Integer> path2=nodeToRootPath(node, num2);
        int i=path1.size()-1;
        int j=path2.size()-1;
        while(i>=0 && j>=0 && path1.get(i)==path2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return i+j;
    }
    public static void main(String[] args) {
        Node root=null;
        Stack<Node> stack=new Stack<>();
        int arr[]={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        for(int i=0;i<arr.length;i++){
            // ! cheak for -1 if -1 then pop
            //! pop -1-make new node-initaiate data property to it-conect node to cildren  
            //! else make node as head
            //! push
            if(arr[i]==-1){
                stack.pop();
            }
            else{
                //! make new node
                Node node=new Node();
                node.data=arr[i];//! add data to it
                if(stack.size()>0){
                    //! connect root to childrens with ArrayList
                    stack.peek().children.add(node);
                }
                else{
                    root=node;
                }
                //! push node into stack
                stack.push(node);
            }
        }
        display(root);
        // System.out.println(size(root));
        // System.out.println(maximum(root));
        // System.out.println(edgeHight(root));
        // System.out.println(nodeHeight(root));
        // traversal(root);

        // levelOrderTraveral(root);
        // levelOrderLinewise1(root);
        // levelOrderLinewise2(root);
        // levelOrderLinewise3(root);
        // levelOrderLinewise4(root);
        // zigzagLinewise(root);
        
        // mirror(root);
        // removeLeves(root);

        // linearizeGT1(root);
        // linearizeGT2(root);

        // boolean bool=findElement(root, 510);
        // System.out.println(bool);

        ArrayList<Integer> lst=nodeToRootPath(root, 110);
        System.out.println(lst);

        // System.out.print(commanAncestor(root, 80,90)); 
        // System.out.print(distanceBetweenNodes(root, 30,90)); 

        // System.out.println();
        // display(root);
    }
}
