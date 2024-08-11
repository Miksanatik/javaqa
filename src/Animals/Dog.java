package Animals;

public class Dog extends Animal {
    private static int dogCount;
    public Dog(String name) {
        super(name);
        this.maxRunLength = 500;
        this.maxSwimLength = 10;
        dogCount++;
    }
    public void run (int length) {
        if(length >= 0 && length <= this.maxRunLength)
            System.out.println(this.name + " пробежал " + length + " м.");
        else
            System.out.println(this.name + " не может пробежать " + length + " м.");
    }
    public void swim (int length) {
        if(length >= 0 && length <= this.maxSwimLength)
            System.out.println(this.name + " проплыл " + length + " м.");
        else
            System.out.println(this.name + " не может проплыть " + length + " м.");
    }
    public static int getDogCount(){
        return dogCount;
    }
}
