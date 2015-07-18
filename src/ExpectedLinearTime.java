import java.io.*;
import java.util.*;


public class ExpectedLinearTime {

	public static void Quickselect(float[]arr,int i,int j,int k)
	{
		int left = i;
		int right = j;
		if (left >= right) {
			
			return;
		}
		Random rnd = new Random(); // Select an array element randomly
		int pivot = rnd.nextInt((j-i)+1)+i;
		float temp = arr[(int) pivot];
		arr[pivot] = arr [left];
		arr[left] = temp;
		pivot = left;
		
		// the place of that element is determined
		
		while (left < right)
		{
			// finding all elements less than pivot
			while (left<=right && arr[left] <= arr[pivot]) {
				left++;
			}
			
			// finding elements greater than pivot
			while (arr[right] > arr[pivot]) 
			{	
				right--;
			}
			
		// if high and low havent crossed swap them and continue
		if (left < right) 
		{
			float T = arr[right];
			arr[right] = arr[left];
			arr[left] = T;
		}
	}
		// once high and low have crossed swap pivot with high 
		if (right <= left)
		{ 
			float t1 = arr[pivot];
			arr[pivot] = arr[right];
			arr[right] = t1;
			int t2 = right;
			right = pivot;
			pivot = t2;
		}
		
		// if k = pivot return pivot 
		if( pivot == k-1)
			System.out.println("Kth element is \n"+ arr[pivot]);	
		
		//if k is less than pivot continue for left half
		if(pivot<k-1)
			Quickselect(arr, pivot+1, j,k);
		
		//else continue for right half
		else if(pivot>k-1)
			Quickselect(arr,i,pivot-1,k);
		
	}
	
	public static void main(String args[]) throws FileNotFoundException 
	{
		Scanner sc = new Scanner(new File("Input\\Test.txt"));
		int k= (int) sc.nextFloat();
	    int n= (int) sc.nextFloat();
	    
	    float arr[]= new float[n];
	    int i=0;
	    while (sc.hasNextFloat())
	    {
	       arr[i]=sc.nextFloat();
	       i++;
	    }
	    sc.close();
	    PrintStream out = new PrintStream(new FileOutputStream("ExpectedLinearTimeOutput.txt"));
	    System.setOut(out);
	    long startTime = System.nanoTime();
		Quickselect(arr, 0, n-1,k);
		long endTime   = System.nanoTime();
		double totalTime = endTime - startTime;
		System.out.println();
	  	System.out.println("\nTime taken to run program:" +totalTime + " ns");
	
	
	
		}
}
