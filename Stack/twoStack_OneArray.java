package Stack;
public class twoStack_OneArray{
    public static class TwoStack_OneArray{
        int data[];
        int stackPointer1;
        int stackPointer2;
        int size;
        public TwoStack_OneArray(int cap) {
            this.data = new int[cap];
            this.stackPointer1 = -1;
            this.stackPointer2 = data.length;
            this.size = 0;
        }
        public int size1(){
            return stackPointer1+1;
        }
        public int size2(){
            return data.length-stackPointer2;
        }
        public void push1(int val){
            if(stackPointer2==stackPointer1+1){
                System.out.println("Stack Overflow");
            }
            stackPointer1++;
            data[stackPointer1]=val;
            size++;
        }
        public void push2(int val){
            if(stackPointer2==stackPointer1+1){
                System.out.println("Stack Overflow");
            }
            stackPointer2--;
            data[stackPointer2]=val;
            size++;
        }
        public int top1(){
            if(size2()==0){
                System.out.println("Stack Underflow");
                return -1;
            }
            return data[stackPointer1];
        }
        public int top2(){
            if(size2()==0){
                System.out.println("Stack Underflow");
                return -1;
            }
            return data[stackPointer2];
        }
        public int pop1(){
            if(size1()==0){
                System.out.println("Stack Underflow");
                return -1;
            }
            int val=data[stackPointer1];
            stackPointer1--;
            size--;
            return val;
        }
        public int pop2(){
            if(size2()==0){
                System.out.println("Stack Underflow");
                return -1;
            }
            int val=data[stackPointer2];
            stackPointer2++;
            size--;
            return val;
        }
        public void display(){
            for(int i=0;i<data.length;i++){
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TwoStack_OneArray tsoa=new TwoStack_OneArray(10);
        for(int i=1;i<=5;i++){
            tsoa.push1(i*5);
        }
        for(int i=6;i<=10;i++){
            tsoa.push2(i*5);
        }
        tsoa.display();
    }
}