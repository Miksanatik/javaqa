package Animals;

public class Cat extends Animal {
    private static int catCount;
    private boolean satiety;
    private final Bowl bowl;
    public Cat(String name, Bowl bowl) {
        super(name);
        catCount++;
        this.maxRunLength = 200;
        this.maxSwimLength = 0;
        this.satiety = false;
        this.bowl = bowl;
    }

    public void run (int length) {
        if(length >= 0 && length <= this.maxRunLength)
            System.out.println(this.name + " пробежал " + length + " м.");
        else
            System.out.println(this.name + " не может пробежать " + length + " м.");
    }

    public void swim (int length) {
        System.out.println(this.name + " не умеет плавать.");
    }

    public static int getCatCount(){
        return catCount;
    }

    public boolean isHungry(){
        return satiety;
    }

    public void feedCat(int foodQuantity){
        this.satiety = this.bowl.feed(foodQuantity);
    }

    public String getName(){
        return this.name;
    }
}
