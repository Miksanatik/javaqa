package Animals;

abstract public class Animal {
    private static int animalCount;
    protected String name;
    protected int maxRunLength;
    protected int maxSwimLength;
    abstract void run(int length);
    abstract void swim(int length);
    public Animal (String name) {
        this.name = name;
        animalCount++;
    }
    public static int getAnimalCount() {
        return animalCount;
    }
}
