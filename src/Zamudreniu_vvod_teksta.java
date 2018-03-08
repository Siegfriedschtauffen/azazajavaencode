import java.util.Scanner;

class Hz {

    public Hz(){   //конструктор
        System.out.println("Привет!");
    }

    public Hz(String one){
        System.out.println("Здравствуйте, господин "+one+"!");
    }

    public Hz(String one, String two){
        System.out.println("Здравствуйте, "+two+" "+one+"!");
    }

    public Hz(String one, String two, String three){
        System.out.println("Здравствуйте, "+two+" "+one+" "+three+"!");
    }


}

public class Zamudreniu_vvod_teksta {
    public static void main(String[] args) {

        for (;;) {
            System.out.print("Введите свое имя (можно полностью): ");
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();

            StringBuilder word1 = new StringBuilder("");
            StringBuilder word2 = new StringBuilder("");
            StringBuilder word3 = new StringBuilder("");
            int a = 0;


            while (a < str.length()) {
                word1.append(str.charAt(a));
                if (str.charAt(a) == ' ') break;
                a++;
            }
            while (a < str.length()) {
                if (str.charAt(a) != ' ') break;
                a++;
            }
            while (a < str.length()) {
                word2.append(str.charAt(a));
                if (str.charAt(a) == ' ') break;
                a++;
            }
            while (a < str.length()) {
                if (str.charAt(a) != ' ') break;
                a++;
            }
            while (a < str.length()) {
                word3.append(str.charAt(a));
                if (str.charAt(a) == ' ') break;
                a++;
            }

//            word1.setCharAt(0,(char)(word1.charAt(0)-32));        НАДО ПОРАБОТАТЬ НАД ЭТИМ!!
//            word2.setCharAt(0,(char)(word1.charAt(0)-32));
//            word3.setCharAt(0,(char)(word1.charAt(0)-32));

            if (word2.toString().isEmpty() & word3.toString().isEmpty())
                System.out.println("Здравствуй, господин "+word1);
            else if (word3.toString().isEmpty()) System.out.println("Здравствуйте, "+word1+word2);

            else System.out.println("Здравствуйте, "+word1+word2+word3);




        }



        //        for (; a < str.length(); a++) {
//            word1.append(str.charAt(a));
//            if (str.charAt(a) == ' ') break;
//        }
//
//        for (;a<str.length();a++)
//            if (str.charAt(a)!=' ')break;
//
//        for (; a<str.length(); a++){
//            word2.append(str.charAt(a));
//            if (str.charAt(a)==' ')break;
//        }
//
//        for (;a<str.length();a++)
//            if (str.charAt(a)!=' ')break;
//
//        for (; a < str.length(); a++) {
//            word3.append(str.charAt(a));
//            if (str.charAt(a) == ' ') break;
//        }

    }
}