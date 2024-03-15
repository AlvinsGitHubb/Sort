/*
 * Created by: Alvin Mathew
 * This project is used to track the number of comparisons, movements, and total time for each of the 6 sorting algorithms within this program.
 * This program tracks heap sort, insertio nsort, merge sort, quick sort, radix sort, selection sort. 
 * I did this by adding several counters to each of the sorting algorithms to track the movements and comparisons.
 * The time was calculated by using the nanotime feature on Java.
 */

import java.util.*;

public class App {

    static void reverseArray(int intArray[], int size) {
        int i, temp;
        for (i = 0; i < size / 2; i++) {
            temp = intArray[i];
            intArray[i] = intArray[size - i - 1]; // swap
            intArray[size - i - 1] = temp; // swap
        }

    }

    // randomize 80% of the array
    public static void shuffleArray(int[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n * .8; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    // randomize 20%
    public static void shuffleArray20(int[] a) {
        int n = a.length;
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n * .2; i++) {
            int change = i + random.nextInt(n - i);
            swap(a, i, change);
        }
    }

    private static void swap(int[] a, int i, int change) {
        int helper = a[i];
        a[i] = a[change];
        a[change] = helper;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        RadixSort rs = new RadixSort(); // radix sort object

        // ask user for array size, list property, sorting method
        System.out.println("Select an array size:\n1. 5000\n2. 15000\n3. 50000");
        int arrayChoice = sc.nextInt(); // user input
        System.out.println("Select a list property:\n1. InOrder\n2. ReverseOrder\n3. AlmostOrder\n4. RandomOrder");
        int listChoice = sc.nextInt(); // user input
        System.out.println(
                "Select a sorting algoritm:\n1. Insertion Sort\n2. Selection Sort\n3. Quick Sort\n4. Merge Sort\n5. Heap Sort\n6. Radix Sort");
        int algoChoice = sc.nextInt(); // user input

        // arraysize switch case
        // creates all arrays in order from 1 to size
        int[] arr = new int[0];
        switch (arrayChoice) {
            case 1:
                arr = new int[5000];
                Arrays.setAll(arr, i -> i + 1);
                break;
            case 2:
                arr = new int[15000];
                Arrays.setAll(arr, i -> i + 1);
                break;
            case 3:
                arr = new int[50000];
                Arrays.setAll(arr, i -> i + 1);
                break;
        }
        // list prop switch
        // how to know which array to use
        switch (listChoice) {
            case 1: // already in order
                break;
            case 2:
                reverseArray(arr, arr.length);
                break;
            case 3: // randomize the order of 20% of the array
                shuffleArray20(arr);
                break;
            case 4: // randomize the order of 80% of the array
                shuffleArray(arr);
                break;
        }
        // algorithm switch
        // time is tracked here
        // comparisons and movements are tracked within the respective sorting java
        // files
        switch (algoChoice) {
            case 1:
                long start1 = System.nanoTime();
                InsertionSort.insertionSort(arr);
                long finish1 = System.nanoTime();
                long timeElapsed1 = finish1 - start1;
                System.out.println("Total time: " + timeElapsed1);
                break;
            case 2:
                long start2 = System.nanoTime();
                SelectionSort.selectionSort(arr);
                long finish2 = System.nanoTime();
                long timeElapsed2 = finish2 - start2;
                System.out.println("Total time: " + timeElapsed2);
                break;
            case 3:
                long start3 = System.nanoTime();
                QuickSort.quickSort(arr);
                long finish3 = System.nanoTime();
                long timeElapsed3 = finish3 - start3;
                System.out.println("Total time: " + timeElapsed3);
                break;
            case 4:
                long start4 = System.nanoTime();
                MergeSort.mergeSort(arr);
                long finish4 = System.nanoTime();
                long timeElapsed4 = finish4 - start4;
                MergeSort.print(); // needed a seperate method to be able to print the comparisons, movements, and
                                   // time because merge sort is recursive
                System.out.println("Total time: " + timeElapsed4);
                break;
            case 5:
                Integer[] arrayInt = Arrays.stream(arr).boxed().toArray(Integer[]::new); // convert int[] to Integer[]
                long start5 = System.nanoTime();
                HeapSort.heapSort(arrayInt);
                long finish5 = System.nanoTime();
                long timeElapsed5 = finish5 - start5;
                System.out.println("Total time: " + timeElapsed5);
                break;
            case 6:
                long start6 = System.nanoTime();
                rs.radixsort(arr, arr.length);
                long finish6 = System.nanoTime();
                long timeElapsed6 = finish6 - start6;
                System.out.println("Total time: " + timeElapsed6);
                break;
        }

    }
}
