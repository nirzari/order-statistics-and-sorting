import java.util.Scanner;
import java.io.*;
/* Class HeapSort */
public class HeapSort 
{    
    private static int N;
    /* Sort Function */
    public static void sort(float arr[])
    {       
        heapify(arr);        
        for (int i = N; i > 0; i--)
        {
            swap(arr,0, i);
            N = N-1;
            maxheap(arr, 0);
        }
    }     
    /* Function to build a heap */   
    public static void heapify(float arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);        
    }
    /* Function to swap largest element in heap */        
    public static void maxheap(float arr[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }    
    /* Function to swap two numbers in an array */
    public static void swap(float arr[], int i, int j)
    {
        float tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }    
    /* Main method */
    public static void main(String[] args) throws IOException
    {
        
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
        
        PrintStream out = new PrintStream(new FileOutputStream("HeapSortOutput.txt"));
        System.setOut(out);
        
        System.out.println("Heap Sort !");
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
        sort(arr);
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