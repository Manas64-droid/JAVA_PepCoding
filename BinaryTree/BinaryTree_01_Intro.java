package BinaryTree;

import java.util.Stack;

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

        int index=0;
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
    public static void main(String[] args) {
        Integer arr[]={50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Node root=constructTree(arr);
        display(root);
    }
}
