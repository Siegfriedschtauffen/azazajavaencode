import java.util.Scanner;

public class PeremennayaDlinaMassiva {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String azaMass[] = new String[1];
        String copyMass[];

        for (int i = 0; ; i++) {

            copyMass = new String[i + 1];
            if (i >= 1) {
                for (int j = 0; j < azaMass.length; j++) {
                    copyMass[j] = azaMass[j];
                }
            }

            copyMass[i] = scan.nextLine();
            if (copyMass[i].isEmpty()) break;

            azaMass = new String[i + 1];
            for (int k = 0; k < copyMass.length; k++) {
                azaMass[k] = copyMass[k];
            }
            if (copyMass[i].isEmpty()) break;
        }


        System.out.print("Элементы массива: ");
        for (int i = 0; i < azaMass.length; i++) {
            System.out.print(azaMass[i] + " ");
        }
        System.out.println("\nДлина массива: " + azaMass.length);

    }
}