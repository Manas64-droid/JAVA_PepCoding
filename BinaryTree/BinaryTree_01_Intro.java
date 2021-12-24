package BinaryTree;
import java.util.*;
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
        Node root=new Node(arr[0], null, null);//make Node for root
        Pair rootPair=new Pair(root, 1);       //make new Pair for root

        Stack<Pair> st=new Stack<>();
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
    public static void levelOrderTraversal(Node node){
        Queue<Node> qu=new ArrayDeque<>();
        qu.add(node);
        while(qu.size()>0){
            int s=qu.size();
            for(int i=0;i<s;i++){
                node=qu.remove();
                System.out.print(node.data+" ");

                if(node.left!=null){
                    qu.add(node.left);
                }
                if(node.right!=null){
                    qu.add(node.right);
                }
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        Integer arr[]={50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
        Node root=constructTree(arr);
        // display(root);
        // System.out.println(size(root));
        // System.out.println(sum(root));
        // System.out.println(max(root));
        // System.out.println(height(root));

        // traversal(root);
        levelOrderTraversal(root);
    }
}
