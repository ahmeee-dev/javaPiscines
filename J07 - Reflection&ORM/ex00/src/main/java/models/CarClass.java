package models;

import java.util.StringJoiner;

public interface CarClass {
	
	public int runCar(); //returns a random number of kilometers
	public void honk();
	@Override
	public String toString();


	public class UtilityCar {
	
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

		public int runCar(int min, int max) {
			int kilometeres = (int) (Math.random() * (max - min + 1) + min);
			return kilometeres;
		}

		public void honk() {
			System.err.println("Hooonk");
		}
	}

	public class OffRoadCar {
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
	
		public int runCar(int min, double max) {
			int kilometeres = (int) (Math.random() * (max - min + 1) + min);
			return kilometeres;
		}
	
		public void honk() {
			System.err.println("HOOOONK");
		}
	}
}