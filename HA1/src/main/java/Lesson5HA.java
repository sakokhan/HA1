import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson5HA {
    public static void main(String[] args) {
        increaseTheValueAndFindSum(createMatrix());
        chessBoard();
        snake();

    }
    public static int[][] createMatrix() {
        Random random = new Random();
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(1, 100);
            }
            System.out.println(Arrays.toString(matrix[i]));
        }
        return matrix;
    }
    public static void increaseTheValueAndFindSum(int[][] matrix){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение, на которое следует увеличить значение элементов массива.");
        int val = scanner.nextInt();
        int sum = 0;
        for(int[] element:matrix){
            for (int i = 0; i < element.length; i++) {
                element[i] +=val;
                sum+= element[i];
            }
            System.out.println(Arrays.toString(element));
        }
        System.out.println("Сумма всех элементов матрицы: " + sum);
    }
    public static void chessBoard(){
        char[][] chessBoard = new char[8][8];
        for(int i = 0; i < chessBoard.length; i++){
            for (int j = 0; j < chessBoard[i].length; j++) {
                if(i%2!=0){
                    if(j%2!=0){
                        chessBoard[i][j] = 'W';
                    }else {chessBoard[i][j] = 'B';}
                }else{
                    if(j%2==0) chessBoard[i][j] = 'W';
                    else {chessBoard[i][j] = 'B';}
                }
            }
            System.out.println(Arrays.toString(chessBoard[i]));
        }
    }
    public static void snake(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите первое число");
        int n = scanner.nextInt();
        System.out.println("Укажите второе число число");
        int m = scanner.nextInt();
        int [][] snake = new int[n][m];
        int temp = 0;
        for (int i = 0; i < n; i++) {

            if(i%2==0) {
                for (int j = 0; j < m; j++) {
                    snake[i][j] = temp;
                    System.out.print(" "+snake[i][j]+" ");
                    temp+=1;
                }
            }else{
                for (int j = 0; j < m; j++) {
                    snake[i][m-1-j] = temp;
                    temp+=1;;
                }
                for (int j = 0; j < m; j++) {
                    System.out.print(" "+snake[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
