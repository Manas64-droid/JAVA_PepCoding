package BinaryTree;
import java.lang.Thread.State;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.util.logging.LogRecord;

import javax.naming.spi.StateFactory;
import javax.sound.midi.Patch;
import javax.swing.text.html.HTMLDocument.RunElement;
public class BinaryTree_01_Intro {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(){}
        public Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public static class Pair{
        Node node;
        int state;
        public Pair(){}
        public Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
    }
    public static Node constructTree(Integer arr[]){
        /*
        state 1=left push
        state 2=right push
        state 3=pop
        */
        //! FOR ROOT
        Stack<Pair> st=new Stack<>();
        Node root=new Node(arr[0], null, null);//make Node for root
        Pair rootPair=new Pair(root, 1);       //make new Pair for root

        st.push(rootPair);

        int index=0;//for array indexing
        while(st.size()>0){
            Pair top=st.peek();
            if(top.state==1){
                index++;
                //left push & inc state 
                if(arr[index]!=null){
                    //! FOR LEFT CHILD
                    top.node.left=new Node(arr[index],null,null);
                    Pair leftPair=new Pair(top.node.left, 1);
                    st.push(leftPair);
                }
                else{
                    top.node.left=null;
                }
                top.state++;
            }
            else if(top.state==2){
                index++;
                //right push inc state
                if(arr[index]!=null){
                    //! FOR RIGHT CHILD
                    top.node.right=new Node(arr[index],null,null);
                    Pair righPair=new Pair(top.node.right, 1);
                    st.push(righPair);
                }
                else{
                    top.node.right=null;
                }
                top.state++;
            }
            else{
                //pop from stack
                st.pop();
            }
        }
        return root;
    }
    public static void display(Node node){
        if(node==null){
            return;//in case any node dont hava their right or left child
        }
        String str="";
        str+=node.left==null?".":node.left.data+"";
        str+="<-"+node.data+"->";
        str+=node.right==null?".":node.right.data+"";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static int size(Node node){
        if(node==null){
            return 0;
        }
        int leftChild=size(node.left);
        int rightChild=size(node.right);
        return leftChild+rightChild+1;
    }
    public static int sum(Node node){
        if(node==null){
            return 0;
        }
        int leftChild=sum(node.left);
        int rightChild=sum(node.right);
        return leftChild+rightChild+node.data;
    }
    public static int max(Node node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        int leftChild=max(node.left);
        int rightChild=max(node.right);
        return Math.max(node.data, Math.max(leftChild, rightChild));
    }
    public static int height(Node node){
        if(node==null){
            return -1;//in terms of edge its-1 or in terms of node its 0
        }
        int leftChild=height(node.left);
        int rightChild=height(node.right);
        return Math.max(leftChild, rightChild)+1;//compair between main two childs and add 1
    }
    public static void traversal(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.data+" in PRE ORDER");
        traversal(node.left);
        System.out.println(node.data+" in INORDER");
        traversal(node.right);
        System.out.println(node.data+" in POST ORDER");
    }
    public static void traversalItrative(Node node){
        Stack<Pair> st=new Stack<>();
        Pair rootPair=new Pair(node, 1);
        st.push(rootPair);
        String pre="";
        String in="";
        String post="";
        while(st.size()>0){
            Pair top=st.peek();
            if(top.state==1){
                // pre state++ push leftChild
                pre+=top.node.data+" ";
                top.state++;
                if(top.node.left!=null){
                    Pair lefPair=new Pair(top.node.left, 1);
                    st.push(lefPair);
                }
            }
            else if(top.state==2){
                // in state++ push rightChild 
                in+=top.node.data+" ";
                top.state++;
                if(top.node.right!=null){
                    Pair righPair=new Pair(top.node.right, 1);
                    st.push(righPair);
                }
            }
            else{
                // post pop
                post+=top.node.data+" ";
                st.pop();
            }
        }
        System.out.print("Pre-> "+pre+"\nIn-> "+in+"\nPost-> "+post);
    }
    public static void levelOrderTraversal(Node node){
        Queue<Node> qu=new ArrayDeque<>();
        qu.add(node);
        while(qu.size()>0){
            //remove print add child
            int s=qu.size();
            for(int i=0;i<s;i++){
                node=qu.remove();//remove
                System.out.print(node.data+" ");//print node.data
                if(node.left!=null){
                    qu.add(node.left);//! added leftChild if left node not equals to null
                }
                if(node.right!=null){
                    qu.add(node.right);//! added rightChild if right node not equals to null
                }
            }
            System.out.print("\n");
        }
    }
    public static boolean findElement(Node node,int target){
        if(node==null){
            return false;
        }
        if(node.data==target){
            return true;
        }
        boolean findleftChild=findElement(node.left, target);//find in leftChild
        if(findleftChild){
            return true;
        }
        boolean findrightChild=findElement(node.right, target);//find in rightChild
        if(findrightChild){
            return true;
        }
        return false;
    }
    public static ArrayList<Integer> nodeToRootPath(Node node,int target){
        if(node==null){
            return new ArrayList<>();
        }
        if(node.data==target){
            ArrayList<Integer> lst=new ArrayList<>();
            lst.add(node.data);
            return lst;
        }
        ArrayList<Integer> findleftChild=nodeToRootPath(node.right, target);
        if(findleftChild.size()>0){
            findleftChild.add(node.data);
            return findleftChild;
        }
        ArrayList<Integer> findrightChild=nodeToRootPath(node.left, target);
        if(findrightChild.size()>0){
            findrightChild.add(node.data);
            return findrightChild;
        }
        return new ArrayList<>();
    }
    public static void printKthLevelDown(Node node,int k){
        if(node==null || k<0){
            return;
        }
        if(k==0){
            System.out.print(node.data+" ");
        }
        printKthLevelDown(node.left, k-1);
        printKthLevelDown(node.right, k-1);
    }
    //! FUNCTIONS ARE REPEATED/MODIFIED
    public static ArrayList<Node> nodeToRootPathMod(Node node,int target){
        if(node==null){
            return new ArrayList<Node>();
        }
        if(node.data==target){
            ArrayList<Node> lst=new ArrayList<>();
            lst.add(node);
            return lst;
        }
        ArrayList<Node> leftChild=nodeToRootPathMod(node.left, target);
        if(leftChild.size()>0){
            leftChild.add(node);
            return leftChild;
        }
        ArrayList<Node> rightChild=nodeToRootPathMod(node.right, target);
        if(rightChild.size()>0){
            rightChild.add(node);
            return rightChild;
        }
        return new ArrayList<Node>();
    }
    public static void printKthLevelDownMod(Node node,int k,Node blocker){
        if(node==null || k<0 || node==blocker){
            return;
        }
        if(k==0){
            System.out.print(node.data+" ");
        }
        printKthLevelDownMod(node.left, k-1, blocker);
        printKthLevelDownMod(node.right, k-1, blocker);
    }
    public static void printNodesKLevelFar(Node node,int k,int target){
        ArrayList<Node> lst=nodeToRootPathMod(node, target);
        for(int i=0;i<lst.size();i++){
            printKthLevelDownMod(lst.get(i), k-1, i==0?null:lst.get(i-1));
        }
    }
    public static void pathToLeafFromRoot(Node node,String path,int sum,int low,int high){
        if(node==null){
            return;
        }
        if(node.left==null || node.right==null){
            sum+=node.data;
            if(sum>=low && sum<=high){
                System.out.println(path+node.data);
            }
            return;
        }
        pathToLeafFromRoot(node.left, path+node.data+" ", sum+node.data, low, high);
        pathToLeafFromRoot(node.right, path+node.data+" ", sum+node.data, low, high);
    }
    public static Node clonnedTree(Node node){
        if(node==null){
            return null;
        }
        Node leftChild=clonnedTree(node.left);
        Node rightChild=clonnedTree(node.right);

        Node newNode=new Node(node.data, leftChild, null);
        node.left=newNode;
        node.right=rightChild;
        
        return node;
    }
    public static Node retransform(Node clone){
        if(clone==null){
            return null;
        }
        clone.left=retransform(clone.left.left);
        clone.right=retransform(clone.right);
        return clone;
    }
    public static void singleChildNode(Node node,Node parent){//1
        if(node==null){
            return;
        }
        if(parent!=null && parent.left==node && parent.right==null){
            System.out.println(node.data);
        }
        else if(parent!=null && parent.right==node && parent.right==null){
            System.out.println(node.data);
        }
        singleChildNode(node.left, node);
        singleChildNode(node.right, node);
    }
    public static Node removeLeaf(Node node){//2
        if(node==null){
            return null;
        }
        if(node.left==null && node.right==null){
            return null;
        }
        node.left=removeLeaf(node.left);
        node.right= removeLeaf(node.right);
        return node;
    }
    public static int diameter(Node node){//3
        if(node==null){
            return 0;
        }
        int leftChild= diameter(node.left);
        int rightChild=diameter(node.right);
        int factor=height(node.left)+height(node.right)+2;
        return Math.max(factor, Math.max(leftChild, rightChild));
    }
    public static class Diapair{
        int height;
        int diameter;
    }// second sol
    public static Diapair diameter2(Node node){
        if(node==null){
            Diapair basePair=new Diapair();
            basePair.height=-1;
            basePair.diameter=0;
            return basePair;
        }
        Diapair leftChildPair=diameter2(node.left);
        Diapair rightChildPair=diameter2(node.right);

        Diapair mainPair=new Diapair();
        mainPair.height=Math.max(leftChildPair.height, rightChildPair.height)+1;
        int factor=leftChildPair.height+rightChildPair.height+2;
        mainPair.diameter=Math.max(factor,Math.max(leftChildPair.diameter, rightChildPair.diameter));
        return mainPair;
    }
    public static int tilt=0;
    public static int tiltOfBinaryTree(Node node){//4
        if(node==null){
            return 0;
        }
        int leftChild=tiltOfBinaryTree(node.left);
        int rightchild=tiltOfBinaryTree(node.right);

        tilt+=Math.abs(leftChild-rightchild);
        return leftChild+rightchild+node.data;
    }
    public static class isBST{
        boolean isTrue;
        int min;
        int max;
        Node root;
        int size;
    }
    public static isBST isBinaryTreeBST(Node node){//5
        if(node==null ){
            isBST basePair=new isBST();
            basePair.isTrue=true; // because single node is bst dont have childs so
            basePair.max=Integer.MIN_VALUE;
            basePair.min=Integer.MAX_VALUE;
            return basePair;
        }
        isBST leftChildPair=isBinaryTreeBST(node.left);
        isBST rightChildPair=isBinaryTreeBST(node.right);

        isBST mainPair=new isBST();
        mainPair.isTrue=leftChildPair.isTrue && rightChildPair.isTrue && (node.data>=leftChildPair.max && node.data<=rightChildPair.min);
        mainPair.max=Math.max(node.data, Math.max(leftChildPair.max, rightChildPair.max));
        mainPair.min=Math.max(node.data, Math.max(leftChildPair.min, rightChildPair.min));
        return mainPair;
    }
    public static isBST largesBSTSubtree(Node node){
        if(node==null){
            isBST basePair=new isBST();
            basePair.isTrue=true;
            basePair.min=Integer.MAX_VALUE;
            basePair.max=Integer.MIN_VALUE;
            basePair.root=null;
            basePair.size=0;
            return basePair;
        }
        isBST leftChildPair=largesBSTSubtree(node.left);
        isBST righChildPair=largesBSTSubtree(node.right);

        isBST mainPair=new isBST();
        mainPair.isTrue=leftChildPair.isTrue && righChildPair.isTrue && (node.data>=leftChildPair.max && node.data<=righChildPair.min);
        mainPair.max=Math.max(node.data, Math.max(leftChildPair.max, righChildPair.max));
        mainPair.min=Math.max(node.data, Math.max(leftChildPair.min, righChildPair.min));

        if(mainPair.isTrue){
            mainPair.root=node;
            mainPair.size=leftChildPair.size+righChildPair.size+1;
        }
        else if(leftChildPair.size>righChildPair.size){
            mainPair.root=leftChildPair.root;
            mainPair.size=leftChildPair.size;
        }
        else{
            mainPair.root=righChildPair.root;
            mainPair.size=righChildPair.size;
        }

        return mainPair;
    }
    public static void main(String[] args) {
        Integer arr[]={50,25,12,null,null,37,30,null,null,null,75,62,null,77,null,null,87,null,null};
        Node root=constructTree(arr);
        display(root);
        // System.out.println(size(root));
        // System.out.println(sum(root));
        // System.out.println(max(root));
        // System.out.println(height(root));

        // traversal(root);
        // levelOrderTraversal(root);
        // traversalItrative(root);

        // System.out.println(findElement(root, 10));
        // System.out.println(nodeToRootPath(root, 30));

        // printKthLevelDown(root, 0);
        // System.out.println();
        // printKthLevelDown(root, 1);
        // System.out.println();
        // printKthLevelDown(root, 2);
        // System.out.println();
        // printKthLevelDown(root, 3);
        // System.out.println();
        // printKthLevelDown(root, 4);

        // printNodesKLevelFar(root, 2, 37);
        // pathToLeafFromRoot(root, "", 0, 150, 250);
        
        // display(root);
        // Node clonned=clonnedTree(root);
        // System.out.println();
        // display(clonned);

        // System.out.println();
        // retransform(clonned);
        // display(clonned);

        // singleChildNode(root,null);

        // display( root);
        // System.out.println();
        // removeLeaf( root);
        // display( root);

        // System.out.println(diameter(root));
        // Diapair test=diameter2(root);
        // System.out.println(test.diameter);

        // System.out.println(tilt);
        // tiltOfBinaryTree(root);
        // System.out.println(tilt);

        
        //isBST test=isBinaryTreeBST(root);
        //System.out.println(test.isTrue);

        isBST largestBSTSubTree=largesBSTSubtree(root);
        // System.out.println(largestBSTSubTree.root.data); // make 70=77
    }
}
