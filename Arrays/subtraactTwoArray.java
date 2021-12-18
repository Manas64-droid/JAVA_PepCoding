package Arrays;

import java.util.Scanner;

public class subtraactTwoArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("How many Elemnets in arr1:");
        int el1=sc.nextInt();
        int arr1[]=new int[el1];
        System.out.println("Enter Number in arr1");
        for(int i=0;i<arr1.length;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.print("How many Elemnets in arr2:");
        int el2=sc.nextInt();
        int[] arr2=new int[el2];
        System.out.println("Enter Number in arr2");
        for(int i=0;i<arr2.length;i++){
            arr2[i]=sc.nextInt();
        }
        int diffrence[]=new int[el2>el1?el2:el1];

        int i=arr1.length-1;
        int j=arr2.length-1;
        int k=diffrence.length-1;

        int borrow=0;
        while(k>=0){
            int digit=borrow;
            int arr1Digit=i>=0?arr1[i]:0;
            if(arr2[j]+borrow>=arr1Digit){
                digit=arr2[j]+borrow-arr1Digit;
                borrow=0;
            }
            else{
                digit=arr2[j]+borrow+10-arr1Digit;
                borrow=-1;
            }
            diffrence[k]=digit;
            i--;
            j--;
            k--;
        }
        int index=0;
        while(index<diffrence.length){
            if(diffrence[index]==0){
                index++;
            }
            else{
                break;
            }
        }
        // while(index<diffrence.length){
        //     System.out.println(diffrence[index]);
        //     index++;
        // }
        for (int arr3 : diffrence) {
            System.out.print(arr3);
        }
    }
}
