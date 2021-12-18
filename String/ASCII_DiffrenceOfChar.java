package String;
public class ASCII_DiffrenceOfChar {
    static String toDiffrenceChar(String str){
        StringBuilder sb= new StringBuilder();
        sb.append(str.charAt(0));
        for(int i=1;i<str.length();i++){
            char currentChar=str.charAt(i);
            char previousChar=str.charAt(i-1);
            int calculateGap=(char)currentChar-previousChar;
            sb.append(calculateGap);
            sb.append(currentChar);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String output=toDiffrenceChar("Manas");
        System.out.println(output);
    }
}
