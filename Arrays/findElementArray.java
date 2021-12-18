package Arrays;

import java.util.Scanner;

public class findElementArray {
    public static int[] returnArray(int nelements){
        int arr[]=new int[nelements];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("How many Elments:");
        int nElements=sc.nextInt();
        System.out.println("Enter Numbers:");
        int temp[]=returnArray(nElements);
        System.out.println("Enter Target Number:");
        int target=sc.nextInt();

        int Index=-1;
        for(int i=0;i<temp.length;i++){
            if(temp[i]==target){
                Index=i;
                break;
            }
        }
        System.out.println("Element Found @Index-"+Index);
    }
}
