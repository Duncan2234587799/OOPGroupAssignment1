package  Sorter;

/**
 *
 * @author me
 */
public class Pyramid extends Shape3D {

    private double edgeLength;
    private double height;

    public Pyramid(double height, double edgeLength) {
        super(height);
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double getBaseArea() {
        return edgeLength * edgeLength;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height / 3.0;
    }

    @Override
    public String toString() {
        return "Pyramid:"  + "height=" + height+ ", edgeLength=" + edgeLength;
    }

}
