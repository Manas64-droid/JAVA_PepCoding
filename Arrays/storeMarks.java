package Arrays;

public class storeMarks {
    static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;

    }
    public static void main(String[] args) {
        int[] marks=new int[5];
        marks[0]=12;
        marks[1]=13;
        marks[2]=14;
        marks[3]=15;
        marks[4]=16;

        //!shallo copy
        int temp[]=marks;
        temp[1]=590;

        //!shallo copy
        swap(marks, 4, 0);

        System.out.println(marks.length);
        int count=1;
        for (int i : marks) {
            System.out.println("Roll Number:"+count +" -"+i);
            count++;
        }
    }


}
