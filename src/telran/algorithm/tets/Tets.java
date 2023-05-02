package telran.algorithm.tets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.algorithm.InitialAlgorithm;

@SuppressWarnings("unused")
class Tets {
	
	
	Integer [] testArray1 = {2, 2, 2, 2, 2};
	Integer [] testArray2 = {2, 3, 5, 6};
	Integer [] testArray3 = {3, 3, 3, 4, 4};
	
	@Test
	void testIsSum2() {
		
		assertEquals(0, InitialAlgorithm.binarySearch(testArray1, 2, (a, b) -> a - b));
		assertEquals(-4, InitialAlgorithm.binarySearch(testArray2, 7, (a, b) -> a - b));
		assertEquals(-1, InitialAlgorithm.binarySearch(testArray2, 1, (a, b) -> a - b));
		assertEquals(-3, InitialAlgorithm.binarySearch(testArray2, 4, (a, b) -> a - b));
		assertEquals(0, InitialAlgorithm.binarySearch(testArray2, 2, (a, b) -> a - b));
		assertEquals(3, InitialAlgorithm.binarySearch(testArray3, 4, (a, b) -> a - b));
		assertEquals(0, InitialAlgorithm.binarySearch(testArray3, 3, (a, b) -> a - b));
	}
	

	
}
