package day04;

import java.util.HashMap;
import java.util.Map;

public class PairFinder {

	int findPairs(int[] arr){
		int result = 0;
		Map<Integer, Integer> pairs = new HashMap();

		for(int number : arr) {
			if (pairs.containsKey(number)) {
				System.out.println("number: "+number);
				int curValue = pairs.get(number);
				pairs.put(number, curValue+1);
				if ((curValue+1) % 2 == 0) result++;
			} else {
				pairs.put(number, 1);
			}
		}

		return result;
	}
}
