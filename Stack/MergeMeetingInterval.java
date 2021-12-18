package Stack;

import java.io.*;
import java.util.*;

public class MergeMeetingInterval {
    public static void mergeOverlappingMeetingIntervals(int arr[][]){
        Pair[] pairs=new Pair[arr.length];
        for(int i=0;i<arr.length;i++){
            pairs[i]=new Pair(arr[i][0], arr[i][1]);
        }

        Arrays.sort(pairs);
        
        Stack<Pair> st=new Stack<>();
        for(int j=0;j<pairs.length;j++){
            if(j==0){
                st.push(pairs[j]);
            }else{
                Pair top=st.peek();
                if(pairs[j].startTime>=top.startTime){
                    st.push(pairs[j]);
                }
                else{
                    top.endTime=Math.max(top.startTime, pairs[j].endTime);
                }
            }
        }
        Stack<Pair> result=new Stack<>();
        while(st.size()>0){
            result.push(st.pop());
        }
        while (result.size()>0) {
            Pair p=result.pop();
            System.out.println(p.startTime+" "+p.endTime);
        }
    }
    public static class Pair implements Comparable<Pair>{
        int startTime;
        int endTime;
        Pair(int startTime,int endTime){
            this.startTime=startTime;
            this.endTime=endTime;
        }
        // @Override
        //! if this > other return +ve
        //! if this = other return 0
        //! if this < other return -ve
        public int compareTo(Pair other) {
            // TODO Auto-generated method stub
            if(this.startTime!=other.startTime){
                return this.startTime-other.startTime;
            }
            else{
                return this.endTime-other.endTime;
            }
            // return 0;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[][]= new int[n][2];
        for(int i=0;i<n;i++){
            String line=br.readLine();
            arr[i][0]=Integer.parseInt(line.split(" ")[0]);
            arr[i][1]=Integer.parseInt(line.split(" ")[0]);
        }
        mergeOverlappingMeetingIntervals(arr);
    }
    
}
