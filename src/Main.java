import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Algorithm a = new Algorithm();
        Float[] f = null;

        Scanner sc = new Scanner(System.in);
        // create file
        String fileName = "INPUT.txt";
        String fileName1 = "OUTPUT1.txt";
        String fileName2 = "OUTPUT2.txt";
        String fileName3 = "OUTPUT3.txt";
        String fileName4 = "OUTPUT4.txt";
        String fileName5 = "OUTPUT5.txt";
        File file = new File(fileName);
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        File file3 = new File(fileName3);
        File file4 = new File(fileName4);
        File file5 = new File(fileName5);


        try {
            if (!file.exists()) file.createNewFile();
            if (!file1.exists()) file1.createNewFile();
            if (!file2.exists()) file2.createNewFile();
            if (!file3.exists()) file3.createNewFile();
            if (!file4.exists()) file4.createNewFile();
            if (!file5.exists()) file5.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int choice;

        do {
            showMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    f = init();
                    a.writeFile(fileName, f);
                    break;
                case 2:
                    a.readFile(fileName, f);
                    break;
                case 3:
                    System.out.println("Current array: ");
                    System.out
                            .println("Sorted array: " + "\n" + Arrays.toString(a.bubbleSort(a.readFile(fileName, f))));
                    a.writeFile(fileName1, f);
                    break;
                case 4:
                    System.out.println("Current array: ");
                    System.out.println(
                            "Sorted array: " + "\n" + Arrays.toString(a.selectionSort(a.readFile(fileName, f))));
                    a.writeFile(fileName2, f);
                    break;
                case 5:
                    System.out.println("Current array: ");
                    System.out.println(
                            "Sorted array: " + "\n" + Arrays.toString(a.insertionSort(a.readFile(fileName, f))));
                    a.writeFile(fileName3, f);
                    break;
                case 6:
                    System.out.println("Linear Search value: ");
                    Float value = sc.nextFloat();//
                    int[] indices = a.linearSearch(f, value);
                    a.writeFile(fileName4, null, indices);
                    break;
                case 7:
                    System.out.println("Search value: ");
                    Float value1 = sc.nextFloat();
                    int result;
                    System.out.println(Arrays.toString(f));
                    System.out.println("Sorting... ");
                    Float[] f1 = a.insertionSort(f);
                    System.out.println(Arrays.toString(f1));
                    result = a.binarySearch(f1, 0, f.length - 1, value1);
                    if (result == -1) {
                        System.out.println("No result found");
                    } else {
                        a.writeFile(fileName5, result, null);
                        System.out.println("Value's index found: [" + result + "]");
                    }
                    break;
                case 8:
                    a.calculateRuntimes();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);
        sc.close();
    }

    private static void showMenu() {
        System.out.println("What do you want to do? ");
        System.out.println("1. write");
        System.out.println("2. read");
        System.out.println("3. bubbleSort");
        System.out.println("4. selectionSort");
        System.out.println("5. insertionSort");
        System.out.println("6. linearSearch");
        System.out.println("7. binarySearch");
        System.out.println("8. Runtime check");
        System.out.println("0. Exit");
        System.out.println("your choice: ");
    }

    private static Float[] init() {
        Float[] f;
        int n;
        System.out.print("Input number of elements: ");
        n = sc.nextInt();
        f = new Float[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            f[i] = sc.nextFloat();
        }
        return f;
    }
}
