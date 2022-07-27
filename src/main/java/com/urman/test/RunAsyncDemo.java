package com.urman.test;

import java.util.concurrent.ExecutionException;

public class RunAsyncDemo {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		EmployeeDatabase.getEmployees();
		EmployeeDatabase.getEmployeesLambda();
	}

}
