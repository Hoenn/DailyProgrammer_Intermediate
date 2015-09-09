package Challenge_26;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Text:  An employer wants you to store some information about his employees in an easy to read list form. 
 * He wants you to input the names, ages, and the pay of his employees. Unfortunately, he is terrible with computers,
 * and he'll call you in every time he wants to change something he's going to call you in, unless you add an easy 
 * way to edit the information.
 */
public class Challenge_26
{
	public static void main(String args[])
	{
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a name: ");
		String name = input.nextLine();
		System.out.println("Enter a ID: ");
		int id = Integer.parseInt(input.nextLine());
		System.out.println("Enter a salary: ");
		double salary = Double.parseDouble(input.nextLine());
		
		
	}
	
	private class Employee
	{
		private String name;
		private int id;
		private double salary;
		public Employee(String n, int i, double s)
		{
			name = n;
			id = i;
			salary =s;
		}
		
	}
}
