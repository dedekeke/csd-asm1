import java.io.*;
import java.util.Arrays;

public class Algorithm {

    /**
     * Writing the array read from input array arr to file
     *
     * @param fileName The file name of file to write value
     * @param arr      The input float array
     */
    public void writeFile(String fileName, Float[] arr) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(fileName));
            for (Float aFloat : arr) {
                out.write(aFloat + " ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void writeFile(String fileName, Integer index, int[] indices) {
        Writer writer = null;
        try {
            writer = new FileWriter(fileName);
            if (index != null) writer.write(index + "");
            if (indices != null) {
                for (int j : indices) {
                    writer.write(j + " ");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Reading the file then input to the array arr
     *
     * @param fileName The file name of file to read
     * @return Returning an array read from the file
     */
    public Float[] readFile(String fileName, Float[] f) {
        FileReader reader = null;
        try {
            reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] nums = line.trim().split("\\s+");
                for (int i = 0; i < f.length; i++) {
                    f[i] = Float.parseFloat(nums[i]);
                }
                break;
            }
            System.out.println(Arrays.toString(f));
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return f;
    }

    /**
     * Sorting the input array arr using Bubble Sort algorithm.
     *
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Bubble Sort algorithm
     */
    public Float[] bubbleSort(Float[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) { // n times
            for (int j = 0; j < n - i - 1; j++) { // n-1 times=> time-complexioty = 0(n*(n-1)) =O(n²)
                if (arr[j + 1] < arr[j]) {
                    Float swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
        // compares and swaps repeatedly. Space-complexity: O(1)
        // => worst case reversed sorted. Time-Complexity O(n²).
        // => best case: sorted case. t-Complexity O(n). n-1 comparisons
        // => avg case: O(n²)
        return arr;
    }

    /**
     * Sorting the input array arr using Selection Sort algorithm.
     *
     * @param arr Input array using for sorting
     * @return Returning a sorted array by using the Selection Sort algorithm
     */
    public Float[] selectionSort(Float[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // selects smallest number
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            // places to the first place repeatedly
            Float temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;

        // best case: t-complexity: O(n²). sorted array 0(1) swap. n(n-1)/2 comparisons.
        // worst case : t-complexity: O(n²). reversed array (inner loop swaps for n-1
        // times). n(n-1)/2 comparisons
        // avg case t-c: O(n²)
        // time-complextiy : number of times outer loop * number of times inner loop
    }

    /**
     * Sorting the input array arr using Insertion Sort algorithm.
     *
     * @param arr Input array using for searching
     * @return Returning a sorted array by using the Insertion Sort algorithm
     */

    public Float[] insertionSort(Float[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Float key = arr[i];
            int j = i - 1;
            //
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // move to right
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
        // insert elements to proper places
        // best case: sorted array.n-1 comparisons and 0 swap.
        // worst case: reversed when inner loops for maximum times.n²/2 comparisions and
        // n²/2 swaps
        // avg case: n²/4 comparisions and n²/4 swaps
    }

    /**
     * Searching the indices of elements in array [arr] greater than value. Printing
     * and writing all indices to the console screen and file OUTPUT4.TXT separated
     * by space.
     *
     * @param arr   Input array using for searching
     * @param value The value for searching
     */

    public int[] linearSearch(Float[] arr, Float value) {
        int count = 0;
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(value)) {
                System.out.println("Element found at index " + i + ": " + arr[i]);
                result[count++] = i;
            }
        }

        if (count == 0) {
            System.out.println("No element found");
            return null;
        }
        // Trim the result array to the actual size
        return Arrays.copyOf(result, count);
    }

    /**
     * Searching by using the Binary Search algorithm. Returning the first index of
     * value if it is present in array arr, otherwise, return -1. The index also
     * written to file OUTPUT5.TXT and shown on the console screen.
     *
     * @param arr   Input array using for searching
     * @param left  The left index
     * @param right The right index
     * @param value The value for searching
     * @return The index of the element if found, otherwise, return -1
     */

    public int binarySearch(Float[] arr, int left, int right, Float value) {
        if (arr == null) {
            return -1;
        }
        while (right >= left) {
            int mid = (right + left) / 2;

            if (arr[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (arr[mid].equals(value)) {
                // check for the first occurrence of the value
                while (mid > 0 && arr[mid - 1].equals(value)) {
                    mid--;
                }
                return mid;
            }
        }
        return -1;
    }

    public void calculateRuntimes() {
        Float[] arr = new Float[1000];
        // uncomment these lines for randomly shuffled data
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = (float) (Math.random() * 1000);
        // }

        // uncomment these lines for sorted data
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = (float) (i);
        // }

        // uncomment these lines for reverse sorted data
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr.length - i - 1);
        }

        measureAndPrintRuntime(this::bubbleSort, "Bubble Sort", arr.clone());
        measureAndPrintRuntime(this::selectionSort, "Selection Sort", arr.clone());
        measureAndPrintRuntime(this::insertionSort, "Insertion Sort", arr.clone());
    }

    private void measureAndPrintRuntime(SortingAlgorithm sortingAlgorithm, String algorithmName, Float[] array) {
        long startTime = System.currentTimeMillis();
        sortingAlgorithm.sort(array);
        long endTime = System.currentTimeMillis();
        long runtime = endTime - startTime;

        System.out.println(algorithmName + " Runtime: " + runtime + " milliseconds");
    }

}