
import java.util.Scanner;

public class proves {
     public static double suma(double num1, double num2) {
            return num1 + num2;
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el primer numero: ");
            double i = scanner.nextDouble();
            System.out.print("Introduce el segon numero: ");
            double j = scanner.nextDouble();

            double a = suma(i, j);

            System.out.println("El total de la suma es : " + a);
        }
    }