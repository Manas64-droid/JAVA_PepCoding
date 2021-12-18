package Stack;

import java.util.*;

public class nextGreaterElement1 {
    static int[] findNextGreaterElement(int arr[]){
        Stack<Integer> st=new Stack<>();
        int returnArr[]=new int[arr.length];
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                int position=st.peek();
                returnArr[position]=arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(st.isEmpty()){
            int position=st.peek();
            returnArr[position]=-1;
            st.pop();
        }
        return returnArr;
    }
    public static void main(String[] args) {
        int arr[]={
            2 ,5 ,9 ,3 ,1 ,12 ,6 ,8 ,7};
        //![5, 9, 12, 12, 12, 0, 8, 0, 0]
        System.out.println(Arrays.toString(findNextGreaterElement(arr)));
    }
}
