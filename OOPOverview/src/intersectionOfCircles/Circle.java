package intersectionOfCircles;

public class Circle {
    private Point center;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getX() {
        return this.center.getX();
    }

    public int getY() {
        return this.center.getY();
    }
}
