package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    static int[] nextGreaterElement(int arr[]){
        int nextGreaterE[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        
        st.push(arr[arr.length-1]); //! push last element in stack
        nextGreaterE[arr.length-1]=-1; //! make last element =-1 coz last element has no greater element
        //? -> pops ans pushes
        for(int i=arr.length-2;i>=0;i--){ //! decreasing for loop
            //! until stack have elements into it && arr[i]>st.peek;
            //! BIG ELEMENT POP EVERY SMALLER EMELMENT
            while(st.size()>0 && arr[i]>=st.peek()){
                st.pop();
            }
            //! if stack is empty
            if(st.isEmpty()){
                nextGreaterE[i]=-1; //! self is greater element
            }
            //! self element get pop when he found greater element than him
            else{
                nextGreaterE[i]=st.peek();
            }
            //! 
            st.push(arr[i]);
        }
        return nextGreaterE;
        
    }
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // System.out.println("Enter How Many");
        // int n=sc.nextInt();
        // int arr[]=new int[n];//! n=8
        // for(int i=0;i<arr.length;i++){
        //     arr[i]=sc.nextInt();
        // }
        //! NEXT GREATER ELEMENT OF NUMBER ON RIGHT
        //! 2 5 9 3 1 12 6 8 7
        //? [5, 9, 12, 12, 12, -1, 8, -1, -1]
        int arr1[]={2 ,5 ,9 ,3 ,1 ,12 ,6 ,8 ,7};
        int arr2[]=nextGreaterElement(arr1);
        System.out.println(Arrays.toString(arr2));


    }
}
