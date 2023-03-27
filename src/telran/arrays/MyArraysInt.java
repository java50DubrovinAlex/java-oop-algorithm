package telran.arrays;

import java.util.Arrays;

public class MyArraysInt {
	public static int [] addNumber(int[] array, int num){	
		int [] res;
		res = Arrays.copyOf(array, array.length + 1);
		res[res.length - 1] = num;
		return res;
	}
	public static int [] removeNumber(int []arrays, int index) {
		int [] res;
		if(index < 0 || index > arrays.length - 1) {
			res = arrays;
		}else {
			res = new int [arrays.length - 1];
			System.arraycopy(arrays, 0, res, 0, index);
			System.arraycopy(arrays, index + 1, res, index, res.length - index);
		}
		
		
		return res;
	}
	public static int [] insertNumber(int [] arrays, int index, int num) {
		int [] res;
		if (index < 0 || index > arrays.length) {
			res = arrays;
		}else {
			res = new int [arrays.length + 1];
			System.arraycopy(arrays, 0, res, 0, index);
			res [index] = num;
			System.arraycopy(arrays, index , res, index + 1, arrays.length - index);
		}
		return res;
	}
	
	
	
}
