public class Stats{

    //class Stats takes an array of type double
    //since we are using Stats in the context of a gradebook,
    //it is assumed that all array elements will be positive,
    //and only arrays of non-trivial sizes will be provided.
    //Stats will return the results of various statistical calculations.
    

    //returns mean of elements in _array
    public static double mean(double[] _array){
	double sumArray = 0;
	for (double  x : _array)
	    sumArray+=x;
	
	return sumArray/_array.length;	
    }
    
		
    //returns largest element of _array
    public static double max(double[] _array){
	double retMax = 0;
	for (double x : _array)
	    if (x > retMax)
		retMax = x;

	return retMax;	
    }

    
    //returns smallest element of _array
    public static double min(double[] _array){
	double retMin = _array[0];
	for (double x : _array)
	    if (x < retMin)
		retMin = x;

	return retMin;	
    }


    //returns population standard deviation of _array elements
    public static double stDev(double[] _array){
	double variance = 0;
	double _mean = mean(_array);
	for (double x : _array)
	    variance += (x - _mean)*(x - _mean)/_array.length;

	return Math.sqrt(variance);
    }

    //returns median of _array elements
    public static double median(double[] _array){
	// Sorts.mergeSort(_array);
	    
	double retMed;

	//x stores length of _array
	int x = _array.length;

	//check parity of x
	//parity determines where median lies
	if(x%2 ==0)
	    retMed = (_array[x/2] + _array[(x/2)-1])/2;
	else
	    retMed = _array[(x-1)/2];

	return retMed;
    }

    //returns first quartile of _array elements
    public static double q1(double[] _array){
	//Sorts.mergeSort(_array);
	double retQ1;
	int x = _array.length;

	//y specifies the number of elements less than median
	int y = x/2;

	double[] temp = new double[y];
	for(int i=0;i<y;i++)
	    temp[i]=_array[i];

	retQ1 = median(temp);
	return retQ1;
    }
    

    //returns third quartile of _array elements
    public static double q3(double[] _array){
	//Sorts.mergeSort(_array);
	double retQ3;
	int x = _array.length;

	//y specifies the number of elements greater than median
	int y = x/2;

	double[] temp = new double[y];
	for(int i=x-y;i<x;i++)
	    temp[i+y-x]=_array[i];

	retQ3 = median(temp);
	return retQ3;
    }

    
    //returns the distance between the first and third quartiles
    public static double iqr(double[] _array){
	double retIQR = q3(_array)-q1(_array);
	return retIQR;
    }
	

    //returns array of outliers in _array 
    public static double[] outliers(double[] _array){
	double[] retOut;//array to store outlier values
	int size = 0;//size of retOut
	
	double bounds = 1.5*iqr(_array);//max dist from low or high allowed
	double low = q1(_array);
	double high = q3(_array);

	//establish size of retOut by iterating through _array,
	// counting number of outliers
	for(double a : _array){
	    if(a > high + bounds || a < low - bounds)
		size++;
	}
	retOut = new double[size];

	//copy all outlier values into retOut
	int counter = 0;
	for(double b : _array){
	    if(b > high + bounds || b < low - bounds){
		retOut[counter] = b;
		counter++;
	    }
	}

	//return array of outliers
	return retOut;	
    }

    
    //returns String representation of the histogram
    // of _array elements
    public static String histogram(double[] _array){
	//Sorts.mergeSort(_array);
	String retStr = "";

	//outer loop iterates through non-repeated elements
	for(int i = 0; i < _array.length; i++){
	    retStr+= _array[i] + ": " + "*";

	    //inner loop iterates through repeated elements
	    for(int x = i; x < _array.length - 1 &&
		    _array[x] == _array[x+1]; x++){
		retStr+= " *";
		i++;
	    }
	    retStr+= "\n";
	}
	
	return retStr;
    }

    
}//end class

