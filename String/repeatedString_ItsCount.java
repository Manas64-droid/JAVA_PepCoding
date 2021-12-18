package String;
public class repeatedString_ItsCount {
    static String stringCompression1(String str){
        String store=str.charAt(0)+"";

        for(int i=1;i<str.length();i++){
            char currentChar=str.charAt(i);
            char previousChar=str.charAt(i-1);
            if(currentChar!=previousChar){
                store+=currentChar+"";
            }
        }
        return store;
    }
    static String stringCompression2(String str){
        String store=str.charAt(0)+"";
        int count=1;
        for(int i=1;i<str.length();i++){
            char currentChar=str.charAt(i);
            char previousChar=str.charAt(i-1);
            if(currentChar==previousChar){
                count++;
            }else{
                if(count>1){
                    store+=count;
                    count=1;
                }
                store+=currentChar;
            }
        }
        if(count>1){
            store+=count;
            count=1;
        }
        return store;
    }
    public static void main(String[] args) {
        String s="aaabbcdddf";
        String s1="  ";
        System.out.println(stringCompression1(s));

    }
}
