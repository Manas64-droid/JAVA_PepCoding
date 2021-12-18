package Arrays;

import java.util.Scanner;

public class BarChart {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int nFloor=sc.nextInt();
        int building[]=new int[nFloor];

        int max=building[0];
        for(int i=0;i<building.length;i++){
            building[i]=sc.nextInt();
            if(building[i]>max){
                max=building[i];
            }
        }
        // System.out.println(max);
        for(int floor=max;floor>=1;floor--){
            for(int i=0;i<building.length;i++){
                if(building[i]>floor){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        
    }
}
