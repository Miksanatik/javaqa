package Figures;

public class Rectangle implements Figure {
    public String fillColor;
    public String outlineColor;

    public int sideA;
    public int sideB;

    public Rectangle(int sideA, int sideB, String fillColor, String outlineColor) {
        this.fillColor = fillColor;
        this.outlineColor = outlineColor;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double getPerimeter() {
        return 2 * this.sideA * this.sideB;
    }

    @Override
    public double getArea() {
        return this.sideA * this.sideB;
    }

    @Override
    public String toString() {
        return "[ " + "Perimeter: "+ this.getPerimeter()
                + " Area: " + this.getArea()
                + " Fill color: " + this.fillColor
                + " Outline color: " + this.outlineColor + "]";
    }
}
