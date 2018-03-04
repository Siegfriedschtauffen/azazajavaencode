import java.util.Scanner;

class Shifrator {
    private String message;
    private String encodedMessage;
    private int password;

    // метод принимающий текст и пароль, после чего созраняет их в переменных message и password
    void setMsgAndPass(String message, String password){
        this.message ="";
        this.password = 0;
        this.message = message;
        for (int i=0;i<password.length();i++)
            this.password += password.charAt(i);
    }
    // просто рамка
    void ramka(){
        System.out.println("\n====================================" +
                "==============================================\n");
    }
    // метод, который зашифровывает текст, ну и, на всякий случай, сохраняет шифр в переменной encodeMessage
    String encode(){
        encodedMessage ="";
        for (int i = 0; i< message.length(); i++)
            // Построение зашифрованной строки сообщения.
            encodedMessage += (char) (message.charAt(i) ^ this.password);
        return encodedMessage;
    }
    // метод сканирующий текст (создан, чтобы не создавать многократно объект класса Scanner)
    String scanText(){
        Scanner scan = new Scanner(System.in);
        String msg = scan.nextLine();
        return msg;
    }
}

public class Maza {
    public static void main(String[] args) {
        Shifrator shifrator = new Shifrator();

        for (; ; ) {
            // рамка
            shifrator.ramka();

            // ввод текста или шифра)
            System.out.print("\tТекст: ");
            String message = shifrator.scanText();

            // ввод пароля
            System.out.print("\tПароль шифра: ");
            String pass = shifrator.scanText();

            // вызов метода шифровки текста или дешифроки
            shifrator.setMsgAndPass(message, pass);

            // отображения результата (шифр либо дешифрованный текст)
            String encodedMessage = shifrator.encode();
            System.out.println("\n\tВаш зашифрованный текст: ");
            System.out.println("\t\t" + encodedMessage);

            // рамка
            shifrator.ramka();

            // операция выхода из цикла (соответсвенно из программы), либо его продолжения
            System.out.print("Для выхода нажмите q, для продолжения нажмите что угодно: ");
            String q = shifrator.scanText();

            if (q.equals("q")) break;
        }
    }
}