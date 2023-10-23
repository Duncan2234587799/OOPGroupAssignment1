package Sorter;

/**
 *
 * @author me
 */
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Extract command-line arguments
        String filePath = null;
        char comparisonType = 'v';  // Default to volume
        char sortingAlgorithm = 'b';  // Default to bubble sort

// Iterate over args, handling both short and long arguments
        for (int i = 0; i < args.length; i++) {
            String arg = args[i].toLowerCase();  // Convert to lowercase for case insensitivity

            if (arg.equals("-f") && i + 1 < args.length) {
                filePath = args[++i];
            } else if (arg.startsWith("-f")) {
                filePath = arg.substring(2);  // Take everything after "-f"
            } else if (arg.equals("-t") && i + 1 < args.length) {
                comparisonType = args[++i].toLowerCase().charAt(0);
            } else if (arg.startsWith("-t")) {
                comparisonType = arg.charAt(2);  // Take character after "-t"
            } else if (arg.equals("-s") && i + 1 < args.length) {
                sortingAlgorithm = args[++i].toLowerCase().charAt(0);
            } else if (arg.startsWith("-s")) {
                sortingAlgorithm = arg.charAt(2);  // Take character after "-s"
            } else {
                System.out.println("Invalid argument provided: " + arg);
                System.out.println("Please check the documentation.");
                return;
            }
        }

// Check if the filePath is provided
        if (filePath == null) {
            System.out.println("Please provide a file path using the -f or -F flag.");
            return;
        }

// Continue with the rest of the main logic...
        try {
            // 1. Read shapes from the file
            Shape3D[] shapes = ShapeFileReader.readShapesFromFile(filePath, comparisonType);
            if (shapes == null || shapes.length == 0) {
                System.out.println("Error reading shapes or no shapes found.");
                return;
            }

            // 2. Benchmark the chosen sorting algorithm on the shapes
            Shape3D[] shapesCopy = Arrays.copyOf(shapes, shapes.length);
            long startTime = System.currentTimeMillis();

            switch (sortingAlgorithm) {
                case 'b':
                    SortingUtility.bubbleSort(shapesCopy);
                    break;
                case 'i':
                    SortingUtility.insertionSort(shapesCopy);
                    break;
                case 's':
                    SortingUtility.selectionSort(shapesCopy);
                    break;
                case 'm':
                    SortingUtility.mergeSort(shapesCopy);
                    break;
                case 'q':
                    SortingUtility.quickSort(shapesCopy);
                    break;
                case 'z':
                    SortingUtility.shellSort(shapesCopy);
                    break;
                default:
                    System.out.println("Invalid sorting algorithm specified.");
                    return;
            }
            printSelectedValues(shapesCopy, comparisonType);;

            long endTime = System.currentTimeMillis();

            System.out.println("Time taken for " + sortingAlgorithmName(sortingAlgorithm) + ": " + (endTime - startTime) + " milliseconds");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // Utility function to get a descriptive name for the sorting algorithm
    private static String sortingAlgorithmName(char sortingAlgorithm) {
        switch (sortingAlgorithm) {
            case 'b':
                return "Bubble Sort";
            case 'i':
                return "Insertion Sort";
            case 's':
                return "Selection Sort";
            case 'm':
                return "Merge Sort";
            case 'q':
                return "Quick Sort";
            case 'z':
                return "Shell Sort";
            default:
                return "Quick Sort";
        }
    }

    /**
     * This method iterates over the sorted array and prints every thousandth
     * value. It ensures the first and last values are always printed regardless
     * of the size of the array.
     *
     * @param shapes
     */
    private static void printSelectedValues(Shape3D[] shapes, char comparisonType) {
        if (shapes.length == 0) {
            return;  // Nothing to print if the array is empty
        }

        System.out.println("First sorted value based on " + getComparisonName(comparisonType) + ": " + getValueBasedOnType(shapes[0], comparisonType));

        for (int i = 1000; i < shapes.length; i += 1000) {
            System.out.println("Sorted value at index " + i + " based on " + getComparisonName(comparisonType) + ": " + getValueBasedOnType(shapes[i], comparisonType));
        }

        System.out.println("Last sorted value based on " + getComparisonName(comparisonType) + ": " + getValueBasedOnType(shapes[shapes.length - 1], comparisonType));
    }

    private static String getComparisonName(char comparisonType) {
        switch (comparisonType) {
            case 'h':
                return "height";
            case 'v':
                return "volume";
            case 'a':
                return "base area";
            default:
                return "unknown";
        }
    }

    private static double getValueBasedOnType(Shape3D shape, char comparisonType) {
        switch (comparisonType) {
            case 'h':
                return shape.height;
            case 'v':
                return shape.getVolume();
            case 'a':
                return shape.getBaseArea();
            default:
                return -1; // This should not happen, given valid input.
        }
    }

}
