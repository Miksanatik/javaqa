package Figures;

public interface Figure {
    default double getPerimeter() {
        return 2 * 3.14 * 1;
    }
    default double getArea(){
        return 3.14 * 1 * 1;
    }
}
