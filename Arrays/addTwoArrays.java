package Arrays;

import java.util.Scanner;

public class addTwoArrays {
    
    public static void main(String[] args) {
        Scanner sc1=new Scanner(System.in);
        Scanner sc2=new Scanner(System.in);
        Scanner sc3=new Scanner(System.in);
        Scanner sc4=new Scanner(System.in);
        System.out.print("How many Elemnets in arr1:");
        int nElements1=sc1.nextInt();
        System.out.print("How many Elemnets in arr2:");
        int nElements2=sc2.nextInt();


        int[] arr1=new int[nElements1];
        int[] arr2=new int[nElements2];
        int sum[]=new int[nElements1>nElements2?nElements1:nElements2];
        System.out.println("Enter Number in arr1");
        for(int i=0;i<arr1.length;i++){
            arr1[i]=sc3.nextInt();
        }
        System.out.println("Enter Number in arr2");
        for(int i=0;i<arr2.length;i++){
            arr2[i]=sc4.nextInt();
        }
        
        int arr1Len1=arr1.length-1;
        int arrLen2=arr2.length-1;
        int sumLen=sum.length-1;
        
        int carry=0;
        while(sumLen>=0){
            int digit=carry;
            if(arr1Len1>=0){
                digit+=arr1[arr1Len1];
            }
            if(arrLen2>=0){
                digit+=arr2[arrLen2];
            }
            carry=digit/10;
            digit=digit%10;
            
            sum[sumLen]=digit;
            arr1Len1--;
            arrLen2--;
            sumLen--;
        }
        System.out.print("Result:");
        if(carry!=0){
            System.out.print(carry);
        }
        for (int i : sum) {
            System.out.print(i);
        }
        
    }
}
