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

    
    
    public static void main(String[] args){
	double[] a = {22,21,2,8};
	System.out.println(mean(a));
	System.out.println(min(a));
    }
}
