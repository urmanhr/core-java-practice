package com.urman.test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

public class RunAsyncDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		saveEmployees();
		saveEmployeesCustomExecutor();
	}

	public static Void saveEmployees() throws InterruptedException, ExecutionException {

		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
			try {
				List<Employee> employees = EmployeeDatabase.getEmployees();
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
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return runAsyncFuture.get();
	}

	public static Void saveEmployeesCustomExecutor() throws InterruptedException, ExecutionException {

		Executor ex = Executors.newFixedThreadPool(5);
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
			try {
				List<Employee> employees = EmployeeDatabase.getEmployees();
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
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}, ex);
		return runAsyncFuture.get();
	}

}
