package ArrayLIst;
import java.util.*;
public class KK_CustomArrayList2Genrics {
    public static class CustomArrayList2<T>{
        Object data[];
        int DEFAULT_SIZE=10;
        int size=0;
        CustomArrayList2(){
            data=new Object[DEFAULT_SIZE];
        }
        public void add(T val){
            if(size==data.length){  
                Object temp[]=new Object[data.length*2];
                for(int i=0;i<data.length;i++){
                    temp[i]=data[i];
                }
                data=temp;
            }
            data[size++]=val;
        }
        public T remove(){
            T removed=(T)data[size--];
            return removed;
        }
        public T get(int index){
            return (T)data[index];
        }
        public void set(T val,int index){
            data[index]=val;
        }
        public int size(){
            return this.size;
        }
        
        public String display(){
            return "Array Elements "+Arrays.toString(data)+"\n"+
                    "Array Size "+this.size+"\n";

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
        CustomArrayList2<Integer> list1=new CustomArrayList2<>();
        for(int i=1;i<=15;i++){
            list1.add(5*i);
            if(i==10){
                break;
            }
        }
        System.out.println(list1.display());
    }
}
