import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String []args){
        // TODO code for calculating the alg runtime (all 3 of them)
        // TODO feedback file and explain the actual result of 3 alg
        // phân tích được công thức tính độ phức tạp thời gian best case, worst case và average của từng thuật toán.

        Algorithm a = new Algorithm();
        Float[] f;
        int n = 0;
        Scanner sc = new Scanner(System.in);
        //create file
        String fileName ="INPUT.txt";
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

        if (file.exists() || file1.exists() || file2.exists() || file3.exists() || file4.exists() || file5.exists()){
            System.out.println("existed");
        } else {
            try {
                file.createNewFile();
                file1.createNewFile();
                file2.createNewFile();
                file3.createNewFile();
                file4.createNewFile();
                file5.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("file not found");
        }
        //zo
        int choice;
        
        do{
            System.out.print("Nhập số phần tử của mảng: ");
            n = sc.nextInt();
            a.initArr(n);
            f = new Float[n];
            for (int i = 0; i < n; i++) {
                System.out.printf("a[%d] = ", i);
                f[i] = sc.nextFloat();
            }
            // dem vao write file
            showMenu();
            choice = sc.nextInt();

            switch (choice){
                // TODO looping inf
                case 1:
                    a.writeFile(fileName, f);
                    break;
                case 2:
                    a.readFile(fileName, n);
                    break;
                case 3:
                    a.writeFile(fileName1, f);
                    System.out.println("Current array: ");
                    System.out.println("Sorted array: "+ "\n"  + Arrays.toString(a.bubbleSort(a.readFile(fileName1, n))));
                    break;
                case 4:
                    a.writeFile(fileName2, f);
                    System.out.println("Current array: ");
                    System.out.println("Sorted array: "+ "\n"  + Arrays.toString(a.selectionSort(a.readFile(fileName2, n))));
                    break;
                case 5:
                    a.writeFile(fileName3, f);
                    System.out.println("Current array: ");
                    System.out.println("Sorted array: "+ "\n"  + Arrays.toString(a.insertionSort(a.readFile(fileName3, n))));
                    break;
                // TODO > value not = value
                case 6:
                    System.out.println("linear");
                    a.writeFile(fileName4, f);
                    System.out.println("Search value: ");
                    Float value = sc.nextFloat();//
                    a.linearSearch(f, value);
                    break;
                // TODO not correct in case there are many elements equal value
                case 7:
                    a.writeFile(fileName5, f);
                    System.out.println("Search value: ");
                    Float value1 = sc.nextFloat();
                    int result = a.binarySearch(f, 0, f.length - 1, value1);
                    if (result == -1)
                        System.out.println("Không thấy");
                    else
                        System.out.println("Value's index: ["
                                + result +"]");
                    break;
            }
        }while(choice < 9);
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
        System.out.println("8. exit");
        System.out.println("your choice: ? (1-7)");
    }
}
