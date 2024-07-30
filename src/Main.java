import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person(
                "Alex",
                Position.Director,
                "mail@gmail.com",
                "+375291234567",
                30000,
                28);
        persons[1] = new Person(
                "Andrew",
                Position.Analyst,
                "andrrrr@gmail.com",
                "+4912345678901",
                25000,
                31);
        persons[2] = new Person(
                "Ivan",
                Position.Consultant,
                "ivanthebest@gmail.com",
                "+71234567892",
                20000,
                25);
        persons[3] = new Person(
                "Anna",
                Position.Marketer,
                "anna@gmail.com",
                "+375441234567",
                26500,
                22);
        persons[4] = new Person(
                "Victor",
                Position.Translator,
                "victorthompson@gmail.com",
                "+112345682467",
                20000,
                36);
    }
}