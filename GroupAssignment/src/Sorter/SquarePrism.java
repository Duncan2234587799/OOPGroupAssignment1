package  Sorter;
/**
 *
 * @author me
 */
public class SquarePrism extends Shape3D {

    private double height;
    private double edgeLength;

    public SquarePrism(double height, double edgeLength) {
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
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return "SquarePrism:" + "height=" + height + ", edgeLength=" + edgeLength;
    }

   
}
