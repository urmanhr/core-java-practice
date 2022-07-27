package com.urman.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeDatabase {

	public static List<Employee> getEmployees() throws InterruptedException, ExecutionException, StreamReadException, DatabindException, IOException {

		final ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File("employees.json"),
				new TypeReference<List<Employee>>() {
				});		
	}

}
