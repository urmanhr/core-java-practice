package com.urman.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsumerDemo {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4);
		
		//sample IntStream
		list = IntStream.range(0, 100).boxed().collect(Collectors.toList());
//		Consumer<Integer> consumer = System.out::println;
		Consumer<Integer> consumer = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}
		};
		list.stream().forEach(consumer);
	}

}
