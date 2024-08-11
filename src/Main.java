import Animals.Animal;
import Animals.Bowl;
import Animals.Cat;
import Animals.Dog;
import Figures.Circle;
import Figures.Rectangle;
import Figures.Triangle;

public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(100);

        Dog dog = new Dog("Шарик");

        Cat[] cats = new Cat[] {new Cat("Помпушка", bowl),
                                new Cat("Печенька", bowl),
                                new Cat("Мармеладка", bowl),
                                new Cat("Молочко", bowl),
                                new Cat("Круассан", bowl)};

        for(Cat cat : cats) {
            System.out.println(cat.getName() + " сыт(а): " + cat.isHungry());
        }

        System.out.println();

        for (Cat cat : cats) {
            cat.feedCat(25);
        }

        for(Cat cat : cats) {
            System.out.println(cat.getName() + " сыт(а): " + cat.isHungry());
        }

        System.out.println();
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего кошек: " + Cat.getCatCount());
        System.out.println("Всего собак: " + Dog.getDogCount());

        Circle circle = new Circle(10, "Blue", "Green");
        Triangle triangle = new Triangle(11,4,9,"Red", "Brown");
        Rectangle rectangle = new Rectangle(11, 8, "Magenta", "Yellow");

        System.out.println();
        System.out.println(circle);
        System.out.println(triangle);
        System.out.println(rectangle);
    }
}