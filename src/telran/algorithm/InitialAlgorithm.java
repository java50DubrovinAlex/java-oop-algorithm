package telran.algorithm;

import java.util.Comparator;

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
	
	  boolean [] helperPositiv = new boolean [Short.MAX_VALUE];
	  boolean [] helperNegativ = new boolean [Short.MAX_VALUE];

	  for(int i = 0; i < array.length; i++) {
		  if(array[i] < 0) {
			  helperNegativ[array[i] * -1] = true;
		  }else {
			  helperPositiv[array[i]] = true;
		  }
		 
	  }
	  for(int i = helperPositiv.length - 1; i >= 0; i--) {
		  if(helperNegativ[i] == true && helperPositiv[i] == true) {
			  return (short) i;
		  }
		  
	  }
	return -1;
}
public static <T> int binarySearch(T [] array, T key,
		Comparator<T> comp) {
	int leftIndex = 0;
	int rightIndex = array.length - 1;
	int middleIndex = rightIndex / 2;
	int compRes = 0;
	int keyIndex = 0 ;
	while(leftIndex <= rightIndex &&
			((compRes = comp.compare(key, array[middleIndex])) != 0 ||  middleIndex != 0))
	{
		if (compRes > 0) {
			//move to right part of the array
			if(middleIndex == rightIndex) {
				keyIndex = middleIndex;
			}else {
				keyIndex = comp.compare(key, array[middleIndex + 1]) < 0 ? keyIndex = middleIndex + 1 : 0;
			}
			leftIndex = middleIndex + 1;
		} else {
			if(middleIndex == leftIndex) {
				keyIndex = middleIndex;
			}else {
				keyIndex = comp.compare(key, array[middleIndex - 1]) > 0 ? keyIndex = middleIndex - 1 : 0;
			}
			rightIndex = middleIndex - 1;
		}
		if(comp.compare(key, array[middleIndex]) != 0 || comp.compare(key, array[middleIndex - 1]) == 0) {
			middleIndex = (leftIndex + rightIndex) / 2;
		}
	}
	return leftIndex > rightIndex && comp.compare(key, array[middleIndex]) != 0 ? ((keyIndex + 1) * -1)  : middleIndex;
}
}
