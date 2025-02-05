package oops;
import utils.Constants;
public class Car {
//	Make all properties private
	private String make;
	private String model;
	private int year;
//	Getter method for Make
	public String getMake() {
		return make;
	}
//	Setter method for Make of the car
	public void setMake(String make) {
		this.make = make;
	}
//	Getter method for  model variable
	public String getModel() {
		return model;
	}
//	Setter method for model variable
	public void setModel(String model) {
		this.model = model;
	}
//	Getter method for year variable
	public int getYear() {
		return year;
	}
//	Setter method for year variable
	public void setYear(int year) {
		this.year = year;
	}
//	non-static method to start an engine
	void startEngine()
	{
		System.out.println(Constants.START_ENGINE);
	}
}
