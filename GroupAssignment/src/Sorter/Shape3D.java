package  Sorter;

/**
 *
 * @author me
 */
import java.util.Comparator;

public abstract class Shape3D implements Comparable<Shape3D> {

    protected double height;

    public Shape3D(double height) {
        this.height = height;
    }

    public abstract double getBaseArea();

    public abstract double getVolume();

    @Override
    public int compareTo(Shape3D other) {
        return Double.compare(this.height, other.height);
    }

    // Comparators for volume and base area
    public static Comparator<Shape3D> VolumeComparator = Comparator.comparingDouble(Shape3D::getVolume);
    public static Comparator<Shape3D> BaseAreaComparator = Comparator.comparingDouble(Shape3D::getBaseArea);
/*
  @Override
    public String toString() {
        return "Cone with height: " + height + ", volume: " + getVolume() + ", base area: " + getBaseArea();
    }

   */
}
