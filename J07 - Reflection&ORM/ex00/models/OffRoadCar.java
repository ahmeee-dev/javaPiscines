package ex00.models;

import ex00.interfaces.CarInterface;
import java.util.StringJoiner;

public class OffRoadCar implements CarInterface {
	
	private String model;
	private String brand;
	private int horsepower;
	private int weight;

	public OffRoadCar() {
		this.model = "Renegade[default]";
		this.brand = "Jeep[default]";
		this.horsepower = 100;
		this.weight = 1500;
	}

	public OffRoadCar(String model, String brand, int horsepower, int weight) {
		this.model = model;
		this.brand = brand;
		this.horsepower = horsepower;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return (new StringJoiner (", ", UtilityCar.class.getSimpleName() + " [", "]")
			.add("Model = " + model)
			.add("Brand = " + brand)
			.add("Horsepower = " + horsepower)
			.add("Weight = " + weight)
			.toString());
	}

	@Override
	public int runCar() {
		int min = 100;
		int max = 25000;
		int kilometeres = (int) (Math.random() * (max - min + 1) + min);
		return kilometeres;
	}

	@Override
	public void honk() {
		System.err.println("HOOOONK");
	}
}