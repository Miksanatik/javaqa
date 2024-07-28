import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Task 1 printThreeWords() method");
        Lesson.printThreeWords();
        System.out.println();

        System.out.println("Task 2 checkSumSign() method");
        Lesson.checkSumSign();
        System.out.println();

        System.out.println("Task 3 printColor() method");
        Lesson.printColor();
        System.out.println();

        System.out.println("Task 4 compareNumbers() method");
        Lesson.compareNumbers();
        System.out.println();

        System.out.println("Task 5: number between 10 and 20");
        System.out.println(Lesson.isSumBetweenTenAndTwenty(10,0));
        System.out.println();

        System.out.println("Task 6: positive or negative");
        Lesson.isPositiveOrNegative(0);
        System.out.println();

        System.out.println("Task 7: is postitve?");
        System.out.println(Lesson.isPositive(0));
        System.out.println();

        System.out.println("Task 8: string in the loop");
        Lesson.loop("Hello world", 5);
        System.out.println();

        System.out.println("Task 9: is leap year?");
        System.out.println(Lesson.isLeapYear(604));
        System.out.println();


        System.out.println("Task 10: numbers exchange");
        Lesson.exchange();
        System.out.println();

        System.out.println("Task 11: numbers filling");
        Lesson.fill();
        System.out.println();

        System.out.println("Task 12: numbers filling");
        Lesson.multiply();
        System.out.println();

        System.out.println("Task 13: bypass matrix");
        Lesson.bypassArray();
        System.out.println();

        System.out.println("Task 14: getting array");
        System.out.println(Arrays.toString(Lesson.getArray(10, 5)));
        System.out.println();

    }
}