package ArrayLIst;
import java.util.*;
public class KK_CustomArrayList {
    public static class CustomArrayList1{
        int data[];
        int DEFAULT_SIZE=10;
        int size=0;
        CustomArrayList1(){
            this.data=new int[DEFAULT_SIZE];
        }
        public void add(int val){
            if(size==this.data.length){
                int temp[]=new int[data.length*2];
                for(int i=1; i<data.length;i++){
                    temp[i]=data[i];
                }
                data=temp;
            }
            data[size++]=val;
        }
        public int remove(){
            int removed=data[size--];
            return removed;
        }
        public int get(int index){
            return data[index];
        }
        public int size(){
            return this.size;
        }
        public void set(int val,int index){
            data[index]=val;
        }
        @Override
        public String toString(){
            return "CustomArrayList1{"+
                    "\ndata"+Arrays.toString(data)+
                    "\nsize "+size+
                    "}";
        }
        
    }
    public static void main(String[] args) {
        /*
        !  add
        ! set
        ! remove
        ! size
        ! toString
        ! isEmpty
        */
        CustomArrayList1 list1=new CustomArrayList1();
        for(int i=1;i<=15;i++){
            list1.add(5*i);
            if(i==10){
                break;
            }
        }
        System.out.println(list1.toString());
    }
}
