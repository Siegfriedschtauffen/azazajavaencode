import java.io.*;
import java.util.Scanner;

public class Maza5 {
    public static void main(String[] args) {
        String aza;
        Scanner scan = new Scanner(System.in);
        aza = scan.nextLine();

        FileOutputStream fout = null;
        if (args.length!=1) {
            System.out.println("Hey WTF!???");
            return;
        }

        try {
            fout = new FileOutputStream(args[0]);
        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }

        try {
            for (int i = 0; i < aza.length(); i++) {
                fout.write(aza.charAt(i));
            }
        }catch (IOException e){
            System.out.println("Error: "+e);
        }try {
            fout.close();
        }catch (IOException e){
            System.out.println("Error closing output file.");
        }
    }
}
