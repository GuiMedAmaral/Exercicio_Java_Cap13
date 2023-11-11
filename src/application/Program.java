package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		String departament, level, workerName;
		Double baseSalary, valuePerHour;
		int n, hours;
		Date date,date_final;
		
		SimpleDateFormat fmt1 = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		departament = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		workerName = sc.nextLine();
		System.out.print("Level: ");
		level = sc.nextLine();
		System.out.print("Base salary: ");
		baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(level), baseSalary, new Department(departament));
		System.out.print("How many contracts to this worker? ");
		n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			date = fmt1.parse(sc.next());
			System.out.print("Value per hour: ");
			valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			hours = sc.nextInt();
	
			HourContract contract = new HourContract(date, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3, 7));
		System.out.println("Name: " + workerName);
		System.out.println("Departament: " + worker.getDepartment().getName());
		
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month) ));
		
		sc.close();
		
	}

}
