import java.util.ArrayList;

public class Sorts{
        public static void mergeSort( double[] data ) 
    {
      	//number of req passes as discussed in class
	int totalPasses = data.size() - 1;
	//initialize counter at 0
	int currentPasses = 0;

	//for storage of index
	int swapperIndex;

	while(currentPasses < totalPasses){
	    //initiate swapperIndex as currentPasses index
	    // not changed if currentPasses is smaller or equal to
	    // everything to its right
	    swapperIndex = currentPasses;

	    //iterate thru array
	    for(int i = currentPasses; i < data.length; i++){
		//if any values at indexes after currentPasses are smaller 
		if (data[i].compareTo(data[swapperIndex]) < 0)
		    //store index value in swapperIndex
		    swapperIndex = i;
	    }
	    
	    //insert data at swapperIndex at currentPasses index
	    data.add(currentPasses, data[swapperIndex]);

	    //remove data at swapperIndex
	    data.remove(swapperIndex + 1);
	    
	    //increase currentPasses count
	    currentPasses++;
	}

	
    }//end selectionSortV
}
