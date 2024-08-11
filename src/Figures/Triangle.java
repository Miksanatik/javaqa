package Figures;

public class Triangle implements Figure{

    public String fillColor;
    public String outlineColor;

    public int sideA;
    public int sideB;
    public int sideC;

    public Triangle(int sideA, int sideB, int sideC, String fillColor, String outlineColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.outlineColor = outlineColor;
        this.fillColor = fillColor;
    }
    @Override
    public double getPerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    @Override
    public double getArea() {
        return Math.sqrt(0.5 * getPerimeter() *
                (0.5 * getPerimeter() - this.sideA) *
                (0.5 * getPerimeter() - this.sideB) *
                (0.5 * getPerimeter() - this.sideC));
    }

    @Override
    public String toString() {
        return "[ " + "Perimeter: "+ this.getPerimeter()
                + " Area: " + this.getArea()
                + " Fill color: " + this.fillColor
                + " Outline color: " + this.outlineColor + "]";
    }
}
