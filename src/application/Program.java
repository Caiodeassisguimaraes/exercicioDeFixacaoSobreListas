package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		// List<Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int employeesNumber = sc.nextInt();

		List<Employee> list = new ArrayList<>(employeesNumber);

		for (int i = 0; i < employeesNumber; i++) {
			System.out.println("Emplyoee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			list.add(new Employee(id, name, salary));
		}

		System.out.print("Enter the employee id that will have salary increase: ");
		Integer id = sc.nextInt();

		Employee employeeId = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (employeeId == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			employeeId.increaseSalary(percentage);
		}

		System.out.println("List of employees: ");
		for (Employee employeeList : list) {
			System.out.println(employeeList);
		}

		sc.close();

	}

}
