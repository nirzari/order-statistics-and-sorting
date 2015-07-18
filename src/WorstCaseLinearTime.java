import java.io.*;
import java.util.*;


public class WorstCaseLinearTime {
	
	public static int Median_Find(float[] arr,int k , int low, int high)
	  { int index = ((high+low)/2);
	      int med = med(arr,index,low,high);
	      //System.out.println("Median of the array is " + med);
	    		return med;
	  }
	  
	  private static int med(float arr[],int k,int low,int high)
	  {    
		  //System.out.println("med arr len"+arr.length+"--"+high+"--"+low);
	      if(low == high)
	      {
	          return low;
	      }
	      
	      // sort the mth largest element in the given array
	      int m = make_partition(arr,low,high);
	      //System.out.println("partition point " + m);
	      int length = m - low + 1;
	      
	      // If mth element is the median, return it
	      if(length == k)
	      {
	          return m;
	      }
	      
	      // If mth element is greater than median, search in the left subarray
	      if(length > k)
	      {
	          return med(arr,k,low,m-1);
	      }
	      // otherwise search in the right subArray
	      else
	      {
	          return med(arr,k-length,m,high);
	      }
	      
	  }
	  
	  private static int make_partition(float arr[],int low, int high)
	  {
		 // System.out.println("make partition arr len"+arr.length+"--"+high+"--"+low);
	      // Get pivotvalue by finding median of medians
	      float pivot = get_pivot(arr, low, high);        
	      
	      // Find the sorted position for pivotVale and return it's index
	      while(low < high)
	      {
	          while(arr[low] < pivot)
	          {
	              low ++;
	          }
	          
	          while(arr[high] > pivot)
	          {
	              high--;
	          }
	          
	          if(arr[low] == arr[high])
	          {
	              low ++;
	          }
	          else if(low < high)
	          {
	              float temp = arr[low];
	              arr[low] = arr[high];
	              arr[high] = temp;
	          }
	              
	      }
	      return high;
	  }
	  
	  
	  private static float get_pivot( float arr[],int low,int high)
	  {
	      // If number of elements in the array are small, return the actual median
		  //System.out.println("get pivot arr len"+arr.length+"--"+high+"--"+low);
	      if(high-low+1 <= 9)
	      {
	          Arrays.sort(arr);
	          return arr[arr.length/2];
	      }
	      
	      //Otherwise divide the array into subarray of 5 elements each, and recursively find the median
	      
	      // Array to hold '5 element' subArray, last subArray may have less than 5 elements
	      int temp[] = null;
	      
	      // Array to hold the medians of all '5-element SubArrays'
	      float[] med = new float[(int)Math.ceil((double)(high-low+1)/5)];
	      int value = 0;
	      
	      while(low < high)
	      {
	          // get size of the next element, it can be less than 5
	          temp = new int[Math.min(5,high-low+1)];
	          
	          for(int j=0;j<temp.length && low < high;j++)
	          {
	              temp[j] = (int) arr[low];
	              low++;
	          }
	          
	          // sort subArray
	          Arrays.sort(temp);
	          
	          // find mean and store it in median Array
	          med[value] = temp[temp.length/2];
	          value++;
	      }
	      
	      // Call recursively to find median of medians
	      return get_pivot(med,0,med.length);
	  }
	    public static void Quickselect(float[]a,int i,int j,int k)
	    {
	    int left = i;
		int right = j;
		
		if (i >= j) 
		{	
			return;
		}
		
		int pivot = Median_Find(a, k ,i ,j);
		float temp = a[pivot];
		a[pivot] = a [left];
		a[left] = temp;
		pivot = left;
		
		while (left < right) {
			
			while (left<right && a[left] <= a[pivot]) 
			{	
				left++;
			}
			
			while (a[right] > a[pivot]) 
			{
				right--;
			}
			
		
		if (left < right) 
		{
			float T = a[right];
			a[right] = a[left];
			a[left] = T;
		}
	}
		if (right <= left)
		{ 
		float t1 = a[pivot];
		a[pivot] = a[right];
		a[right] = t1;
		int t2 = right;
		right = pivot;
		pivot = t2;
		}
		if( pivot == k-1)
			System.out.println("Kth element is \n"+ a[pivot]);	
		
		if(pivot<k-1)
			Quickselect(a, pivot+1, j,k);
		else if(pivot>k-1)
			Quickselect(a,i,pivot-1,k);
		
	}

  public static void main(String[] args) throws IOException {
	  @SuppressWarnings("resource")
	  Scanner fileScanner = new Scanner(new File("Input\\Test.txt"));
      int k= (int) fileScanner.nextFloat();
      int n= (int) fileScanner.nextFloat();
 
      float a[]= new float[n];
      int i=0;
      
      while (fileScanner.hasNextFloat())
      {
         a[i]=fileScanner.nextFloat();
         i++; 
      }
      PrintStream out = new PrintStream(new FileOutputStream("WorstCaseLinearTime.txt"));
      System.setOut(out);
      Arrays.sort(a);
      long startTime = System.nanoTime();
 
	  Quickselect(a, 0, n-1,k);
		
	  long endTime   = System.nanoTime();
	  double totalTime = endTime - startTime;
	  System.out.println();
  	  System.out.println("\nTime taken to run program:" +totalTime + " ns");
  
}
}
