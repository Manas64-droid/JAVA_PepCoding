package String;
public class prepCoding_Fibo_Recursion{
    static int fibo(int n,int qb[]){
        if(n==0 || n==1){
            return n;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        System.out.println("Hello "+n);
        int fib=fibo(n-1,qb)+fibo(n-2,qb);

        qb[n]=fib;
        return fib;
    }
    static int fiboN(int n){
        if(n==1||n==0){
            return n;
        }
        System.out.println("Hello "+n);
        int fib=fiboN(n-1)+fiboN(n-2);
        return fib;
    }
    public static void main(String[] args) {
        int n=10;
        System.out.println(fiboN(n));
        System.out.println();

        //! memoization
        System.out.println(fibo(n,new int[n+1]));
    }
}