package  Sorter;

/**
 *
 * @author me
 */
public class OctagonalPrism extends Shape3D {

    private double edgeLength;
    private double height;

    public OctagonalPrism(double height, double edgeLength) {
        super(height);
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * edgeLength * edgeLength;
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

    @Override
    public String toString() {
        return "OctagonalPrism:" +", height=" + height+ ", edgeLength=" + edgeLength;
    }

    
}
