package com.hackerrank.gs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RepeatedWord {

	public static void main(String[] args) {
		String inputString = "Ravi had been saying that he had been there";
		Map<String,Integer> map = new HashMap<String, Integer>();
		Consumer<String> c = new Consumer<String>() {
			@Override
			public void accept(String key) {
				if (map.containsKey(key)){
					map.put(key, map.get(key)+1);
				} else {
					map.put(key, 1);
				}
			}
		};
		
		//Arrays.stream(inputString.split(" ")).map(s->s+"fix").forEach(c);;
		Arrays.stream(inputString.split(" ")).forEach(s->{
			if (map.containsKey(s)){
				map.put(s, map.get(s)+1);
			} else {
				map.put(s, 1);
			}
		});
		
	/*	 Map<Object, Object> m = Arrays.stream(inputString.split(" ")).
			        collect(Collectors.toMap(
			            x -> x,
			            x -> 1
			        ));*/
		 
		 //m.entrySet().stream().forEach(System.out::println);
		 map.entrySet().stream().forEach(System.out::println);
		 
		 map.entrySet().stream().forEach(pair->{if (pair.getValue().equals(2)){
			 System.out.println(pair);
		 }
			 });

		 
		 
	}

}
