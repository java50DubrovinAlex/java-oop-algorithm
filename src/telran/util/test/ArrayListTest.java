package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

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
	
	private void runTest(Integer[] expected) {
		int size = list.size() ;
		Integer [] actual = new Integer[expected.length];
		
		for(int i = 0; i < size; i++) {
			actual[i] = list.get(i);
		}
		assertArrayEquals(expected, actual);
		
	}
//==============================HW04==========================
	@Test
	void testRemovePattern() {
		int size = list.size();
		Integer d1 = 7;
		assertTrue(list.remove(d1));
		Integer d2 = 22;
		assertFalse(list.remove(d2));
		assertEquals(size-1, list.size());
	}
	@Test
	void testLastIndexOf() {
		// {10, -20, 7, 50, 100, 30}
		list.add(1, 7);
		assertEquals(3, list.lastIndexOf(7));
		list.add(7);
		assertEquals(7, list.lastIndexOf(7));
		assertEquals(-1, list.lastIndexOf(null));
	}
	@Test
	void testToArray() {
		Object a[] = list.toArray();
		Integer[] expected = Arrays.copyOf(a, a.length, Integer[].class);
		runTest(expected);
	}
//	@Test
//	void testToArrayBuffer() {
//		Integer [] buf = new Integer[2];
//		Integer [] expected = (Integer[])list.toArray(buf);
//		runTest(expected);
//		buf = new Integer[12];
//		expected = (Integer[])list.toArray(buf);
//		printArray(expected);
//		runTest(expected);
//	}
	@Test
	void testToArrayBuffer() {
		Integer[] expectedList = {10, -20, 7, 50, 100, 30};
		Integer[] expectedSpareSize = {10, -20, 7, 50, 100, 30, null};
		
		Integer[]arrListSize = new Integer[list.size()];
		Integer[] arrLessSize = new Integer[list.size()-1];
		Integer[] arrSpareSize = new Integer[list.size()+1];
		for(int i=0; i<list.size()+1; i++) {
			arrSpareSize[i] = i*2;
		}
		assertArrayEquals(expectedList, list.toArray(arrListSize));
		assertArrayEquals(expectedList, list.toArray(arrLessSize));
		assertArrayEquals(expectedSpareSize, list.toArray(arrSpareSize));
	}
	void printArray(Object[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(" ");
	}

}
