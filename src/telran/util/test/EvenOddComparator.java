package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {

		boolean isNum1Even = num1 % 2 == 0 ;
		boolean isNum2Even = num2 % 2 == 0 ;
		if(isNum1Even && isNum2Even || !isNum1Even && !isNum2Even) {
			return isNum1Even == true ? num1 - num2: num2 - num1;
		} else {
			return  isNum1Even == true ? -1 : 1;
		}
		
	}

}
