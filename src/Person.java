public class Person {
    private String name;
    private Position position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;


    public Person (String name,
                   Position position,
                   String email,
                   String phoneNumber,
                   int salary,
                   int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }


    public void print() {
        System.out.println("[" +name + ", " +
                position.name() + ", " +
                email + ", " +
                phoneNumber + ", " +
                salary + ", " +
                age + "]");
    }
}

