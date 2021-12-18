package Stack;

import java.util.Stack;
public class normalStackMInFunc1 {
    public static class CustomeStack3{
        Stack<Integer> mainStack=new Stack<>();
        int min;

        void push(int val){
            if(mainStack.size()==0){
                mainStack.push(val);
            }
            else if(val>=this.min){
                // this.min=val;
                mainStack.push(val);
            }
            else{
                min=val;
                mainStack.push(val+val-1);
            }
        }
        void minimum(){
            System.out.println(display());
        }
        int display(){
            int arr[]=new int[mainStack.size()+1];
            // System.out.print("[");
            for(int i=mainStack.size();i>0;i--){
                arr[i]=mainStack.pop();
            }
            int m=arr[5];
            for(int i=0;i<arr.length;i++){
                // if(arr[i]<m){
                //     m+=arr[i];
                // }
                System.out.print(arr[i]+" ");
            }
            return m;
        }
    }
    public static void main(String[] args) {
        CustomeStack3 st=new CustomeStack3();
        st.push(12);
        st.push(14);
        st.push(88);
        st.push(13);
        st.push(11);
        st.push(9);
        st.push(10);
        // System.out.println(st.minimum());
        st.display();
        // st.minimum();
    }
}
