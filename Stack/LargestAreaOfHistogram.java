package Stack;

import java.util.Stack;

public class LargestAreaOfHistogram {
    static int largestAreaOfHistogram(int arr[]){
        Stack<Integer> st=new Stack<>();

        int rightHisto[]=new int[arr.length];
        st.push(arr.length-1); //! push last element in array
        rightHisto[arr.length-1]=arr.length; //! last index=arr.length-1;
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                rightHisto[i]=arr.length;
            }
            else{
                rightHisto[i]=st.peek();
            }
            st.push(i);
        }
        int[] leftHisto=new int[arr.length];
        st.push(0); //! push last element in array
        leftHisto[0]=-1; //! last index=arr.length-1;
        for(int i=1;i<=arr.length-1;i++){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                leftHisto[i]=-1;
            }
            else{
                leftHisto[i]=st.peek();
            }
            st.push(i);
        }


        int maxHistoArea=0;
        for(int i=0;i<arr.length;i++){
            int width=rightHisto[i]-leftHisto[i]-1;
            int area=width*arr[i];
            if(area>maxHistoArea){
                maxHistoArea=area;
            }
        }
        return maxHistoArea;
    }
    public static void main(String[] args) {
        int arr[]={6,2,5,4,5,1,6,};
        System.out.println(largestAreaOfHistogram(arr));
    }
}
