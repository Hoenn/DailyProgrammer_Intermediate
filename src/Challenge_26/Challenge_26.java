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
	private static Scanner input = new Scanner(System.in);
	public static void main(String args[])
	{
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		int option = 0;
		while(option>=0)
		{
			System.out.println("1. Add employee");
			System.out.println("2. Delete employee");
			System.out.println("3. Edit employee");
			System.out.println("4. Display employees");
			System.out.println("-1. Quit");
			option = Integer.parseInt(input.nextLine());
			switch(option)
			{
				case 1:	addEmployee(employeeList);
						break;
				case 2: deleteEmployee(employeeList);
						break;
				case 3: editEmployee(employeeList);
						break;
				case 4: printList(employeeList);
			}
		}
	}
	private static void addEmployee(ArrayList<Employee> employeeList)
	{
		System.out.println("Enter a name: ");
		String name = input.nextLine();
		System.out.println("Enter a ID: ");
		int id = Integer.parseInt(input.nextLine());
		System.out.println("Enter a salary: ");
		double salary = Double.parseDouble(input.nextLine());
		employeeList.add(new Employee(name, id, salary));
	}
	private static void deleteEmployee(ArrayList<Employee> employeeList)
	{
		System.out.println("Enter name of delete");
		String name = input.nextLine();
		for(int i=0; i<employeeList.size(); i++)
		{
			if(employeeList.get(i).getName().equals(name))
			{
				employeeList.remove(i);
				i=employeeList.size();
			}
		}
	}
	private static void editEmployee(ArrayList<Employee> employeeList)
	{
		System.out.println("Enter name of employee to edit");
		String name = input.nextLine();
		Employee edit = null;
		for(int i=0; i<employeeList.size(); i++)
		{
			if(employeeList.get(i).getName().equals(name))
			{
				edit=employeeList.get(i);
			}
		}
		if(edit == null)
		{
			System.out.println("Employee not found");
			return;
		}
		System.out.println("Enter new name or nothing to keep");
		String newName = input.nextLine();
		System.out.println("Enter new ID or -1 to keep");
		int newId = Integer.parseInt(input.nextLine());
		System.out.println("Enter new Salary or -1 to keep");
		double newSal = Double.parseDouble(input.nextLine());
		
		if(!newName.equals(""))
		{
			edit.setName(newName);
		}
		if(newId >=0)
		{
			edit.setID(newId);
		}
		if(newSal>=0)
		{
			edit.setSalary(newSal);
		}
			
		
		
		
	}
	private static void printList(ArrayList<Employee> employees)
	{
		for(Employee e: employees)
			System.out.println(e.toString());
	}

}
