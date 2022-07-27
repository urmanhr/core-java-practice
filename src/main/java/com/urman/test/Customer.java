package com.urman.test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    private String name;
    private String email;
    private List<String> phoneNumbers;
    
    public static List<Customer> getCustomers () {
    	return Stream
		.of(new Customer("urman", "abc@abc.com", Arrays.asList("1234", "4321")),
				new Customer("jeel", "jeel@abc.com", Arrays.asList("5678", "8765")),
				new Customer("nirja", "nirja@abc.com", Arrays.asList("9876", "6789")))
		.collect(Collectors.toList());
    }
    
    public static List<Customer> getCustomersWithNulls () {
    	return Stream
		.of(new Customer("urman", null, Arrays.asList("1234", "4321")),
				new Customer("jeel", null, Arrays.asList("5678", "8765")),
				new Customer(null, "nirja@abc.com", Arrays.asList("9876", "6789")))
		.collect(Collectors.toList());
    }
}
