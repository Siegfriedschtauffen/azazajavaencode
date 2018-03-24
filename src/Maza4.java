import java.io.*;
import java.util.Scanner;

class Shifrator4{
    private String message;
    private String password;
    private String encMessage;
    private int key;

    private void encPass(String password){
        key=0;
        for (int i=0;i<password.length();i++)
            key+=password.charAt(i);
    }
    private void encMsg(String message){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i< message.length(); i++)
            sb.append((char)(message.charAt(i)^key));
        encMessage = sb.toString();
    }
    void encode(String message,String password){
        this.message=message;
        this.password=password;
        this.encPass(password);
        this.encMsg(message);
    }
    void makeFile(String fileName){
        try (FileWriter fw = new FileWriter(fileName)){
        fw.write(encMessage);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

    void fileEncode(String fileName1,String fileName2, String password){
        this.encPass(password);
        int i=0;
        StringBuilder sb = new StringBuilder();
        try(FileReader fr = new FileReader(fileName1);
        FileWriter fw = new FileWriter(fileName2)){
            do {
                i=fr.read();
                sb.append(((char)(i^key)));
                if (i!=-1)fw.write((char) i^key);
            }while (i!=-1);
        }catch (IOException e){
            System.out.println("I/O Error: "+e);
        }
        encMessage=sb.toString();
    }
    String getEncMessage(){return encMessage;}
    // просто рамка
    void ramka(){
        System.out.println("\n====================================" +
                "==============================================\n");
    }
    void ramka2(){
        System.out.println("\n------------------------------------" +
                "----------------------------------------------\n");
    }
}
public class Maza4{
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Shifrator4 sf=new Shifrator4();

        for (;;){
            // рамка
            sf.ramka();
            System.out.println("\tШифровка и дешифровка текста в консоли - '1'");
            System.out.println("\tШифровка и дешифровка текста из файла - '2'");
            System.out.println("\tВыйти - 'q'");
            System.out.print("\n\tСделайте выбор: ");
            String choice = scan.nextLine();
            switch (choice) {
                case "1":
                    sf.ramka();

                    // ввод текста или шифра с клавиатуры
                    System.out.print("\tТекст: ");
                    String msg = scan.nextLine();

                    // ввод пароля с клавиатуры
                    System.out.print("\tПароль шифра: ");
                    String pass = scan.nextLine();

                    sf.encode(msg,pass);

                    System.out.println("\n\tВаш зашифрованный текст: ");
                    System.out.println("\t\t" + sf.getEncMessage());

                    for (;;){
                        System.out.print("\n\tСохранить шифр в текстовый файл файле? (y/n):");
                        String choice2=scan.nextLine();
                        if (choice2.equals("y")){
                            System.out.print("\n\tПридумайте имя для файла с шифром: ");
                            String fileName = scan.nextLine();
                            sf.makeFile(fileName+".txt");
                            System.out.println("\n\tШифр сохранен в файл "+fileName+".txt");
                            break;
                        }else if (choice2.equals("n")) {
                            break;
                        }
                        else {
                            sf.ramka2();
                            System.out.println("Для особо 'умных'.. Выберите 'y' или 'n'!");
                        }
                    }
                    break;
                case "2":
                    sf.ramka();
                    System.out.print("\tВведите имя исходного файла: ");
                    String a = scan.nextLine();
                    System.out.print("\n\tПридумайте имя файла с расшифрованным текстом: ");
                    String b = scan.nextLine();
                    System.out.print("\n\tВведите пароль: ");
                    String c = scan.nextLine();
                    sf.fileEncode(a+".txt",b+".txt",c);
                    sf.ramka2();
                    System.out.println("\tРасшифрованный текст: \n\n\t\t"+sf.getEncMessage());
                    break;
                case "q":
                    return;
                default:
                    sf.ramka2();
                    System.out.println("Неверный оператор");
            }
        }
    }
}