package String;
public class stringBuilder{
    static void possibleSubString(String s){
        for(int i=0;i<s.length()+1;i++){
            for(int j=i+1;j<s.length()+1;j++){
                System.out.println(s.substring(i,j));
            }System.out.println();
        }
    }
    static void palindromSubString(String str){
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<=str.length();j++){
                if(isPalidrome(str.substring(i,j))){
                    System.out.println(str.substring(i,j));
                }
            }
        }
    }
    static boolean isPalidrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        //! possible substing problem
        // String myNew0="abcd";
        // possibleSubString(myNew0);
        // System.out.println(myNew.substring());

        //! split on the basis of given chrachter
        // String myNew1="abcd efgh ijkl mnop qrst uvwx yz";
        // String save[]=myNew1.split(" ");//! space chrachter
        // for(int i=0;i<save.length;i++){
        //     System.out.println(save[i]);
        // }System.out.println();

        //! for printing palindrome substrings
        String myNew2="abccb";
        System.out.println(isPalidrome(myNew2));
        /*
        !a
        ab
        abc
        abcc
        abccb
        abccbc

        !b
        bc
        bcc
        !bccb
        bccbc

        !c
        !cc
        ccb
        ccbc

        !c
        cb
        !cbc

        !b
        bc

        !c
        */
    }
}