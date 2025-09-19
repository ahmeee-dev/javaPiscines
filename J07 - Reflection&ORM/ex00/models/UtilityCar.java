package ex00.models;

import ex00.interfaces.CarInterface;
import java.util.StringJoiner;

public class UtilityCar implements CarInterface {
	
	private String model;
	private String brand;
	private int horsepower;
	private int weight;

	public UtilityCar() {
		this.model = "Camry[default]";
		this.brand = "Toyota[default]";
		this.horsepower = 35;
		this.weight = 1000;
	}

	public UtilityCar(String model, String brand, int horsepower, int weight) {
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
		int min = 25;
		int max = 1000;
		int kilometeres = (int) (Math.random() * (max - min + 1) + min);
		return kilometeres;
	}

	@Override
	public void honk() {
		System.err.println("Hooonk");
	}
}