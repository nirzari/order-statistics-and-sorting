import java.util.Scanner;
import java.io.*;

public class ClassicalQuickSortA {

public static void quickSort(float array[]) 
{
	quickSort(array, 0, array.length - 1);              // quicksort all the elements in the array
}


public static void quickSort(float array[], int start, int end)
{
     int i = start;                          // index of left-to-right scan
     int k = end;                            // index of right-to-left scan

     if (end - start >= 1)                   // check that there are at least two elements to sort
     {
             float pivot = array[start];       // set the pivot as the first element in the partition

             while (k > i)                   // while the scan indices from left and right have not met,
             {
                     while (array[i] <= pivot && i <= end && k > i)  // from the left, look for the first
                             i++;                                    // element greater than the pivot
                     while (array[k] > pivot && k >= start && k >= i) // from the right, look for the first
                         k--;                                        // element not greater than the pivot
                     if (k > i)                                       // if the left seekindex is still smaller than
                             swap(array, i, k);                      // the right index, swap the corresponding elements
             }
             swap(array, start, k);          // after the indices have crossed, swap the last element in
                                             // the left partition with the pivot 
             quickSort(array, start, k - 1); // quicksort the left partition
             quickSort(array, k + 1, end);   // quicksort the right partition
     }
     else    // if there is only one element in the partition, do not do any sorting
     {
             return;                     // the array is sorted, so exit
     }
}

public static void swap(float array[], int index1, int index2) 
//pre: array is full and index1, index2 < array.length
//post: the values at indices 1 and 2 have been swapped
{
	float temp = array[index1];           // store the first value in a temp
	array[index1] = array[index2];      // copy the value of the second into the first
	array[index2] = temp;               // copy the value of the temp into the second
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
    
    PrintStream out = new PrintStream(new FileOutputStream("ClassicalQuickSortAOutput.txt"));
    System.setOut(out);
    
    System.out.println("Quick Sort using first element as pivot !");
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