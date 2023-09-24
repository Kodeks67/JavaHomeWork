// Task 1
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float userInput = readFloatFromUser();
        System.out.println("Вы ввели число: " + userInput);
    }

    public static float readFloatFromUser() {
        Scanner scanner = new Scanner(System.in);
        float result = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите дробное число (типа float): ");
                result = Float.parseFloat(scanner.nextLine());
                validInput = true; // Установить флаг в true, если ввод корректный
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный ввод. Пожалуйста, введите дробное число.");
            }
        }

        return result;
    }
}
// Task 2
try {
   int d = 0;
   if (d != 0) {
       double catchedRes1 = intArray[8] / d;
       System.out.println("catchedRes1 = " + catchedRes1);
   } else {
       System.out.println("Деление на ноль невозможно.");
   }
} catch (ArithmeticException e) {
   System.out.println("Catching exception: " + e);
}
// Task 3
public class Main {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9; // Может вызвать IndexOutOfBoundsException
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (ArithmeticException ex) {
            System.out.println("Деление на ноль!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}
// Task 4
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float userInput = readFloatFromUser();
        System.out.println("Вы ввели число: " + userInput);
    }

    public static float readFloatFromUser() {
        Scanner scanner = new Scanner(System.in);
        float result = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите дробное число (типа float): ");
                String input = scanner.nextLine();

                if (input.isEmpty()) {
                    throw new Exception("Ошибка: Пустые строки вводить нельзя.");
                }

                result = Float.parseFloat(input);
                validInput = true; // Установить флаг в true, если ввод корректный
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Некорректный ввод. Пожалуйста, введите дробное число.");
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Вывести сообщение об ошибке
            }
        }

        return result;
    }
}
