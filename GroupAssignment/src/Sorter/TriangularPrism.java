package  Sorter;
/**
 *
 * @author me
 */
public class TriangularPrism extends Shape3D {

    private double height;
    private final double edgeLength;

    public TriangularPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double getBaseArea() {
        return (Math.sqrt(3) / 4) * edgeLength * edgeLength;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return "TriangularPrism:" + "height=" + height + ", edgeLength=" + edgeLength;
    }

    
}
