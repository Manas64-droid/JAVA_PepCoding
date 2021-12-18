package Stack;

import java.util.Arrays;
import java.util.Stack;
public class spanOfStocks {
    static int[] returnOfSpanArray(int arr[]){
        int span[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.peek()>0 && arr[i]>arr[st.peek()]){
                int position=st.peek();
                span[position]=arr[i];
                st.pop();
            }
            if(st.isEmpty()){
                span[i]=i+1;
            }else{
                span[i]=i-st.peek();
            }
            st.push(i);
        }
        return span;
    }
    public static void main(String[] args) {
        int arr[]={396,454,417,435,430,525,556,575,640,660,635,711,645,658,649};
        System.out.println(Arrays.toString(returnOfSpanArray(arr)));
    }
}
