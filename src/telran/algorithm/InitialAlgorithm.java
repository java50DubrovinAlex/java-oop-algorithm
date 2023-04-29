package telran.algorithm;

public class InitialAlgorithm {
	 public static void sortShortPositive(short [] array) {
   	  int [] helper = new int[Short.MAX_VALUE];
   	  //helper[index] => count of occurrences for number index in array
   	  //helper[1000] = 2 => number 1000 occurs twice in the source array
   	  //helper[2] = 0;
   	  for(int i = 0; i < array.length; i++) {
   		  helper[array[i]]++; 
   	  }
   	  int ind = 0;
   	  for(int i = 0; i < helper.length; i++) {
   		  for(int j = 0; j < helper[i]; j++) {
   			  array[ind++] = (short) i;
   		  }
   	  }
	 }
	 
public static boolean isSum2(short[] array, short sum) {
	int [] helper = new int[Short.MAX_VALUE];
	for(int i = 0; i < array.length; i++) {
		helper[array[i]]++;
	}
	short delta;
	for(int i = 0; i < array.length; i++) {
		delta = (short) (sum - array[i]);
		if(helper[delta] > 0) {
			return true;
		}
	}
	return false;
	
}

public static short getMaxPositiveWithNegativeReflect(short[] array) {
	short res = -1;
	  int [] helper = new int [Short.MAX_VALUE];
	  for(int i = 0; i < array.length; i++) {
		  if(array[i] < 0) {
			  array[i] *= -1;
			  helper[array[i]]++;
	  }else {
		  helper[array[i]]++;
	  }  
	  }
	  for(int i = helper.length - 1; i >= 0; i--) {
		  if(helper[i] == 2) {
			  return res = (short) i;
		  }
	  }
	  return res;
}
}
