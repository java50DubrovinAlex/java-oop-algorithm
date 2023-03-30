package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.ArrayList;

class ArrayListTest {

	@Test
	void testAddIndex() {
		ArrayList <Integer> numbers = new ArrayList<>();
		ArrayList <String> string = new ArrayList<>();
		string.add("b");
		string.add(0, "a");
		string.add(2, "c");
		string.add(3, "d");
		
		numbers.add(5);
		numbers.add(0, 4);
		numbers.add(2, 6);
		numbers.add(0, 3);
		numbers.add(0, 2);
		
		assertEquals(5, numbers.size());
		assertEquals(4, string.size());
		
		assertEquals(2, numbers.get(0));
		assertEquals(6, numbers.get(4));
		assertEquals(null, numbers.get(5));
		assertEquals(4, numbers.get(2));
		
		assertEquals("a", string.get(0));
		assertEquals("c", string.get(2));
		assertEquals("d", string.get(3));
		assertEquals(null, string.get(4));
	}
	@Test
	void testRemoveIndex() {
		ArrayList <Integer> numbers = new ArrayList<>();
		
		
		numbers.add(0, 1);
		numbers.add(1, 2);
		numbers.add(2, 3);
		numbers.add(3, 4);
		numbers.add(4, 5);
		
		numbers.remove(4);
		int expReturn = numbers.remove(0);

		assertEquals(2, numbers.get(0));
		assertEquals(3, numbers.get(1));
		assertEquals(4, numbers.get(2));
		assertEquals(null, numbers.get(3));
		assertEquals(null, numbers.get(4));
		assertEquals(null, numbers.get(5));
		assertEquals(null, numbers.get(6));
		assertEquals(null, numbers.get(7));
		assertEquals(3, numbers.size());
		assertEquals(1, expReturn);
		
	}

}
