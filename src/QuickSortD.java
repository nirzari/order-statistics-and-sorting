import java.util.Scanner;
import java.io.*;

public class QuickSortD {
	

	  public static void quickSort(float[] arr) {
	    recQuickSort(arr, 0, arr.length - 1);
	    insertionSort(arr, 0, arr.length - 1);
	  }

	  public static void recQuickSort(float[] arr, int left, int right) {
	    int size = right - left + 1;
	    if (size < 10)
	      insertionSort(arr, left, right);
	    else {
	      double median = medianOf3(arr, left, right);
	      int partition = partitionIt(arr, left, right, median);
	      recQuickSort(arr, left, partition - 1);
	      recQuickSort(arr, partition + 1, right);
	    }
	  }

	  public static double medianOf3(float[] arr, int left, int right) {
	    int center = (left + right) / 2;

	    if (arr[left] > arr[center])
	      swap(arr, left, center);

	    if (arr[left] > arr[right])
	      swap(arr, left, right);

	    if (arr[center] > arr[right])
	      swap(arr, center, right);

	    swap(arr, center, right - 1);
	    return arr[right - 1];
	  }

	  public static void swap(float[] arr, int dex1, int dex2) {
	    float temp = arr[dex1];
	    arr[dex1] = arr[dex2];
	    arr[dex2] = temp;
	  }

	  public static int partitionIt(float[] arr, int left, int right, double pivot) {
	    int leftPtr = left;
	    int rightPtr = right - 1;
	    while (true) {
	      while (arr[++leftPtr] < pivot)
	        ;
	      while (arr[--rightPtr] > pivot)
	        ;
	      if (leftPtr >= rightPtr)
	        break;
	      else
	        swap(arr, leftPtr, rightPtr);
	    }
	    swap(arr, leftPtr, right - 1);
	    return leftPtr;
	  }

	  public static void insertionSort(float[] arr, int left, int right) {
	    int in, out;

	    for (out = left + 1; out <= right; out++) {
	      float temp = arr[out];
	      in = out;
	      while (in > left && arr[in - 1] >= temp) {
	    	  arr[in] = arr[in - 1];
	        --in;
	      }
	      arr[in] = temp;
	    }
	  }
	  public static void main(String[] args) throws IOException {
		 
			File file = new File("Input\\Test.txt");
	        int i;
	        Scanner sc = new Scanner(file);
	        int k= (int) sc.nextFloat();
	        int n= (int) sc.nextFloat();
	        float arr[] = new float[n];
	        for (i = 0; i < n; i++)
	        {
	        	arr[i] = sc.nextFloat();    
	        }
	        sc.close();
	        PrintStream out = new PrintStream(new FileOutputStream("QuickSortDOutput.txt"));
	        System.setOut(out);
	        System.out.println("Quick Sort using insertion sort !");
	    	System.out.println("K = " + k + " n = "+ n);    
	        /* Elements before sorting */
	    	System.out.println();
	        System.out.println("\nElements before sorting ");        
	        for (i = 0; i < n; i++)
	        {
	            System.out.print(arr[i]+" ");
	            System.out.println();
	        }
	            System.out.println();
	        long startTime = System.nanoTime();
	        /* Call method sort */
		    quickSort(arr);
		    long endTime   = System.nanoTime();
		    double totalTime = endTime - startTime;
		    System.out.println();
		    /* Print sorted Array */
		    System.out.println("\nElements after sorting ");        
		    for (i = 0; i < n; i++)
		    {
		        System.out.print(arr[i]+" ");
		        System.out.println();
		    }
		        System.out.println();
		    System.out.println();
		    	System.out.println("\nThe "+k+"th smallest element is "+arr[k-1]);
		    	System.out.println();
		    	System.out.println("\nThe top "+k+" elements are:");
		    	for(i = n-1; i > n-k-1; i--)
		    	{
		    		System.out.print(arr[i]+" ");
		    		System.out.println();
		    	}
		    	System.out.println();
		    	System.out.println();
		    	System.out.println("\nTime taken to run program:" +totalTime + " ns");
	     
		  }
}
