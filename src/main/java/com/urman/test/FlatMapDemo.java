package com.urman.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

public class FlatMapDemo {

	public static void main(String[] args)
			throws StreamReadException, DatabindException, InterruptedException, ExecutionException, IOException {

		List<Customer> custs = Stream
				.of(new Customer("urman", "abc@abc.com", Arrays.asList("1234", "4321")),
						new Customer("jeel", "jeel@abc.com", Arrays.asList("5678", "8765")),
						new Customer("nirja", "nirja@abc.com", Arrays.asList("9876", "6789")))
				.collect(Collectors.toList());

		// map in stream is used for one to one mapping
		System.out.println(custs.stream().map(Customer::getEmail).collect(Collectors.toList()));
		System.out.println(custs.stream().map(Customer::getPhoneNumbers).collect(Collectors.toList()));
		// flat map is used for one to many mapping
		System.out.println(custs.stream().flatMap(c -> c.getPhoneNumbers().stream()).collect(Collectors.toList()));
	}

}
