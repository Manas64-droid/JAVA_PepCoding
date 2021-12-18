package String;

public class purmutationOfString {
    public static void printPurmutation(String str){
        int len=str.length();
        int facto=factorial(len);
        for(int i=1;i<facto;i++){
            StringBuilder sb=new StringBuilder(str);
            int temp=i;
            for(int j=len;j>=1;j--){
                int q=temp/j;
                int r=temp%j;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp=q;
            }
            System.out.println();
        }
    }
    public static int factorial(int n){
        int fact=1;
        for(int i=2;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }
    public static void main(String[] args) {
        printPurmutation("aabc");
        
    }
}
