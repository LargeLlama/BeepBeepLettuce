package calculate;

public class Sorts{
    
    //Sorts implements quickSort algorithm
    //  recursively partioning array
    //  into values less than and greater than pivot point

    //helper method
    public static int part( double[] arr, int left, int right){
	//uses last element as pivot value
	//  and then places arr values
	//  to the right of pivot val
	//  if <= said val

	//tracks index of smallest val
        int i = (left-1);
	//pivot val
	double pivot = arr[right];
	
	for (int x = left; x < right; x++){
	    //if <=
	    if (arr[x] <= pivot){
		i++;
		//swap arr[i] and arr[x]
		double temp = arr[x];
		arr[x] = arr[i];
		arr[i] = temp;
	    }
	}
 
	//swap arr[i+1] and pivot
	double temp = arr[i+1];
	arr[i+1] = arr[right];
	arr[right] = temp;
 
        return i+1;
    }

    //helper method that specifies
    //  leftmost and rightmost points of operation
    public static void helperSort( double[] arr, int left, int right ){
	if(left < right){
	    //partition arr
	    int partition = part(arr, left, right);

	    //recursively sort both sides of partition
	    helperSort(arr, left, partition - 1);
            helperSort(arr, partition + 1, right);
	}
    }


    public static void sort(double[] arr){
		int left = 0;
		int right = arr.length - 1;
		helperSort(arr, left, right);
    }
    

}//end class
