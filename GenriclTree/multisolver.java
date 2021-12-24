package GenriclTree;
import java.util.*;

public class multisolver{
    public static class GenericTree implements Iterable<Integer>{
        Node root;
        GenericTree(Node root){
            this.root=root;
        }
        @Override
        public Iterator<Integer> iterator() {
            // TODO Auto-generated method stub
            Iterator<Integer> obj=new GenriclTreePreOrder(root);
            return obj;
        }
        
    }
    public static class GenriclTreePreOrder implements Iterator<Integer>{
        Integer nextValue;
        Stack<Pair> st;
        public GenriclTreePreOrder(Node root){
            st=new Stack<>();
            st.push(new Pair(root, -1));
            next();
        }
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            if(nextValue==null){
                return false;
            }
            else{
                return true;
            }
        }
        @Override
        public Integer next() {
            // TODO Auto-generated method stub
            //! return current value and set current value for next operation
            Integer currentValue=nextValue;
            //! moves nextValue forward, if not possiable make it null;
            nextValue=null;
            while(st.size()>0){
                Pair top=st.peek();
                if(top.state==-1){
                    // pre oreder < print inc top.state > 
                    nextValue=top.node.data;
                    top.state++;
                    break;
                }
                else if(top.state==top.node.children.size()){
                    // post order <print pop st >
                    st.pop();
                }
                else{
                    // make child pair < push childPair in stack inc top.state >
                    Pair childPair=new Pair(top.node.children.get(top.state), -1);
                    st.push(childPair);
                    top.state++;
                }
            }
            return currentValue;
        }

    }
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
        Node node;
        int state;
        public Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
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

        GenericTree gt=new GenericTree(root);
        Iterator<Integer> gt1=gt.iterator();

        System.out.println("By using for loop");
        for(int i:gt){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("By usinng Iterator");
        while(gt1.hasNext()==true){
            System.out.print(gt1.next()+" ");
        }
    }
}