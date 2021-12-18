package Arrays;

import java.util.Scanner;
public class spanArray {

    static int[] returnArray(int nElements){
        int arr[]=new int[nElements];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        return arr;
    }
    static int returnSpan(int arr[]){
        int store1=arr[0];
        int store2=arr[0];
        for(int i=0;i<arr.length;i++){
            if(store1>arr[i]){
                store1=arr[i];
            }
        }
        for(int i=0;i<arr.length;i++){
            if(store2<arr[i]){
                store2=arr[i];
            }
        }
        return store2-store1;
    }
    public static void main(String[] args) {
        /*
        get number from user of count of elemnts in array
        calculate the span
        span=Highest number-lowest number
        */
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number Of Element:");
        int numberOfElemnts=sc.nextInt();
        System.out.println("Enter Numbers:");
        int temp[]=returnArray(numberOfElemnts);
        System.out.println("Diffrence-"+returnSpan(temp));
    }

}
