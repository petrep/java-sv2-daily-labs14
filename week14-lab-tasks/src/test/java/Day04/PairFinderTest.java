package Day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

	@Test
	void findPairsTest() {
//		int[] input1 = {5, 1, 4, 5};
		int[] input1 = {7, 1, 5, 7, 3, 3, 5, 7, 6, 7};

		PairFinder pf = new PairFinder();
//		System.out.println(pf.findPairs(input1));

		assertEquals(4, pf.findPairs(input1));

	}
}