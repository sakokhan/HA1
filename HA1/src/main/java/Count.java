import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        checkNumber();
        whatIsTheWether();
        squerOfNumbers();
        multipleSevenNumbers();
        multipleAllNumbers();
    }

    public static void checkNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число.");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if ((number % 2) == 0) {
                System.out.println("Число четное");
            } else {
                System.out.println("Число нечетное");
            }
        } else {
            System.out.println("Это не число.");
        }
    }

    public static void whatIsTheWether() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите значение температуры");
        if (scanner1.hasNextInt()) {
            int t = scanner1.nextInt();
            if (t > -5) {
                System.out.println("Warm");
            } else if (t <= -20) {
                System.out.println("Cold");
            } else {
                System.out.println("Normal");
            }
        } else {
            System.out.println("Некорректное значение температуры. Введите значение по градуснику.");
        }
    }

    public static void squerOfNumbers() {
        double result = 0;
        for (int i = 10; i <= 20; i++) {
            System.out.println(result = Math.pow(i, 2));
        }
    }

    public static void multipleSevenNumbers() {
        int s = 7;
        while (s <= 98) {
            System.out.print(s + " ");
            s = s + 7;
        }
    }

    public static void multipleAllNumbers(){
        Scanner scanner3 = new Scanner(System.in);
        if (scanner3.hasNextInt()){
            int x = scanner3.nextInt();
            int sum = 0;
            if(x > 0){
                while (x>=1){
                    sum = sum + x;
                    x = x - 1;
                }
            }
            System.out.println(sum);
        }else {
            System.out.println("Требуется ввести неотрицательное целое число");
        }
    }
}
