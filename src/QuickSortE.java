import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;


public class QuickSortE {
	
	public static int partition(float arr[], int left, int right)
	{
	      int i = left, j = right;
	      float tmp;
	      float pivot=0; 
		
		// 3 elements are selected randomly
		Random rnd = new Random();
		float p1 = arr[left + rnd.nextInt(right - left)];
		float p2 = arr[left + rnd.nextInt(right - left)];
		float p3 = arr[left + rnd.nextInt(right - left)];
		
		
		// median of 3 is fount and placed as pivot element
		if ((p1<=p2 && p1>=p3) || (p1>=p2 && p1<=p3) )
		pivot= p1;
		
		else if ((p2<=p1 && p2>=p3) || (p2>=p1 && p2<=p3) )
		pivot=  p2;
		
		else if ((p3<=p2 && p3>=p1) || (p3>=p2 && p3<=p1) )
		pivot =  p3;

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
	
	public static void quickSort(float[] arr, int left, int right) {
	    int size = right - left + 1;
	    if (size < 10)
	      insertionSort(arr, left, right);
	    else {
	    	int index = partition(arr, left, right);
		    if (left < index - 1)
		            quickSort(arr, left, index - 1);
		    if (index < right)
		            quickSort(arr, index, right);
	    }
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
	    PrintStream out = new PrintStream(new FileOutputStream("QuickSortEOutput.txt"));
	    System.setOut(out);
	    System.out.println("Quick Sort E\n");
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
