package com.urman.test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		demo();
		getCustomerByEmailId("nirja@abc.com");
		getCustomerByEmailId("n");

	}

	public static void getCustomerByEmailId(String email) {
		List<Customer> custs = Customer.getCustomersWithNulls();
		System.out.println(custs.stream().filter(c -> email.equals(c.getEmail())).findAny()
				.orElse(Customer.getCustomers().get(0)));
		try {
			System.out.println(custs.stream().filter(c -> email.equals(c.getEmail())).findAny()
					.orElseThrow(() -> new NoSuchElementException("ABSENT")));
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException " + e.getMessage());
		}
	}

	public static void demo() {

		List<Customer> customers = Customer.getCustomersWithNulls();
		Customer c = customers.get(0);
		Optional<Object> emptyOptional = Optional.empty();
		System.out.println(emptyOptional);

//		of should be used only when we know object will not be null
		try {
			Optional<String> emailOptional = Optional.of(c.getEmail());
			System.out.println(emailOptional);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException " + e.getMessage());
		}
//		we can use ofNUllable when there is a chance of null value 
		Optional<String> emailOptional1 = Optional.ofNullable(c.getEmail());
		System.out.println(emailOptional1.isPresent() ? emailOptional1.get() : "not present");
		// here value is not present so it will print orElse value
		System.out.println(Optional.ofNullable(customers.get(1).getEmail()).orElse("jeel@abc.com"));
		// here value is present so it will print actual value and not orElse value
		System.out.println(Optional.ofNullable(customers.get(2).getEmail()).orElse("jeel@abc.com"));

		// here if value is null then throw some custom exeption
		try {
			System.out.println(Optional.ofNullable(customers.get(1).getEmail())
					.orElseThrow(() -> new IllegalArgumentException("email is absent")));
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException " + e.getMessage());
		}

	}

}
