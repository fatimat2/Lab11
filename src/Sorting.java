import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 * Class implementing sorting algorithms.
 *
 */

public class Sorting {
  

  /**
   * Bubble sorting algorithm that runs in O(n^2)
   *
   * @param arr unsorted input array
   * @param n size of the input
   */
  static void bubbleSort(int[] arr, int n) {
    /* IMPLEMENT BUBBLE SORT HERE */
  }

  /**
   * Merge function that merges two sorted arrays into a single sorted array
   * 
   * <p>Implement an in place merge algorithm that repeatedly picks the smaller of two numbers from 
   * "right" and "left" subarray and copies it to the "arr" array to produce a bigger sorted array
   *
   * @param arr array contains sorted subarrays, should contain the resulting merged sorted array
   * @param l start position of sorted left subarray
   * @param m ending position of sorted left and start position of sorted right subarray
   * @param r ending position of sorted right subarray
   */
  static void merge(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int[] left = new int[n1];
    int[] right = new int[n2];
    
    for (int i = 0; i < n1; ++i) {
      left[i] = arr[l + i];
    }
    for (int j = 0; j < n2; ++j) {
      right[j] = arr[m + 1 + j];
    }
    
    /* TO DO: Merge left and right array here */
  }
 
  /**
   * Merge sorting algorithm that runs in O(n log n)
   *
   * @param arr array that needs to be sorted
   * @param l start position of unsorted array
   * @param r ending position of unsorted subarray
   */
  static void mergeSort(int[] arr, int l, int r) {
    if (l < r) {
      /* TO DO: Make the recursive calls for mergeSort and merge here */
    }
  }
  
  /**
   * Selective sorting algorithm that runs in O(n^2)
   *
   * @param arr unsorted input array
   * @param n size of the input
   */
  static void selectionSort(int[] arr, int n) {
    /* TO DO: Implement selection sort here */
  }
  
  /**
   * Main method for testing.
   * 
   * <p>This method reads numbers from input file of type specified by user, runs different
   * sorting algorithms on different sizes of the input and plots the time taken by each.
   *
   * @param args unused input arguments
   */
  public static void main(String[] args) throws FileNotFoundException {
    Scanner user = new Scanner(System.in);
    File inFile;
    
    // Get input according to the type specified by the user
    System.out.println("Enter the type of data to sort "
        + "(1 for sorted, 2 for almost sorted, 3 for reverse sorted): ");
    int datatype = user.nextInt();
    switch (datatype) {
      case 1:
        inFile = new File("sorted.txt");
        break;
      case 2:
        inFile = new File("almostsorted.txt");
        break;
      case 3:
        inFile = new File("reverse.txt");
        break;
      default:
        inFile = new File("reverse.txt");
        break;
    }
    Scanner data = new Scanner(inFile, "UTF-8");
    int totaln = 1000000;
    int[] allnumbers = new int[totaln];
    for (int i = 0; i < totaln; i++) {
      allnumbers[i] = data.nextInt();
    }
    
    int[] timeValues = new int[100];
    
    System.out.println("Enter the sorting algorithm that you want to use"
        + " (1 for bubble sort, 2 for insertion sort, 3 for merge sort): ");
    int alg = user.nextInt();
    for (int i = 1; i <= 100; i++) {        
      // Create a new array of 10000, 20000, 30000... integers to sort
      int[] sortingarray = new int[i * 10000];
      for (int j = 0; j < (i * 10000); j++) {
        sortingarray[j] = allnumbers[j];
      }
      
      // Sort the array using algorithm specified by user
      long startTime = System.currentTimeMillis();
      switch (alg) {
        case 1:
          bubbleSort(sortingarray, (i * 10000));
          break;
        case 2:
          selectionSort(sortingarray, (i * 10000));
          break;
        default:
          mergeSort(sortingarray, 0, (i * 10000) - 1);
          break;
      }
      long endTime = System.currentTimeMillis();
      
      // Append the time taken to sort to the timeValues array
      timeValues[i - 1] = (int)(endTime - startTime);               
    }
    data.close();
    user.close();
    
    
    // Plot a graph corresponding to the values in the timeValues array
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(new Plot(timeValues));
    f.setSize(400,400);
    f.setLocation(200,200);
    f.setVisible(true);
  }

}
