package Stack;


public class normalStack {
    public static class CustomStack{
        int[] data;
        int stackPointer;
        CustomStack(int len){
            data=new int[len];
            stackPointer=-1;
        }
        int size(){
            return stackPointer+1;
        }
        void display(){
            System.out.print("[");
            for(int i=data.length-1;i>0;i--){
                System.out.print(data[i]+" ");
            }
            System.out.println("]");
        }
        int top(){
            if(stackPointer==-1){
                System.out.println("Stack underflow");
                return -1;
            }
            else{
                return data[stackPointer];
            }
        }
        void push(int val){
            if(stackPointer==data.length-1){
                System.out.println("Stack overflow");
            }
            else{
                stackPointer++;
                data[stackPointer]=val;
            }
        }
        int pop(){
            if(stackPointer==-1){
                System.out.println("Stack overflow");
                return -1;
            }
            else{
                int val=data[stackPointer];
                stackPointer--;
                return val;
            }
        }
    }
    public static class CustomStack1 extends CustomStack{
        CustomStack1(int len) {
            super(len);
            //TODO Auto-generated constructor stub
        }

        int dynamicPush(int val){
            if(stackPointer==data.length-1){
                int darr[]=new int[2*data.length];
                for(int i=0;i<=data.length;i++){
                    darr[i]=data[i];
                }
                stackPointer++;
                data=darr;
                return data[stackPointer];

            }
            else{
                stackPointer++;
                return data[stackPointer]=val;
            }
        }
        
    }
    public static class CustomStack2 extends CustomStack1{

        CustomStack2(int len) {
            super(len);
            //TODO Auto-generated constructor stub
        }
        int minimum(){
            int min=data[0];
            for(int i=0;i<data.length;i++){
                if(min>data[i]){
                    min=data[i];
                }
            }
            return min;
        }
    }
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        CustomStack2 st= new CustomStack2(5);
        st.dynamicPush(5);
        st.dynamicPush(6);
        st.dynamicPush(1);
        st.dynamicPush(8);
        st.dynamicPush(9);

        System.out.println(st.minimum());
        st.display();
    }
}
