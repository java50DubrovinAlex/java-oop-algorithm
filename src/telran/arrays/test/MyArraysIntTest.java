package telran.arrays.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import telran.arrays.MyArraysInt;

class MyArraysIntTest {

	@Test
	void testAddNumber() {
		int [] array = {1, 2, 3};
		int num = 4;
		int [] expected = {1, 2, 3, 4};
		assertArrayEquals(expected, MyArraysInt.addNumber(array, num));
	}

	@Test
	void testRemoveNumber() {
		int [] array = {1, 2, 3, 4, 5};
		int index = 3;
		int index1 = -1;
		int index2 = 5;
		int index3 = 0;
		
		
		int [] expected = {1, 2, 3, 5};
		int [] expected1 = {1, 2, 3, 4, 5};
		int [] expected2 = {1, 2, 3, 4, 5};
		int [] expected3 = {2, 3, 4, 5};

		assertArrayEquals(expected, MyArraysInt.removeNumber(array, index));
		assertArrayEquals(expected1, MyArraysInt.removeNumber(array, index1));
		assertArrayEquals(expected2, MyArraysInt.removeNumber(array, index2));
		assertArrayEquals(expected3, MyArraysInt.removeNumber(array, index3));
	}

	@Test
	void testInsertNumber() {
		int [] array = {1, 2, 3, 4, 5};
		int index = 5;
		int index1 = -1;
		int index2 = 6;
		int index3 = 0;
		int index4 = 2;
		
		int num = 6;
		int num1 = 0;
		int num2 = 7;
		int num3 = 0;
		int num4 = 9;
		
		
		int [] expected = {1, 2, 3, 4, 5, 6};
		int [] expected1 = {1, 2, 3, 4, 5};
		int [] expected2 = {1, 2, 3, 4, 5};
		int [] expected3 = {0, 1, 2, 3, 4, 5};
		int [] expected4 = {1, 2, 9, 3, 4, 5};
		assertArrayEquals(expected, MyArraysInt.insertNumber(array, index, num));
		assertArrayEquals(expected1, MyArraysInt.insertNumber(array, index1, num1));
		assertArrayEquals(expected2, MyArraysInt.insertNumber(array, index2, num2));
		assertArrayEquals(expected3, MyArraysInt.insertNumber(array, index3, num3));
		assertArrayEquals(expected4, MyArraysInt.insertNumber(array, index4, num4));
	}
	@Test
	void testCopyOf() {
		int [] array = {1, 2, 3} ;
		int [] expected1 = {1, 2, 3};
		int [] expected2 = {1};
		int [] expected3 = {1, 2, 3, 0, 0, 0};
		assertArrayEquals(expected1, Arrays.copyOf(array, array.length));
		assertArrayEquals(expected2, Arrays.copyOf(array, 1));
		assertArrayEquals(expected3, Arrays.copyOf(array, 6));
	}
	@Test
	void testArrayCopy() {
		int [] array = {1, 2, 3};
		int [] expected = {5, 10, 1, 2, 20};
		int [] arrayDest = new int [5];
		int [] array1 = {2, 5, 10};
		System.arraycopy(array, 0, arrayDest, 2, 2);
		System.arraycopy(array1, 1, arrayDest, 0, 2);
		arrayDest[4] = 20;
		assertArrayEquals(expected, arrayDest);
	}
	@Test
	void testBinarySearchInt() {
		int [] array = {1, 2, 3, 4, 5, 6};
		
		int key = 4;
		int key1 = -10;
		int key2 = 8;
		int key3 = 7;
		
		int fromIndex = 0;
		int toIndex = 4;
		
		int fromIndex1 = 3;
		int toIndex1 = 5;
		
		int fromIndex2 = 0;
		int toIndex2 = 5;
		
		int expected = 3;
		int expected1 = 3;
		int expected2 = 3;
		int expected3 = -1;
		int expected4 = -7;
		int expected5 = -6;
		
		
		assertEquals(expected, Arrays.binarySearch(array, key));
		assertEquals(expected1, Arrays.binarySearch(array, fromIndex, toIndex, key));
		assertEquals(expected2, Arrays.binarySearch(array, fromIndex1, toIndex1, key));
		assertEquals(expected3, Arrays.binarySearch(array, key1));
		assertEquals(expected4, Arrays.binarySearch(array, key2));
		assertEquals(expected5, Arrays.binarySearch(array, fromIndex2, toIndex2, key3));
		
		//Arrays.binarySearch(int [], int)
	}
}
