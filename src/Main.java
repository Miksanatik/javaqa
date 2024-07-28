import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1 printThreeWords() method");
        printThreeWords();
        System.out.println();

        System.out.println("Task 2 checkSumSign() method");
        checkSumSign();
        System.out.println();

        System.out.println("Task 3 printColor() method");
        printColor();
        System.out.println();

        System.out.println("Task 4 compareNumbers() method");
        compareNumbers();
        System.out.println();

        System.out.println("Task 5: number between 10 and 20");
        System.out.println(isSumBetweenTenAndTwenty(10,0));
        System.out.println();

        System.out.println("Task 6: positive or negative");
        isPositiveOrNegative(0);
        System.out.println();

        System.out.println("Task 7: is postitve?");
        System.out.println(isPositive(0));
        System.out.println();

        System.out.println("Task 8: string in the loop");
        useLoop("Hello, world!", 5);
        System.out.println();

        System.out.println("Task 9: is leap year?");
        System.out.println(isLeapYear(604));
        System.out.println();


        System.out.println("Task 10: numbers exchange");
        exchange();
        System.out.println();

        System.out.println("Task 11: numbers filling");
        fill();
        System.out.println();

        System.out.println("Task 12: numbers editing");
        multiply();
        System.out.println();

        System.out.println("Task 13: matrix bypass");
        bypassArray();
        System.out.println();

        System.out.println("Task 14: getting array");
        System.out.println(Arrays.toString(getArray(10, 5)));
        System.out.println();

    }

    public static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign(){
        int a = 1;
        int b = 2;
        if (a + b >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    public static void printColor(){
        int value = 101;
        if (value <= 0)
            System.out.println("Красный");
        else if (value > 0 && value <=100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }

    public static void  compareNumbers(){
        int a = 10;
        int b = 11;
        if (a >= b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }

    public static  boolean isSumBetweenTenAndTwenty(int a, int b){
        return (a+b) >= 10 && (a+b) <= 20;
    }

    public static void isPositiveOrNegative(int number){
        if (number < 0)
            System.out.println("Negative");
        else
            System.out.println("Positive");
    }

    public static boolean isPositive (int number) {
        return number >= 0;
    }

    public static void useLoop(String string, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(i + 1 + ". " + string);
        }
    }

    public static boolean isLeapYear (int year) {
        if (year % 400 == 0)
            return  true;
        return (year % 4 == 0) && (year % 100 != 0);
    }

    public static void exchange() {
        int[] array = new int[] {0,1,1,0,1,0,0,0,1,1,1,1,0,1,1,0};
        System.out.println("Before: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1)
                array[i] = 0;
            else
                array[i] = 1;
        }
        System.out.println("After:  " + Arrays.toString(array));
    }

    public static void fill() {
        int[] array = new int[100];
        System.out.println("Before: " + Arrays.toString(array));
        for(int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println("After:  " + Arrays.toString(array));
    }

    public static void multiply() {
        int[] array = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Before: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 6;
        }
        System.out.println("After:  " + Arrays.toString(array));
    }

    public static void bypassArray() {
        int[][] matrix = new int[5][5];
        System.out.println("Before:");
        for (int[] rows : matrix) {
            for (int columns : rows) {
                System.out.print(columns + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][matrix.length - 1 - i] = 1;
        }

        System.out.println("After:");
        for (int[] rows : matrix) {
            for (int columns : rows) {
                System.out.print(columns + "\t");
            }
            System.out.println();
        }
    }

    public static int[] getArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }
}