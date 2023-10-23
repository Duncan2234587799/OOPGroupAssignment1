package Sorter;
/**
 *
 * @author me
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class ShapeFileReader {

    public static Shape3D[] readShapesFromFile(String filePath, char comparisonType) throws IOException {
        Shape3D[] shapes;
        Comparator<Shape3D> comparator = null;

        switch (comparisonType) {
            case 'h':
            case 'H':
                comparator = Comparator.naturalOrder(); // since compareTo in Shape3D is based on height
                break;
            case 'v':
            case 'V':
                comparator = Shape3D.VolumeComparator;
                break;
            case 'a':
            case 'A':
                comparator = Shape3D.BaseAreaComparator;
                break;
            default:
                throw new IllegalArgumentException("Invalid comparison type: " + comparisonType);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read the entire line
            String line = reader.readLine().trim();

            // Split the line to extract the number of shapes
            String[] allParts = line.split(" ");
            int numberOfShapes = Integer.parseInt(allParts[0]);
            shapes = new Shape3D[numberOfShapes];

            // Loop through the rest of the parts to read and instantiate shapes
            int partIndex = 1;  // Start from the 2nd part, as the first part is the count
            for (int i = 0; i < numberOfShapes; i++) {
                String shapeType = allParts[partIndex++];
                double height = Double.parseDouble(allParts[partIndex++]);
                double dimension = Double.parseDouble(allParts[partIndex++]);

                switch (shapeType) {
                    case "Cylinder":
                        shapes[i] = new Cylinder(height, dimension);
                        break;
                    case "Cone":
                        shapes[i] = new Cone(height, dimension);
                        break;
                    case "Pyramid":
                        shapes[i] = new Pyramid(height, dimension);
                        break;
                    case "SquarePrism":
                        shapes[i] = new SquarePrism(height, dimension);
                        break;
                    case "TriangularPrism":
                        shapes[i] = new TriangularPrism(height, dimension);
                        break;
                    case "PentagonalPrism":
                        shapes[i] = new PentagonalPrism(height, dimension);
                        break;
                    case "OctagonalPrism":
                        shapes[i] = new OctagonalPrism(height, dimension);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid shape type: " + shapeType);
                }
            }
        }

        // Sort shapes by the provided comparator
        Arrays.sort(shapes, comparator);
        
        return shapes;
    }
}

