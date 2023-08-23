import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите число (для завершения введите -1): ");
            int number = scanner.nextInt();

            if (number == -1) {
                System.out.println("Программа завершена.");
                break;
            }

            if (number < 0 || number > 10000) {
                System.out.println("Число должно быть от 0 до 10000.");
            } else {
                String result = CurrencyConverter.convertToWords(number);
                System.out.println(result);
            }
        }

        scanner.close();
    }
}
