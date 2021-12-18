package String;
public class toggelCase {
    static String toToggelCase(String str){
        StringBuilder sb=new StringBuilder(str);
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(ch>='a' && ch<='z'){
                char uperCase=(char)('A'+ch-'a');
                sb.setCharAt(i,uperCase);
            }else if(ch>='A' && ch<='Z'){
                char lowerCase=(char)('a'+ch-'A');
                sb.setCharAt(i, lowerCase);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(toToggelCase("MANAS M MAHADIK / manas m mahadik"));
    }
}
