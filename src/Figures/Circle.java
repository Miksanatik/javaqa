package Figures;

public class Circle implements Figure{
    public String fillColor;
    public String outlineColor;
    public int radius;

    public Circle(int radius, String fillColor, String outlineColor) {
        this.radius = radius;
        this.outlineColor = outlineColor;
        this.fillColor = fillColor;
    }

    @Override
    public double getArea() {
        return 3.14 * this.radius * this.radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.14 * this.radius;
    }

    @Override
    public String toString() {
        return "[ " + "Perimeter: "+ this.getPerimeter()
                + " Area: " + this.getArea()
                + " Fill color: " + this.fillColor
                + " Outline color: " + this.outlineColor + "]";
    }
}
