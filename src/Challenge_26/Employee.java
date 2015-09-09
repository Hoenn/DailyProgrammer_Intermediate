package Challenge_26;

public class Employee {
	private String name;
	private int id;
	private double salary;
	public Employee(String n, int i, double s)
	{
		name = n;
		id = i;
		salary =s;
	}
	public String toString()
	{
		return name+", "+id+", "+salary;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
	public void setID(int i)
	{
		id=i;
	}
	public void setSalary(double s)
	{
		salary=s;
	}
}
