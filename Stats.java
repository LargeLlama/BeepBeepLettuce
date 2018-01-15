   
public class Stats{

    //class Stats takes array of type double and returns operations
    //arrays must have at least one element

    //takes array _array of type double
    //returns mean of elements in _array
    public static double mean(double[] _array){
	double sumArray = 0;
	for (double  x : _array)
	    sumArray+=x;
	
	return sumArray/_array.length;	
    }
    
		
    //takes array _array of type double
    //returns largest element of _array
    public static double max(double[] _array){
	double retMax = 0;
	for (double x : _array)
	    if (x > retMax)
		retMax = x;

	return retMax;	
    }

    
    //takes array _array of type double
    //returns smallest element of _array
    public static double min(double[] _array){
	double retMin = _array[0];
	for (double x : _array)
	    if (x < retMin)
		retMin = x;

	return retMin;	
    }


    // //returns array of most repeated element(s) of _array
    // public static double[] mode(double[] _array){

    // 	double[] retVal = {_array[0]};
	
    // 	//if _array has only 1 element, return the element
    // 	if(_array.length==1)
    // 	    return retVal;
	
    //     Sorts.qsort(_array);//sort array
    // 	retVal = null;
    // 	int maxFreq = 0;

    // 	int tempFreq = 0;
	
    // 	for(int i = 0; i < _array.length; i++){
    // 	    if(_array[i]==_array[0])
    // 		tempFreq++;
    // 	    else if(tempFreq >= maxFreq)
    // 		retVal = new
    // 		retVal.add(_array[i]);
    // 	    else
    // 		tempFreq = 0;
    // 	}
	
    // 	return retVal;
    // }

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
	    Sorts.mergeSort(_array);
	    
	    double retMed;
	    int x = _array.length;

	    //check parity of x 
	    if(x%2 ==0)
	        retMed = (_array[x/2] + _array[(x/2)-1])/2;
	    else
		retMed = _array[Math.floor(x/2)];

	    return retMed;
	}

    //returns first quartile of _array elements
    public static  double q1(double[] _array){
	Sorts.mergeSort(_array);
	double retQ1;
	int x = _array.length;

	//y specifies the number of elements smaller than median
	int y = Math.floor(x/2);

	if(y%2 ==0)
	    retQ1 = (_array[y/2] + _array[(y/2)-1])/2;
	else
	    retQ1 = _array[Math.floor(y/2)];

	return retQ1;
    }

       //returns third quartile of _array elements
    public static  double q1(double[] _array){
	Sorts.mergeSort(_array);
	double retQ1;
	int x = _array.length;

	//y specifies the number of elements smaller than median
	int y = Math.floor(x/2);

	if(y%2 ==0)
	    retQ1 = (_array[y/2] + _array[(y/2)-1])/2;
	else
	    retQ1 = _array[Math.floor(y/2)];

	return retQ1;
    }

    public static double iqr(double[] _array){
	retIQR = q3(_array)-q1(_array);

	return retIQR;
    }
	

    //returns array of _array outliers
    public static  double[] outliers(double[] _array){
	

    
    public static void main(String[] args){
	double[] a = {11,12,22,11,22};
	System.out.println(stDev(a));
    }
}
