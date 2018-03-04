import java.util.Scanner;

class Shifrator {
    private String message;
    private int password;

    // метод принимающий текст и пароль, после чего созраняет их в переменных message и password
    // пароль конвертируется из символьного в числовой тип путем сложения числовых значений всех символов
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
    // метод, который зашифровывает текст
    String encode(){
        StringBuilder encMsg = new StringBuilder();
        for (int i = 0; i< message.length(); i++)
            // Построение зашифрованной строки сообщения.
            encMsg.append((char) (message.charAt(i) ^ password));
        return encMsg.toString();
    }
    // метод сканирующий текст (создан, чтобы не создавать многократно объект класса Scanner)
    String scanText(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}

public class Maza {
    public static void main(String[] args) {
        Shifrator shifrator = new Shifrator();

        // бесконечный цикл повторения программы
        for (; ; ) {
            // рамка
            shifrator.ramka();

            // ввод текста или шифра с клавиатуры
            System.out.print("\tТекст: ");
            String message = shifrator.scanText();

            // ввод пароля с клавиатуры
            System.out.print("\tПароль шифра: ");
            String pass = shifrator.scanText();

            // вызов метода принимающего текст и пароль
            shifrator.setMsgAndPass(message, pass);

            // вызов метода шифровки или дешифровки текста
            String encodedMessage = shifrator.encode();

            // отображения результата (шифрованный либо дешифрованный текст)
            System.out.println("\n\tВаш зашифрованный текст: ");
            System.out.println("\t\t" + encodedMessage);

            // рамка
            shifrator.ramka();

            // ввод с клавиатуры символа q для выхода из программы
            System.out.print("Для выхода нажмите q, для продолжения нажмите что угодно: ");
            String q = shifrator.scanText();

            // операция выхода из цикла (соответсвенно из программы) при нажатии "q",
            // в ином случае цикл продолжится
            if (q.equals("q")) break;
        }
    }
}