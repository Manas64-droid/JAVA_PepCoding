package FilesHandling;
import java.io.*;
import java.util.*;
public class CWH_FileHandling {
    public static void main(String[] args) throws Exception{
        File myfFile=new File("FilesHandling/manas.txt");
        //create new file
        myfFile.createNewFile();

        //code to write into new file
        FileWriter myFileWriter=new FileWriter("FilesHandling/manas.txt");
        for(int i=1;i<=30;i++){
            for(int j=1;j<=10;j++){
                myFileWriter.write(i+"x"+j+"="+i*j+"\n");
            }
            myFileWriter.write("\n");
        }
        myFileWriter.close();

        //reading a file
        File myFile2=new File("FilesHandling/manas.txt");
        Scanner sc=new Scanner(myFile2);
        while(sc.hasNextLine()){
            String str=sc.nextLine();
            System.out.println(str);
        }
        sc.close();

        //deleting file 
        File myFile3=new File("poop.txt");
        if(myFile3.delete()){
            System.out.println("Deleted");
        }
        else{
            System.out.println("Not Deleted");
        }
    }
}
