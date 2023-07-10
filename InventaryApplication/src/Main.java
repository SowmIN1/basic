import java.util.Scanner;

public class Main {
    public static void calculateSquareValues() {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            
            input = scanner.nextInt();

            if (input == -1) {
                System.out.println("invalid input");
                break;
            }

            int square = input * input;
            System.out.println(square);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        calculateSquareValues();
    }
}





