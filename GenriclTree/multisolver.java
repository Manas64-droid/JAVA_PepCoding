package GenriclTree;
import java.util.*;
public class multisolver{
    public static class Node{
        int data;
        Node(){

        }
        Node(int data){
            this.data=data;
        }
        ArrayList<Node> children=new ArrayList<>();
    }

    public static Node constrRoot(int arr[]){
        Node root=null;
        Stack<Node> st=new Stack<>();
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
                    root=node;
                }
                st.push(node);
            }
        }
        return root;
    }
    public static void display(Node node){
        String str=node.data+"->";
        for(Node child:node.children){
            str+=child.data+",";
        }
        System.out.println(str);
        for(Node child:node.children){
            display(child);
        }
    }
    public static int size;
    public static int max;
    public static int min;
    public static int height;
    public static void multiSolver(Node node,int depth){
        size++;
        max=Math.max(max, node.data);
        min=Math.min(min, node.data);
        height=Math.max(height, depth);
        for(Node child:node.children){
            multiSolver(child, depth+1);
        }

    }
    public static void main(String[] args) {
        int arr[]={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root=constrRoot(arr);
        // display(root);

        size=0;
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;
        height=0;
        multiSolver(root, 0);
        System.out.println("Size->"+size);
        System.out.println("Max->"+max);
        System.out.println("Min->"+min);
        System.out.println("Height->"+height);
    }
}