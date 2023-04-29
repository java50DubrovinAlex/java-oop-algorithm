package telran.algorithm.tets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.algorithm.InitialAlgorithm;

@SuppressWarnings("unused")
class Tets {
	
	short [] tetsArray = {0, 1, 2, 3, 4, 5, 6,};
	
	short [] tetsArray1 = {0, 1, 2, 3, 4, 5, 6, -6};
	
	
	@Test
	void testIsSum2() {
		assertTrue(InitialAlgorithm.isSum2(tetsArray, (short) 1));
		assertFalse(InitialAlgorithm.isSum2(tetsArray, (short) 25));
	}
	@Test 
	void testGetMaxPositiveWithNegativeReflect(){
		assertEquals(6, InitialAlgorithm.getMaxPositiveWithNegativeReflect(tetsArray1));
	}

	
}
