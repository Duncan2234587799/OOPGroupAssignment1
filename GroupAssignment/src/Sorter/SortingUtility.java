package  Sorter;
/**
 *
 * @author me
 */
public class SortingUtility {

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {

        boolean swapped;

        // Outer loop iterates through the entire array
        for (int i = 0; i < array.length - 1; i++) {
            // Flag to check if any swapping occurred in the inner loop
            swapped = false;

            // Inner loop handles the swapping process, running with decreasing length each time
            for (int j = 0; j < array.length - i - 1; j++) {
                // Compare adjacent elements and swap if necessary
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were swapped by inner loop, then array is sorted
            if (!swapped) {
                break;
            }
        }

    }

    /**
     * Sorts an array of Comparable objects using the Insertion Sort algorithm.
     *
     * @param <T> The type of elements in the array. Must extend Comparable<T>.
     * @param array The array of Comparable objects to be sorted.
     */
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        // Start from the second element (index 1).
        for (int i = 1; i < array.length; i++) {
            // Extract the element at the current index.
            T key = array[i];
            int j = i - 1;

            // Shift the element to the right to create the correct position for the key.
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            // Insert the key into its correct position.
            array[j + 1] = key;
        }
    }

    /**
     * Sorts an array of Comparable objects using the Selection Sort algorithm.
     *
     * @param <T> The type of elements in the array. Must extend Comparable<T>.
     * @param array The array of Comparable objects to be sorted.
     */
    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        // Iterate over each element in the array.
        for (int i = 0; i < array.length - 1; i++) {
            // Assume the current index has the minimum value.
            int min_idx = i;

            // Search for the smallest element's index starting from the current index + 1.
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[min_idx]) < 0) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the element at the current index.
            T temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }

    /**
     * Initiates the Merge Sort algorithm on an array of Comparable objects.
     *
     * @param <T> The type of elements in the array. Must extend Comparable<T>.
     * @param array The array of Comparable objects to be sorted.
     */
    public static <T extends Comparable<T>> void mergeSort(T[] array) {
        mergeSortHelper(array, 0, array.length - 1);
    }

    /**
     * Recursive helper function to divide the array and merge the halves.
     *
     * @param array The array to be sorted.
     * @param l Starting index.
     * @param r Ending index.
     */
    private static <T extends Comparable<T>> void mergeSortHelper(T[] array, int l, int r) {
        if (l < r) {
            // Calculate middle point of the array.
            int m = l + (r - l) / 2;

            // Recursively sort the first and second halves.
            mergeSortHelper(array, l, m);
            mergeSortHelper(array, m + 1, r);

            // Merge the sorted halves.
            merge(array, l, m, r);
        }
    }

    /**
     * Merges two sub arrays of the main array. First sub array is array[l..m],
     * second sub array is array[m+1..r]
     * 
     * @param array Main array.
     * @param l Starting index of the first sub array.
     * @param m Ending index of the first sub array.
     * @param r Ending index of the second sub array.
     */
    private static <T extends Comparable<T>> void merge(T[] array, int l, int m, int r) {
        // Calculate sizes of the two sub arrays.
        int n1 = m - l + 1;
        int n2 = r - m;

        // Temporary arrays.
        T[] L = (T[]) new Comparable[n1];
        T[] R = (T[]) new Comparable[n2];

        // Copy data to temp arrays L[] and R[].
        System.arraycopy(array, l, L, 0, n1);
        System.arraycopy(array, m + 1, R, 0, n2);

        // Merge the temp arrays back into the main array.
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
          }
    

        // Copy remaining elements of L[] (if any).
        while (i < n1) {
            array[k++] = L[i++];
        }

        // Copy remaining elements of R[] (if any).
        while (j < n2) {
            array[k++] = R[j++];
        }
      }
    

    /**
     * Initiates the Quick Sort algorithm on an array of Comparable objects.
     *
     * @param <T> The type of elements in the array. Must extend Comparable<T>.
     * @param array The array of Comparable objects to be sorted.
     */
    public static <T extends Comparable<T>> void quickSort(T[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    /**
     * Recursive helper function for the Quick Sort algorithm.
     *
     * @param array The array to be sorted.
     * @param low The starting index for this iteration.
     * @param high The ending index for this iteration.
     */
    private static <T extends Comparable<T>> void quickSortHelper(T[] array, int low, int high) {
        if (low < high) {
            // pi is the partitioning index.
            int pi = partition(array, low, high);

            // Recursively sort elements before and after partition.
            quickSortHelper(array, low, pi - 1);
            quickSortHelper(array, pi + 1, high);
        }
    }

    /**
     * Partition function for the Quick Sort algorithm. This function takes the
     * last element as pivot, places it at its correct position in the sorted
     * array, and places all smaller than pivot to its left and all greater
     * elements to its right.
     *
     * @param array The array to be partitioned.
     * @param low The starting index for this partition.
     * @param high The ending index for this partition.
     * @return The index of the pivot element.
     */
    private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high]; // Pivot is set to the last element.
        int i = (low - 1); // Index of the smaller element.
        for (int j = low; j < high; j++) {
            // If the current element is smaller than the pivot, swap it.
            if (array[j].compareTo(pivot) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap the pivot element with the element at position (i + 1).
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    /**
     * Implements the Shell Sort algorithm on an array of Comparable objects.
     * Shell Sort is a generalization of insertion sort that allows the exchange
     * of items that are far apart.
     *
     * @param <T> The type of elements in the array. Must extend Comparable<T>.
     * @param array The array of Comparable objects to be sorted.
     */
    public static <T extends Comparable<T>> void shellSort(T[] array) {
        int n = array.length;
        // Start with a big gap and reduce the gap.
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                T key = array[i];
                int j = i;
                while (j >= gap && array[j - gap].compareTo(key) > 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                // Put the key in its correct location.
                array[j] = key;
            }
        }
    }

}
