import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4HA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте размер массива");
        int arrayNum = scanner.nextInt();
        firstArray(createArray(arrayNum));
        secondArray(arrayNum);
        findMaxMinValueIndex(createArray(arrayNum));
        zeroElements(createArray(arrayNum));
        sortArray(createArray(arrayNum));
        System.out.println(isUpstreamTrend(createArray(arrayNum)));
        createArray();

    }

    public static int[] createArray(int num){
        Random random = new Random();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 100);
        }
        return arr;
    }
    public static void firstArray(int [] arr) {
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.print(arr[arr.length - 1 - i] + " ");
        }
    }
    public static void secondArray(int arrayNum) {
        double[] secondArray = new double[arrayNum];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = Math.random() * 100;
        }
        Arrays.sort(secondArray);
        System.out.println("\r\nМинимальное число в массиве: " + secondArray[0]);
        System.out.println("Максимальное число в массиве: " + secondArray[secondArray.length - 1]);
    }

        public static void findMaxMinValueIndex(int [] arr){
            System.out.println(Arrays.toString(arr));
            int index = 0;
            int maxValue = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= maxValue) {
                    index = i;
                    maxValue = arr[i];
                }
            }
            System.out.println("Индекс максимального элемента массива: " + index);

            int index1 = 0;
            int minValue = 100;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= minValue) {
                    index1 = i;
                    minValue = arr[i];
                }
            }
            System.out.println("Индекс минимального элемента массива: " + index1);
        }

        public static void zeroElements(int [] arr){
            System.out.println(Arrays.toString(arr));
            int countZero = 0;
            for (int element:arr) {

                if (element == 0){
                    countZero +=1;
                }
            }
            if(countZero == 0){
                System.out.println("В массиве нет элементов равных 0.");
            }else{
            System.out.println("В массиве " + countZero + " раз встречается элемент со значением 0.");}
        }

        public static void sortArray(int [] arr){
            System.out.println(Arrays.toString(arr));
            for (int i = 0; i <arr.length/2; i++) {
                int temp;
                temp = arr[i];
                arr[i] = arr[arr.length-1-i];
                arr[arr.length-1-i] = temp;
            }
            System.out.println(Arrays.toString(arr));
        }

        public static boolean isUpstreamTrend(int [] arr){
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i]>arr[i+1]){
                    return false;
                }
            }
            return true;
        }

        public static void createArray(){
            int [] arr = {9,9,9,9};
            String number ="";
            for (int element:arr) {
                String temp = String.valueOf(element);
                number = number + temp;
            }
            int num = Integer.parseInt(number);
            int newNum = num +1;
            String newNumber = String.valueOf(newNum);
            char [] newArray = newNumber.toCharArray();
            int [] numArray = new int[newArray.length];
            for (int i = 0; i < newArray.length; i++) {
                numArray[i] = Character.getNumericValue(newArray[i]);
            }
            System.out.println(Arrays.toString(numArray));
        }
    }
