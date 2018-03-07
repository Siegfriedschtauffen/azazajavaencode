import java.util.Scanner;

/*
 Изменение кода программы 1.

     Объеденены в один метод encode два метода.
     Один из них принимал значения текста и пароля, другой шифровал их.
     Также удалены переменные, хранящие данные текста и пароля, в классе Shifrator2, за ненадобностью.
     Таким обрахом удалось существенно сократить код.
*/
class Shifrator2 {

    // просто рамка
    void ramka(){
        System.out.println("\n====================================" +
                "==============================================\n");
    }
    // метод сканирующий текст (создан, чтобы не создавать многократно объект класса Scanner)
    String scanText(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    // метод принимающий в качестве параметра данные (текст и пароль)
    // для дальнейшей шифровки или дешифровки текста
    // и его возврата
    String encode (String message, String password){
        StringBuilder encMsg = new StringBuilder();
        // преобразование строкового пароля в числовой путем сложения
        // числовых значений всех символов строкового пароля
        int encPass=0;
        for (int i=0;i<password.length();i++)
            encPass += password.charAt(i);
        for (int i = 0; i< message.length(); i++)
            // Построение зашифрованной строки сообщения.
            encMsg.append((char) (message.charAt(i) ^ encPass));
        return encMsg.toString();
    }
}

public class Maza2 {
    public static void main(String[] args) {
        Shifrator2 shifrator = new Shifrator2();
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

            // вызов
            String encodedMessage = shifrator.encode(message,pass);

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