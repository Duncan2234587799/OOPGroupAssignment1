package Sorter;

/**
 *
 * @author me
 */
public class Cone extends Shape3D {

    private double radius;
    private double height;

    public Cone(double height, double radius) {
        super(height);
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double getBaseArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height / 3.0;
    }

    @Override
    public String toString() {
        return "Cone: Height=" + height + ", Radius=" + radius;
    }

       

}
