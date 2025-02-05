package oops;

import utils.Constants;

public class ElectricCar extends Car {
//	non-static variable for range of the battery
	int batteryRange;

//	Method to charge a battery
	public void chargeBattery() {
		System.out.println(Constants.CHARGE_BATTERY);
	}

	public static void main(String[] args) {
//Create objects for classes Car and ElectricCar and store as an array
		Car[] cars = new Car[4];

		cars[0] = new Car();
		cars[1] = new ElectricCar();
		cars[2] = new Car();
		cars[3] = new ElectricCar();
// Loop to call startEngine() on each object
		for (Car car : cars) {
			car.startEngine();
		}
	}
}
