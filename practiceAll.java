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
    public static Node constructRoot(int arr[]){
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
    public static int lowestCommanAncenstor(Node node,int num1,int num2){
        ArrayList<Integer> lst1=nodeToRootPath(node, num1);
        ArrayList<Integer> lst2=nodeToRootPath(node, num2);
        int i=lst1.size()-1;
        int j=lst2.size()-1;
        while(i>=0 && j>=0 && lst1.get(i)==lst2.get(j)){
            i--;
            j--;
        }
        return lst1.get(i+1);
    }
    public static int distanceBetweenNodes(Node node,int num1,int num2){
        ArrayList<Integer> lst1=nodeToRootPath(node, num1);
        ArrayList<Integer> lst2=nodeToRootPath(node, num2);
        int i=lst1.size()-1;
        int j=lst2.size()-1;
        while(i>=0 && j>=0 && lst1.get(i)==lst2.get(j)){
            i--;
            j--;
        }
        return i+j+2;
    }
    public static boolean areTreeSmiler(Node a,Node b){
        if(a.children.size()!=b.children.size()){
            return false;
        }
        for(int i=0;i<a.children.size();i++){
            Node c1=a.children.get(i);
            Node c2=b.children.get(i);
            boolean ifChild=areTreeSmiler(c1, c2);
            if(ifChild==false){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[]={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        int arr1[]={1 ,2 ,5 ,-1 ,6 ,-1 ,-1 ,3 ,7 ,-1 ,8 ,11 ,-1 ,12 ,-1 ,-1 ,9 ,-1 ,-1 ,4 ,10 ,-1 ,-1 ,-1};
        
        Node root=constructRoot(arr);
        Node root1=constructRoot(arr1);
        // display(root);
        // System.out.println(size(root));
        // System.out.println(max(root));
        // System.out.println(edgeHight(root));
        // System.out.println(nodeHeight(root));
        
        // traversal(root);
        // levelOrderTraveral(root);
        // levelOrderLinewise1(root);
        // levelOrderLinewise2(root);
        // System.out.println();
        // zigzagLinewise(root);
        
        // mirror(root);
        // levelOrderLinewise1(root);

        // removeLeves(root);
        // levelOrderLinewise1(root);

        // linearizeGT1(root);
        // linearizeGT2(root);
        // levelOrderLinewise1(root);

        // if(findElement(root, 40)){
        //     System.out.println("Element Found");
        // }
        // else{
        //     System.out.println("Element Not Found");
        // }
        
        // ArrayList<Integer> lst=new ArrayList<>();
        // lst=nodeToRootPath(root, 110);
        // Collections.reverse(lst);
        // System.out.println(lst);

        // System.out.println(lowestCommanAncenstor(root, 50, 60));
        // System.out.println(distanceBetweenNodes(root, 50, 60));
        
        System.out.println(areTreeSmiler(root,root1));
    }
}
