import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class RandomizedQuickSortB {
	
	public static int partition(float arr[], int left, int right)
	{
	      int i = left, j = right;
	      float tmp;
	      Random rnd = new Random();
	      float pivot = arr[left + rnd.nextInt(right - left)];

	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };

	      return i;
	}

	public static void quickSort(float arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}
	public static void main(String[] args) throws IOException {
	
		File file = new File("Input\\Test.txt");
	
	    int i;
	    Scanner sc = new Scanner(file);
	    int k= (int) sc.nextFloat();
	    int n= (int) sc.nextFloat();
	    float array[] = new float[n];
	    for (i = 0; i < n; i++)
	    {
	    		array[i] = sc.nextFloat();    
	    }
	    sc.close();
	      
	    PrintStream out = new PrintStream(new FileOutputStream("RandomizedQuickSortBOutput.txt"));
	    System.setOut(out);
	    
	    System.out.println("Quick Sort Using Random number as pivot!!\n");
	    System.out.println("K = " + k + " n = "+ n);    
	    /* Elements before sorting */
		System.out.println();
	    System.out.println("\nElements before sorting ");        
	    for (i = 0; i < n; i++)
	    {
	        System.out.print(array[i]+" ");  
	        System.out.println();
	    }
	        System.out.println();
	    long startTime = System.nanoTime();
	    /* Call method sort */
	      	quickSort(array,0,array.length-1);
	      	
	        long endTime   = System.nanoTime();
	        double totalTime = endTime - startTime;
	        System.out.println();
	        /* Print sorted Array */
	        System.out.println("\nElements after sorting ");        
	        for (i = 0; i < n; i++)
	        {
	            System.out.print(array[i]+" ");
	            System.out.println();
	        }
	            System.out.println();
	        System.out.println();
	        	System.out.println("\nThe "+k+"th smallest element is "+array[k-1]);
	        	System.out.println();
	        	System.out.println("\nThe top "+k+" elements are:");
	        	for(i = n-1; i > n-k-1; i--)
	        	{
	        		System.out.print(array[i]+" ");
	        		System.out.println();
	        	}
	        	System.out.println();
	        	System.out.println();
	        	System.out.println("\nTime taken to run program:" +totalTime + " ns");
		}
}