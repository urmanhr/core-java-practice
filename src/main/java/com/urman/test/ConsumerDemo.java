package com.urman.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4);
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
