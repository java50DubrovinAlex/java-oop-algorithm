package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {

		boolean isNum1Even = ((int)num1 % 2 == 0) ;
		boolean isNum2Even = ((int)num2 % 2 == 0) ;
		if(isNum1Even && isNum2Even || !isNum1Even && !isNum2Even) {
			return isNum1Even ? num1 - num2: num2 - num1;
		} 
			return  isNum1Even ? -1 : 1;
			
	}

}
