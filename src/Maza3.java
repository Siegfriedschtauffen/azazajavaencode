import java.util.Scanner;

/*
 Изменение кода программы 2.

     Алгоритм изменения текстового пароля в числовой вынесен в отдельный приватный метод passToInt()

     Возвращены переменные в классе Shifrator3.
*/
class Shifrator3 {
    private String message;
    private String encMsg;
    private String strPass;
    private int intPass;


    // просто рамка
    void ramka(){
        System.out.println("\n====================================" +
                "==============================================\n");
    }

    String scanText(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    String encode (String message, String password){

        this.message = message;
        strPass = password;
        Shifrator3 ob = new Shifrator3();
        intPass = ob.passToInt(password);

        StringBuilder encMsg = new StringBuilder();
        for (int i = 0; i< message.length(); i++)
            // Построение зашифрованной строки сообщения.
            encMsg.append((char) (message.charAt(i) ^ ob.passToInt(password)));
        this.encMsg = encMsg.toString();
        return encMsg.toString();
    }

    private int passToInt(String strPass){
        intPass = 0;
        for (int i=0;i<strPass.length();i++)
            intPass += strPass.charAt(i);
        return intPass;
    }

}

public class Maza3 {
    public static void main(String[] args) {
        Shifrator3 shifrator = new Shifrator3();
        String q;
        do {
            // рамка
            shifrator.ramka();

            // ввод текста или шифра с клавиатуры
            System.out.print("\tТекст: ");
            String message = shifrator.scanText();

            // ввод пароля с клавиатуры
            System.out.print("\tПароль шифра: ");
            String pass = shifrator.scanText();

            // вызов метода принимающего в качестве параметра данные (текст и пароль)
            // для дальнейшей шифровки или дешифровки текста с паролем и возврата их значений
            String encodedMessage = shifrator.encode(message.isEmpty()?"azaza":message,pass);

            // отображения результата (шифрованный либо дешифрованный текст)
            System.out.println("\n\tВаш зашифрованный текст: ");
            System.out.println("\t\t" + encodedMessage);

            // рамка
            shifrator.ramka();

            // ввод с клавиатуры символа q для завершения цикла
            System.out.print("Для выхода нажмите q, для продолжения нажмите что угодно: ");
            q = shifrator.scanText();

        }while (!q.equals("q"));// условие завершения цикла (соответсвенно программы) при нажатии "q"
    }
}