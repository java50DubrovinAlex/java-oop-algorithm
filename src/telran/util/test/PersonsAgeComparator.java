package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class PersonsAgeComparator implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		
		return Integer.compare(person1.getAge(),
				person2.getAge());
	}

}










	
	
	
	
	