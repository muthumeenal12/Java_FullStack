package employee;

import java.time.Year;
import java.util.Scanner;

public class Employee {
	private int empID;
	private String empName;
	private double annualSal;
	private Year joinYear;
	
	//Constructor
	public Employee(int empID, String empName, double sal, Year joinYear) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.annualSal = sal;
		this.joinYear = joinYear;
	} 
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSal() {
		return annualSal;
	}
	public void setSal(double sal) {
		this.annualSal = sal;
	}
	public Year getJoinYear() {
		return joinYear;
	}
	public void setJoinYear(Year joinYear) {
		this.joinYear = joinYear;
	}
	
	public void setEmployeeDetails(int empID, String empName, double sal, Year year)
	{
		setEmpID(empID);
		setEmpName(empName);
		setJoinYear(year);
		setSal(sal);
	}
	
	public void getEmployeeDetails()
	{
		System.out.println("Name: "+getEmpName()+"\nID: "+getEmpID()+"\nJoining Year: "+getJoinYear()+"\nSalary: "+getSal());
	}
	public String getLoanEligility()
	{
		if((Year.now().getValue()-joinYear.getValue())>5)
		{
			if(annualSal==600000)
				return "2 lakhs of loan is granted.";
			else if(annualSal>=1000000 & annualSal<1500000)
				return " 5 lakhs of loan is granted";
			else if(annualSal>=1500000)
				return " 7 lakhs of loan is granted.";
			else
				return "Annual salary should be a minimum of 6 Lakhs";
		}
		return "Loan is granted for employees with 5 years of work experience";
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Employee ID, name and Salary and year of joining:");
		int empID= s.nextInt();
		String empName = s.next();
		double sal=s.nextDouble();
		Year year = Year.of(s.nextInt());
		s.close();
		Employee emp = new Employee(empID,empName,sal,year);
		emp.getEmployeeDetails();
		System.out.println(emp.getLoanEligility());
	}

}
