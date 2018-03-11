import java.util.Scanner;

/*
 Изменение кода программы 1.

     Объеденены в один метод encode два метода.
     Один из них принимал значения текста и пароля, другой шифровал их.
     Также удалены переменные, хранящие данные текста и пароля, в классе Shifrator2, за ненадобностью.
     Таким обрахом удалось существенно сократить код.
     Сделал методы статическими, таким образом ненужно создавать объект класса.
*/
class Shifrator2 {

    // просто рамка
    static void ramka(){
        System.out.println("\n====================================" +
                "==============================================\n");
    }

    // метод принимающий в качестве параметра данные (текст и пароль)
    // для дальнейшей шифровки или дешифровки текста
    // и его возврата
    static String encode (String message, String password){
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
        Scanner scan = new Scanner(System.in);
        String q;
        do {
            // рамка
            Shifrator2.ramka();

            // ввод текста или шифра с клавиатуры
            System.out.print("\tТекст: ");
            String message = scan.nextLine();

            // ввод пароля с клавиатуры
            System.out.print("\tПароль шифра: ");
            String pass = scan.nextLine();

            // вызов
            String encodedMessage = Shifrator2.encode(message,pass);

            // отображения результата (шифрованный либо дешифрованный текст)
            System.out.println("\n\tВаш зашифрованный текст: ");
            System.out.println("\t\t" + encodedMessage);

            // рамка
            Shifrator2.ramka();

            // ввод с клавиатуры символа q для завершения цикла
            System.out.print("Для выхода нажмите q, для продолжения нажмите что угодно: ");
            q = scan.nextLine();

        }while (!q.equals("q"));// условие завершения цикла (соответсвенно программы) при нажатии "q"
    }
}