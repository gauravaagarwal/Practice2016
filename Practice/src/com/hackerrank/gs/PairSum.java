package com.hackerrank.gs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class PairSum {

	public static void main(String[] args) {
		int[] array = { 1, 2, -1, -2, 0, -1, 1, -1 };
		final Integer sum = 0;
		class Counter {
			int count;
		}
		final Counter count = new Counter();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Consumer<Integer> consumer = new Consumer<Integer>() {
			public Integer counter = 0;

			@Override
			public void accept(Integer pivot) {
				Integer complement = sum - pivot;
				if (map.containsKey(pivot)) {
					counter = counter + map.get(pivot);
				}
				if (map.containsKey(complement))
				map.put(complement, map.get(complement) + 1);
				else
					map.put(complement,  1);

				count.count = counter;
			}

		};
		Arrays.stream(array).boxed().forEach(consumer);
		System.out.println(count.count);
		// int counter=0;
		/*
		 * Arrays.stream(array).boxed().forEach(pivot->{ Integer complement =
		 * sum-pivot; if (map.containsKey(pivot)){ map.put(complement,
		 * map.get(complement)+1);
		 * 
		 * }else { map.put(complement, 0); } });
		 */
		map.entrySet().stream().forEach(System.out::println);
	}

}
