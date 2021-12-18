package Recursion;
import java.util.Scanner;

public class RecursionPrintNum {
    public static void printDecreasingIncreasing(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printDecreasingIncreasing(n-1);
        System.out.println(n);

    }
    public static void main(String[] args) {
        System.out.print("Enter Number:");
        Scanner sc=new Scanner(System.in);
        int store=sc.nextInt();
        printDecreasingIncreasing(store);
    }
}
