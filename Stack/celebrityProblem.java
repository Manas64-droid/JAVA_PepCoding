package Stack;

import java.io.*;
import java.util.*;
public class celebrityProblem {
    static void findCelebrity(int arr[][]){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            st.push(i);
        }
        while(st.size()>=2){
            int p1=st.pop();
            int p2=st.pop();
            if(arr[p1][p2]==1){
                //! if i knows j i is !celibrity
                st.push(p2);
            }
            else{
                //! if i dont know j i=celibrity
                st.push(p1);
            }
        }
        int potentialCelibrity=st.pop();
        for(int i=0;i<arr.length;i++){
            if(i!=potentialCelibrity){
                if(arr[i][potentialCelibrity]==0 || arr[potentialCelibrity][i]==1){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potentialCelibrity);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        // int n=Integer.parseInt(br.readLine());
        int arr[][]={
            {0,1,1,0},
            {1,0,1,1},
            {0,0,0,0},
            {1,0,1,0},
        };

        // for(int i=0;i<n;i++){
        //     // String str =br.readLine();
        //     for(int j=0;j<n;j++){
        //         arr[j][i]=str.charAt(j-'0');
        //     }
        // }
        findCelebrity(arr);
        // System.out.println(Arrays.toString(arr));
        for(int x=0;x<arr.length;x++){
            for(int u=0;u<arr.length;u++){
                System.out.print(arr[x][u]);
            }
            System.out.println();
        }        
    }
}
