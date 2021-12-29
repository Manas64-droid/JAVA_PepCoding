package BST;
import java.util.*;
public class BST_01_Intro {
    public static class Node{
        int data;
        Node right;
        Node left;
        public Node(){}
        public Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public static Node construct(int arr[],int low,int high){//1
        if(low>high){
            return null;
        }
        int mid=(low+high)/2;//first find mid
        int root=arr[mid];// created data for Node
        Node lefeChild=construct(arr, low, mid-1);// created leftChild for Node
        Node rightChild=construct(arr, mid+1, high);// created rightChild for Node

        Node node=new Node(root, lefeChild, rightChild);//created new Node obj
        return node;
    }
    public static void display(Node node){
        if(node==null){
            return;
        }
        String str="";
        str+=node.left==null?".":node.left.data;
        str+="<-"+node.data+"->";
        str+=node.right==null?".":node.right.data;
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    public static int size(Node node){//2
        if(node==null){
            return 0;
        }
        int lefeChild=size(node.left);
        int righChildPair=size(node.right);
        return lefeChild+righChildPair+1;
    }
    public static int sum(Node node){
        if(node==null){
            return 0;
        }
        int lefeChild=sum(node.left);
        int rightChild=sum(node.right);
        return lefeChild+rightChild+node.data;
    }
    public static int min(Node node){
        // it find min in left side of tree
        if(node.left!=null){
            return min(node.left);
        }
        else{
            return node.data;
        }
    }
    public static int max(Node node){
        // it finds max in right side of tree
        if(node.right!=null){
            return max(node.right);
        }
        else{
            return node.data;
        }
    }
    public static boolean find(Node node,int target){
        if(node==null){
            return false;
        }
        if(node.data>target){
            // find into left
            return find(node.left, target);
        }
        else if(target>node.data){
            // find into right
            return find(node.right, target);
        }
        else{
            return true;
        }
    }
    public static Node addNode(Node node,int newData){//3
        if(node==null){
            //parent is returning new node 
            return new Node(newData,null,null);
        }
        if(newData<node.data){
            // Connect parent node to yourself wich is returning from base-case <add node to left side>
            node.left=addNode(node.left, newData);
        }
        else if(newData>node.data){
            // Connect parent node to yourself wich is returning from base-case <add node to right side>
            node.right=addNode(node.right, newData);
        }
        else{
            // do nothing beacuse newData==node.data || node.right.data || node.left.data
        }
        return node;
    }
    public static Node removeNode(Node node,int target){
        if(node==null){
            return null;
        }
        if(target<node.data){
            node.left=removeNode(node.left, target);
        }
        else if(target>node.data){
            node.right=removeNode(node.right, target);
        }
        else{
            if(node.left!=null && node.right!=null){
                // find left max
                int lefMax=max(node.left);
                node.data=lefMax; // make node data=left max
                node.left=removeNode(node.left, lefMax); // remove lefMax
                return node;
            }
            else if(node.left!=null){
                return node.left; //if they are single childs
            }
            else if(node.right!=null){
                return node.right; //if they are single childs
            }
            else{
                return null;
            }
        }
        return node;
    }
    public static int sum=0;
    public static void sumOfLargerBST(Node node){
        if(node==null){
            return;
        }
        sumOfLargerBST(node.right);
        int originalSum=node.data;
        node.data=sum;
        sum+=originalSum;
        sumOfLargerBST(node.left);
    }
    public static void main(String[] args) {
        int arr[]={12,25,37,50,62,75,87};
        //!          mid-1 mid mid+1
        Node root=construct(arr, 0, arr.length-1);
        // display(root);// !<-
        // System.out.println(size(root)); //! <-
        // System.out.println(sum(root));
        // System.out.println(min(root));
        // System.out.println(max(root));
        // System.out.println(find(root, 87));

        // Node additionalNode=addNode(root, 44); //! <-
        // display(additionalNode);
        // System.out.println(find(additionalNode, 44));
        // removeNode(additionalNode, 44); //! <-
        // display(additionalNode);
        // System.out.println(find(additionalNode, 44));

        sumOfLargerBST(root); //! <-
        System.out.println(sum);



    }
}
