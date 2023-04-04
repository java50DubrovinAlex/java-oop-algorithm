package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import telran.util.*;

import org.junit.jupiter.api.Test;



class ArrayListTest {
List<Integer> list;
Integer[] numbers = {10, -20, 7, 50, 100, 30};
@BeforeEach
void setUp() {
	list = new ArrayList<>(1);
	for( int i = 0; i < numbers.length; i++) {
		list.add(numbers[i]);
	}
}
	@Test
	void testAdd() {
	assertTrue(list.add(numbers[0]));
	assertEquals(numbers.length + 1, list.size());
	}
	@Test
	void testAddIndex() {
		Integer [] expected0_500 = {500, 10, -20, 7, 50, 100, 30};
		Integer [] expected0_500_3_700 = {500, 10, -20, 700, 7, 50, 100, 30};
		Integer [] expected0_500_3_700_8_300 = {500, 10, -20, 700, 7, 50, 100, 30, 300};
		list.add(0, 500);
		runTest(expected0_500);
		list.add(3, 700);
		runTest(expected0_500_3_700);
		list.add(8, 300);
		runTest(expected0_500_3_700_8_300);
		
	}
	@Test
	void testRemoveIndex() {
		Integer [] expectedNo10 = { -20, 7, 50, 100, 30};
		Integer [] expectedNo10_50 = { -20, 7,  100, 30};
		Integer [] expectedNo10_50_30 = { -20, 7,  100};
		assertEquals(10, list.remove(0));
		runTest(expectedNo10);
		assertEquals(50, list.remove(2));
		runTest(expectedNo10_50);
		assertEquals(30, list.remove(3));
		runTest(expectedNo10_50_30);
		
	}
	@Test
	void testGetIndex() {
		assertEquals(10, list.get(0));
	}
	@Test
	void testIndexOf() {
		list.add(3, 10);
		assertEquals(0, list.indexOf(10));
		assertEquals(-1, list.indexOf(null));
	}
	@Test
	void testLastIndexOff() {
		list.add(4, 10);
		assertEquals(4, list.lastIndexOf(10));
		assertEquals(-1, list.lastIndexOf(null));
	}
	@Test
	void testRevove() {
		List <String> list = new ArrayList<>();
		list.add("apple");
	    list.add("banana");
	    list.add("orange");
	    assertEquals(3, list.size());
		assertEquals(true, list.remove("banana"));
		list.remove("orange");
		assertEquals(1, list.size());
		String app = list.get(0);
		assertEquals("apple", app);
		
		
	}
	@Test
	void testToArray() {
		Integer [] array1 = new Integer [6];
		Integer [] array2 = new Integer [8];
		Integer [] array3 = new Integer [0];
		
		Integer [] newArray1 = list.toArray(array1);
		assertEquals(6, newArray1.length);
		assertEquals(10, newArray1[0]);
		assertEquals(30, newArray1[5]);
		Integer [] newArray2 = list.toArray(array2);
		assertEquals(8, newArray2.length);
		assertEquals(10, newArray2[0]);
		assertEquals(null, newArray2[7]);
		Integer [] newArray3 = list.toArray(array3);
		assertEquals(6, newArray3.length);
		assertEquals(10, newArray3[0]);
		assertEquals(30, newArray3[5]);
	}
	private void runTest(Integer[] expected) {
		int size = list.size() ;
		Integer [] actual = new Integer[expected.length];
		
		for(int i = 0; i < size; i++) {
			actual[i] = list.get(i);
		}
		assertArrayEquals(expected, actual);
		
	}

}

