package com.urman.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeDatabase {

	public static List<Employee> getEmployees() throws InterruptedException, ExecutionException {

		final ObjectMapper mapper = new ObjectMapper();
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(new Runnable() {

			public void run() {
				try {
					List<Employee> employees = mapper.readValue(new File("employees.json"),
							new TypeReference<List<Employee>>() {
							});
					System.out.println("Thread:" + Thread.currentThread().getName());
					System.out.println(employees.size());
					// employees.stream().forEach(System.out::println);
				} catch (StreamReadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DatabindException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		runAsyncFuture.get();
		return null;
	}

	public static List<Employee> getEmployeesLambda() throws InterruptedException, ExecutionException {

		final ObjectMapper mapper = new ObjectMapper();
		Executor ex = Executors.newFixedThreadPool(5);
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
			try {
				List<Employee> employees = mapper.readValue(new File("employees.json"),
						new TypeReference<List<Employee>>() {
						});
				System.out.println("Thread:" + Thread.currentThread().getName());
				System.out.println(employees.size());
				// employees.stream().forEach(System.out::println);
			} catch (StreamReadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabindException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, ex);
		runAsyncFuture.get();
		return null;
	}

}
