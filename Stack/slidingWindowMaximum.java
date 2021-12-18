package Stack;

import java.util.*;

public class slidingWindowMaximum {
    static int[] slidingWindowMaximum1(int arr[],int slidingWindow){
        int sld[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        sld[arr.length-1]=arr.length;
        st.push(arr.length);
        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]>=st.peek()){
                st.pop();
            }
            if(st.size()==0){
                sld[i]=arr.length;
            }
            else{
                sld[i]=st.peek();
            }
            st.push(arr[i]);
        }
        int j=0;
        for(int i=0;i<arr.length-slidingWindow;i++){
            if(j<i){
                j=i;
            }
            //! if next greater in window then go to that next greater
            while(sld[j]<i+slidingWindow){
                j=sld[j];
            }
            System.out.print(arr[j]+" ");
        }
        System.out.println();
        return sld;
    }
    public static void main(String[] args) {
        int arr[]={9,44,2,3,6,12,1,115,66,7,99,57,88};
        System.out.println(Arrays.toString(slidingWindowMaximum1(arr, 4)));
    }
}
