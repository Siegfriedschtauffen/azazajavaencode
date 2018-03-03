import java.util.Scanner;

class Shifrator {
    private String message;
    private String encodedMessage;
    private String decodedMessage;
    private int password;

    void setMsg(String message){
        this.message = message;
    }

    void setKey(String password){
        for (int i=0;i<password.length();i++)
            this.password += password.charAt(i);
    }

    String getMessage(){
        return message;
    }

    String getEncodedMessage(){
        return encodedMessage;
    }

    String getDecodedMessage(){
        return decodedMessage;
    }

    int getPassword(){
        int
    }

    String encode(){
        encodedMessage ="";
        for (int i = 0; i< message.length(); i++)
            // Построение зашифрованной строки сообщения.
            encodedMessage += (char) (message.charAt(i) ^ this.password);
        return encodedMessage;
    }



    String decode(String encode_msg, String key){
        encodedMessage = encode_msg;
        pass = key;
        decodedMessage ="";
        for (int i=0;i<pass.length();i++)
            this.password += (pass.charAt(i));
        // дешифровать сообщение
        for (int i = 0; i< encodedMessage.length(); i++)
            // Построение дешифрованной строки сообщения.
            decodedMessage = decodedMessage + (char) (encodedMessage.charAt(i) ^ this.password);
        return decodedMessage;
    }

    String getencmsg(){
        return encodedMessage;
    }

    void ramka(){
        System.out.println("\n====================================" +
                "==============================================\n");
    }
    void errormsg(String text){
        System.out.println(text);
    }




}

public class Maza {
    public static void main(String[] args) {
        Shifrator shifrator = new Shifrator();

        done:
        for (;;) {
            shifrator.ramka();
            System.out.println("Выберите м нажмите Enter\n");
            System.out.println("\t\"1\" чтобы зашифровать текст");
            System.out.println("\t\"2\" чтобы расшифровать текст\n");
            System.out.println("\"q\" чтобы выйти из программы");
            System.out.print("\nВыберите действие: ");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            done2:
            switch (choice) {
                case "1":
                    for (; ; ) {
                        shifrator.ramka();

                        System.out.print("\tВведите текст: ");
                        Scanner scanMessage = new Scanner(System.in);
                        String message = scanMessage.nextLine();
                        shifrator.setMsg(message);

                        // создать пароль шифра
                        System.out.print("\tСоздайте пароль шифра: ");
                        Scanner scanPass = new Scanner(System.in);
                        String pass = scanPass.nextLine();
                        shifrator.setKey(pass);
                        String encodedMessage = shifrator.encode();

                        System.out.println("\n\tВаш зашифрованный текст: ");
                        System.out.println("\t\t" + encodedMessage);

                        shifrator.ramka();

                        for (;;){
                            System.out.print("Продолжить? (y/n): ");
                            Scanner sc2 = new Scanner(System.in);
                            String q = sc2.nextLine();
                            if (q.equals("n")) break done2;
                            if (q.equals("y")) break;
                        }
                    }
                case "2":
                    for (; ; ) {
                        shifrator.ramka();
                        System.out.print("\tВведите зашифврованный текст: ");
                        Scanner msgscan2 = new Scanner(System.in);
                        String shifr = msgscan2.nextLine();

                        System.out.print("\tВведите пароль): ");
                        Scanner keyscan2 = new Scanner(System.in);
                        String key2 = keyscan2.nextLine();

                        Shifrator rashif = new Shifrator();
                        System.out.println("\n\tВаш расшифрованный текст: " + "\n\t\t" + rashif.decode(shifr, key2));
                        shifrator.ramka();

                        for (;;){
                            System.out.print("Продолжить? (y/n): ");
                            Scanner sc2 = new Scanner(System.in);
                            String q = sc2.nextLine();
                            if (q.equals("n")) break done2;
                            if (q.equals("y")) break;
                        }
                    }
                case "q":
                    break done;
                default:
                    shifrator.ramka();
                    shifrator.errormsg("\tЭй! Выбирай из списка! Че, слепой!? >_< " +
                            "Написано же, выбрать \"1\", \"2\" или \"q\"! \n\tДавай давай, поновой!");
            }


        }
    }
}

