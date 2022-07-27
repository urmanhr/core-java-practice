package com.urman.test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class EmployeeReminderService {

	public static List<Employee> getEmployees() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("suppplyasync : " + Thread.currentThread().getName());
			try {
				List<Employee> list = EmployeeDatabase.getEmployees();
				return list;
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
			return null;
		}).thenApply(employees -> {
			System.out.println("new joiner : " + Thread.currentThread().getName());
			return employees.stream().filter(employee -> "TRUE".equals(employee.getNewJoiner()))
					.collect(Collectors.toList());
		}).thenApply(employees -> {
			System.out.println("learning : " + Thread.currentThread().getName());
			return employees.stream().filter(employee -> "TRUE".equals(employee.getLearningPending()))
					.collect(Collectors.toList());
		}).thenApply(employees -> {
			System.out.println("learning : " + Thread.currentThread().getName());
			return employees.stream().map(Employee::getEmail).collect(Collectors.toList());
		}).thenAccept(email -> {
			System.out.println("email : " + Thread.currentThread().getName());
			email.forEach(EmployeeReminderService::sendEmail);
		});
		future.get();
		return null;
	}

	public static List<Employee> getEmployees1() throws InterruptedException, ExecutionException {
		CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("suppplyasync : " + Thread.currentThread().getName());
			try {
				return EmployeeDatabase.getEmployees();
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
			return null;
		}).thenApply(employees -> {
			System.out.println("new joiner : " + Thread.currentThread().getName());
			return employees.stream().filter(employee -> "TRUE".equals(employee.getNewJoiner()))
					.collect(Collectors.toList());
		}).thenApply(employees -> {
			System.out.println("learning : " + Thread.currentThread().getName());
			return employees.stream().filter(employee -> "TRUE".equals(employee.getLearningPending()))
					.collect(Collectors.toList());
		}).thenApply(employees -> {
			System.out.println("learning : " + Thread.currentThread().getName());
			return employees.stream().map(Employee::getEmail).collect(Collectors.toList());
		}).toCompletableFuture();
		System.out.println(future.get());
		return null;
	}

	public static void sendEmail(String email) {
		System.out.println("Sending email to " + email);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		getEmployees();
		getEmployees1();
	}

}
