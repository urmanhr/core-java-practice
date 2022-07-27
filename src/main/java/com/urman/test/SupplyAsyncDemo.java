package com.urman.test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SupplyAsyncDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		List<Employee> list = getEmployees();
		list.stream().forEach(System.out::println);
	}

	public static List<Employee> getEmployees() throws InterruptedException, ExecutionException {
		Executor ex = Executors.newCachedThreadPool();
		CompletableFuture<List<Employee>> employeeFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread : " + Thread.currentThread().getName());
			try {
				return EmployeeDatabase.getEmployees();
			} catch (InterruptedException | ExecutionException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}, ex);
		return employeeFuture.get();
	}

}
