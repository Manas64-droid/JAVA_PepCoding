
public class normalStack{
    public static class CustomStack{
        int data[];
        int stackPointer;
        int size;
        int DEFAULT_SIZE;
        
        public CustomStack(){
            this.DEFAULT_SIZE=11;
            data=new int[DEFAULT_SIZE];
            this.stackPointer=-1;
        }
        public int size(){
            return stackPointer+1;
        }
        public void push(int val){
            if(size==data.length-1){
                push1(val);
            }
            else{
                stackPointer++;
                data[stackPointer]=val;
                size++;
            }
        }
        public void push1(int val){
            int arr[]=new int[data.length*2];
            for(int i=0;i<data.length;i++){
                arr[i]=data[i];
            }
            stackPointer++;
            data=arr;
        }
        public void display(){
            int i=size()-1;
            while(i>=0){
                System.out.print(data[i]+" ");
                i--;
            }
            System.out.println();
        }
        public int peek(){
            if(stackPointer==-1){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                return data[stackPointer];
            }
        }
        public int pop(){
            if(size()==0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else{
                size--;
                return data[stackPointer--];
            }
        }
    }
    public static void main(String[] args) {
        CustomStack st=new CustomStack();
        // st.add(0);
        for(int i=1;i<=10;i++){
            st.push(i*10);
        }
        st.display();
        System.out.println(st.size);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());
        st.display();
    }
}