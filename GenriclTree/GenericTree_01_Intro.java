package GenriclTree;

import java.util.*;

import javax.security.auth.kerberos.KerberosCredMessage;

public class GenericTree_01_Intro {
    public static class Node {
        int data;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }

        ArrayList<Node> children = new ArrayList<>();
    }

    public static class Pair {
        private Node node;
        private int level;

        Pair() {
        }

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    // ! for printeing data of node
    public static void display(Node node) {
        String str = node.data + "->";
        for (Node child : node.children) {
            str += child.data + " ";
        }
        System.out.println(str);
        // ! for printing sub child nodes data
        for (Node sub_childs : node.children) {
            display(sub_childs);
        }
    }
    public static Node construct(int[] arr) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];
    
                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }
                st.push(t);
            }
        }
        return root;
    }
    // ! return size of tree
    public static int size(Node node) {
        int size = 0;
        for (Node child : node.children) {
            int childSize = size(child);
            size = size + childSize;
        }
        size++;
        return size;
    }

    public static int maximum(Node node) {
        int max = 0;
        for (Node child : node.children) {
            int childMax = maximum(child);
            if (child.data > max) {
                max = child.data;
            }
            if (max < childMax) {
                max = childMax;
            }
        }
        return max;
    }
    public static int edgeHight(Node node) {
        int nodeHight = -1;
        for (Node child : node.children) {
            int childrenHight = edgeHight(child);
            nodeHight = Math.max(childrenHight, nodeHight);
        }
        nodeHight++;
        return nodeHight;
    }

    public static int nodeHeight(Node node) {
        int nh = 0;
        for (Node child : node.children) {
            int ch = nodeHeight(child);
            if (ch > nh) {
                nh = ch;
            }
        }
        nh++;
        return nh;
    }

    public static void traversal(Node node) {
        /*
         * ! PRE
         * ! Euler path @ Nodes left side before going deep in recursion
         * ? POST
         * ? Euler path @ Nodes Right side while comming out of recurssion
         */
        System.out.println("Node Pre " + node.data);
        for (Node childe : node.children) {
            System.out.println("Edge Pre " + node.data + "-->" + childe.data);
            traversal(childe);
            System.out.println("Edge Post " + node.data + "-->" + childe.data);
        }
        System.out.println("Node Post " + node.data);

    }

    public static void levelOrderTraveral(Node node) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);
        while (qu.size() > 0) {
            node = qu.remove();
            System.out.print(node.data + " ");
            for (Node child : node.children) {
                // levelOrderTraveral(child);
                qu.add(child);
            }
        }
    }

    public static void levelOrderLinewise1(Node node) {
        Queue<Node> root = new ArrayDeque<>();
        Queue<Node> leaf = new ArrayDeque<>();
        // ! remove print addChildren
        root.add(node);
        while (root.size() > 0) {
            node = root.remove();
            System.out.print(node.data + " ");
            for (Node child : node.children) {
                leaf.add(child);
            }
            if (root.size() == 0) {
                root = leaf;
                leaf = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    private static void levelOrderLinewise2(Node node) {
        Queue<Node> mainQ = new ArrayDeque<>();
        mainQ.add(node);
        mainQ.add(new Node(-1));
        while (mainQ.size() > 0) {
            node = mainQ.remove();
            if (node.data != -1) {
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    mainQ.add(child);
                }
            } else {
                if (mainQ.size() > 0) {
                    mainQ.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }

    private static void levelOrderLinewise3(Node node) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);
        while (qu.size() > 0) {
            int len = qu.size();
            for (int i = 0; i < len; i++) {
                node = qu.remove();
                System.out.print(node.data + " ");
                for (Node child : node.children) {
                    qu.add(child);
                }
            }
            System.out.println();
        }
    }

    private static void levelOrderLinewise4(Node node) {
        Queue<Pair> qu = new ArrayDeque<>();
        qu.add(new Pair(node, 1));
        int level = 1;
        while (qu.size() > 0) {
            Pair p = qu.remove();
            System.out.print(p.node.data + " ");
            if (p.level > level) {
                level = p.level;
                System.out.println();
            }
            for (Node child : p.node.children) {
                Pair cn = new Pair(child, p.level + 1);
                qu.add(cn);
            }
        }
    }

    public static void zigzagLinewise(Node node) {
        Stack<Node> mainStack = new Stack<>();
        mainStack.push(node);
        Stack<Node> smallStack = new Stack<>();
        int level = 1;
        while (mainStack.size() > 0) {
            node = mainStack.pop();
            System.out.print(node.data + " ");
            if (level % 2 == 1) {
                // ! if level is odd
                for (int i = 0; i < node.children.size(); i++) {
                    Node child = node.children.get(i);
                    smallStack.push(child);
                }
            } else {
                // ! else level is even
                for (int j = node.children.size() - 1; j >= 0; j--) {
                    Node child = node.children.get(j);
                    smallStack.push(child);
                }
            }
            if (mainStack.size() == 0) {
                mainStack = smallStack;
                smallStack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void mirror(Node node) {
        if (node.children.size() != 0) {
            Collections.reverse(node.children);
        }
        for (Node child : node.children) {
            mirror(child);
        }
    }

    public static void removeLeves(Node node) {
        // ! traverse loop backwards
        // ! if child dont have childs remove sub-child
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.size() == 0) {
                node.children.remove(child);
            }
        }
        // ! call recurssion
        for (Node child : node.children) {
            removeLeves(child);
        }
    }

    public static void linearizeGT1(Node node) {
        // ! traversing from root so root will have to only one children -(multilecel
        // chid)
        for (Node child : node.children) {
            linearizeGT1(child);
        }
        while (node.children.size() > 1) {
            // ! find last child
            Node lastChild = node.children.remove(node.children.size() - 1);
            // ! find second last child
            Node secondLastChild = node.children.get(node.children.size() - 1);
            // ! get tail of second last child
            Node secondLastTail = getTail(secondLastChild);
            // ! join tail to first child
            secondLastTail.children.add(lastChild);
        }
    }

    private static Node getTail(Node secondLastChild) {
        while (secondLastChild.children.size() == 1) {
            secondLastChild = secondLastChild.children.get(0);
        }
        return secondLastChild;
    }

    public static Node linearizeGT2(Node node) {
        if (node.children.size() == 0) {
            return node;// ! return becoz its leaf
        }
        Node lastTail = linearizeGT2(node.children.get(node.children.size() - 1));
        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node secondLast = node.children.get(node.children.size() - 1);
            Node secondLastTail = linearizeGT2(secondLast);
            secondLastTail.children.add(last);
        }
        return lastTail;
    }

    public static boolean findElement(Node node, int target) {
        if (node.children.size() == 0 && node.data == target) {
            return true;// ! it may be leaf with target value
        }
        for (Node child : node.children) {
            boolean firstChild = findElement(child, target);
            if (firstChild) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        // ! in case it itself contains that data
        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for (Node child : node.children) {
            ArrayList<Integer> childTillPath = nodeToRootPath(child, data);
            if (childTillPath.size() > 0) {
                childTillPath.add(node.data);
                return childTillPath;
            }
        }
        return new ArrayList<>();
    }

    public static int commanAncestor(Node node, int num1, int num2) {
        ArrayList<Integer> path1 = nodeToRootPath(node, num1);
        ArrayList<Integer> path2 = nodeToRootPath(node, num2);
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return path1.get(i);
    }

    public static int distanceBetweenNodes(Node node, int num1, int num2) {
        ArrayList<Integer> path1 = nodeToRootPath(node, num1);
        ArrayList<Integer> path2 = nodeToRootPath(node, num2);
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return i + j;
    }
    public static boolean areTreesSimilar(Node n1,Node n2){
        if(n1.children.size()!=n2.children.size()){
            return false;
        }
        for(int i=0;i<n2.children.size();i++){
            Node c1=n1.children.get(i);
            Node c2=n2.children.get(i);
            if(areTreesSimilar(c1, c2)==false){
                return false;
            }
        }
        return true;
    }
    public static boolean areTreesMirror(Node a,Node b){
        if(a.children.size()!=b.children.size()){
            return false;
        }
        for(int i=0;i<a.children.size();i++){
            int j=a.children.size()-1-i;
            Node c1=a.children.get(i);
            Node c2=b.children.get(j);
            boolean ifChild=areTreesMirror(c1, c2);
            if(ifChild==false){
                return false;
            }
        }
        return true;
    }
    //! if node is mirror image of itself then it is sysmetric
    public static boolean isTreeSymmetric(Node node){
        if(areTreesMirror(node, node)){
            return true;
        }
        return false;
    }
    public static int predecessor;
    public static int successor;
    public static int state;
    public static void predecessor_Successor(Node node,int target){
        //! PREDECSSOR-just before target node
        //! SUCCESSOR-just after target node
        if(state==0){
            if(node.data==target){
                state=1;
            }
            else{
                predecessor=node.data;
            }
        }
        else if(state==1){
            successor=node.data;
            state=2;
        }
        for(Node child:node.children){
            predecessor_Successor(child, target);
        }
    }
    //! parameters are in stack while going into recurssion they become and while comming back
    //! they ran away
    //! but data members are in heap while going into recurssion they changes are allowed while
    //! while comming out of recursion

    public static int ceil;//smallest amoung larger ->MAX
    public static int floor;//largest amoung smaller ->MIN
    public static void ceil_floor(Node node,int target){
        if(node.data>target){
            if(node.data<ceil){
                ceil=node.data;
            }
        }
        if(node.data<target){
            if(node.data>floor){
                floor=node.data;
            }
        }
        for(Node child:node.children){
            ceil_floor(child, target);
        }
    }
    public static int[] sort(Node node){
        int arr[]=new int[node.children.size()];
        int max=-1;
        for(int i=0;i<node.children.size();i++){
            max=Math.max(max, node.data);
            arr[i]=max;
        }
        for(Node child:node.children){
            kthLargest(child, arr.length);
        }
        return arr;
    }
    public static int kthLargest(Node node,int k){
        floor=Integer.MIN_VALUE;
        int factor=Integer.MAX_VALUE;
        for(int i=0;i<k;i++){
            ceil_floor(node, factor);
            factor=floor;
            floor=Integer.MIN_VALUE;
        }
        return factor;
    }
    public static int TreeSum(Node node){
        int sum=0;
        for(Node child:node.children){
            int childSum=TreeSum(child);
            sum+=childSum+node.data;
        }
        return sum;
    }
    static int maxDataAtNode=0;
    static int maxSum=Integer.MIN_VALUE;
    public static int subTreeSum(Node node){
        int sum1=0;
        for(Node child:node.children){
            int ifChild=subTreeSum(child);
            sum1+=ifChild;
        }
        sum1+=node.data;
        if(sum1>maxSum){
            maxDataAtNode=node.data;
            maxSum=sum1;
        }
        return sum1;
    }
    public static void main(String[] args) {

        int arr[] = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        int arr1[] = {1,2,5,-1,6,-1,-1,3,7,-1,8,11,-1,12,-1,-1,9,-1,-1,4,10,-1,-1,-1};

        Node root=construct(arr);
        Node root1=construct(arr1);
        // display(root);
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

        // ArrayList<Integer> lst = nodeToRootPath(root, 110);
        // System.out.println(lst);

        // System.out.print(commanAncestor(root, 80,90));
        // System.out.print(distanceBetweenNodes(root, 30,90));

        // System.out.println();
        // display(root);

        // System.out.println(areTreesSimilar(root, root1));
        // System.out.println(areTreesMirror(root, root1));
        // System.out.println(isTreeSymmetric(root));

        // int target=40;
        // predecessor_Successor(root, target);
        // System.out.println(predecessor+" is predecessor of "+target);
        // System.out.println(successor+" is successor of "+target);
        
        // ceil=Integer.MAX_VALUE;//smallest amoung larger
        // floor=Integer.MIN_VALUE;//larger amoung smaller
        // ceil_floor(root, 64);
        // System.out.println(ceil);
        // System.out.println(floor);
        
        // int copy[]=new int[root.children.size()];
        // copy=sort(root);
        
        // for(int j=0;j<copy.length;j++){
        //     System.out.print(arr[j]+" ");
        // }
        // System.out.println();

        // System.out.println(kthLargest(root, 3));

        // System.out.println(TreeSum(root));
        
        subTreeSum(root);
        System.out.println(maxDataAtNode+"@"+maxSum);

    }
}
