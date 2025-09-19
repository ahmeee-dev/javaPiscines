package ex00.app;

import ex00.interfaces.CarClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

// ⚠️ cambia tutti i nextInt in parseInt(nextLine())


public class Program {
	public static void main(String[] args) throws Exception {	
		Class<?> carClass = CarClass.class;
	Class<?>[] classes = carClass.getDeclaredClasses();

	System.out.println("Classes:");
	for (Class item : classes) {
		System.out.println(item.getSimpleName());
	}
	System.out.println("------------");
	System.out.println("Enter Class name");
	Scanner myScan = new Scanner(System.in);
	String searchedClass = myScan.nextLine();
	Class<?> foundClass = Class.forName(searchedClass);
	System.out.println("fields:");
	Field[] fields = foundClass.getDeclaredFields();
	for (Field field : fields) {
		System.out.println(field.getName());
	}
	System.out.println("methods:");
	Method[] methods = foundClass.getDeclaredMethods();
	for (Method item : methods) {
		System.out.println(item);
	}
	System.out.println("-------------");
	System.out.println("Let's create an Object");
	System.out.println("OffRoadCar or UtilityCar ?");
	Class<?> toCreate = Class.forName(myScan.nextLine());
	Constructor<?> constructor = toCreate.getConstructor(); //in this moment is default, now we'll change the private values
	Object instance = constructor.newInstance();
	Field[] instanceFields = instance.getClass().getDeclaredFields();
	for (Field field : instanceFields) {
		if (field.getName().equals("model")) {
			System.out.println("Model:");
			field.setAccessible(true);
			field.set(instance, myScan.nextLine());
		}
		else if (field.getName().equals("brand")) {
			System.out.println("Brand:");
			field.setAccessible(true);
			field.set(instance, myScan.nextLine());
		}
		else if (field.getName().equals("horsepower")) {
			System.out.println("Horsepower:");
			field.setAccessible(true);
			field.set(instance, Integer.parseInt(myScan.nextLine()));
		}
		else if (field.getName().equals("weight")) {
			System.out.println("Weight:");
			field.setAccessible(true);
			field.set(instance, Integer.parseInt(myScan.nextLine()));
		}
	}
	System.out.println("Object created: " + instance.toString());
	System.out.println("-------------");
	System.out.println("Enter field to change:");
	String fieldTochange = myScan.nextLine();
	for (Field field : fields) {
		if (fieldTochange.equals("model")) {
			System.out.println("\tEnter new value:");
			field.setAccessible(true);
			field.set(instance, myScan.nextLine());
		}
		else if (fieldTochange.equals("brand")) {
			System.out.println("\tEnter new value:");
			field.setAccessible(true);
			field.set(instance, myScan.nextLine());
		} else if (fieldTochange.equals("horsepower")) {
			System.out.println("\tEnter new value:");
			field.setAccessible(true);
			field.set(instance, Integer.parseInt(myScan.nextLine()));
		} else if (fieldTochange.equals("weight")) {
			System.out.println("\tEnter new value:");
			field.setAccessible(true);
			field.set(instance, Integer.parseInt(myScan.nextLine()));
		}
	}
	System.out.println("Object updated: " + instance.toString());
	System.out.println("-------------");
	System.out.println("Enter a method to call [ with parameters type es. jump(int) ]");
	String toCall = myScan.nextLine();
	int bracketIndex = toCall.indexOf('(');
	String[] paramsStrings = toCall.substring(bracketIndex + 1, toCall.length() - 1).trim().split(",");
	toCall = toCall.substring(0, bracketIndex);
	Object[] paramValues = new Object[paramsStrings.length];
	Class<?>[] paramTypes = new Class[paramsStrings.length];
	for (int i = 0; i < paramsStrings.length; i++) {
		switch (paramsStrings[i]) {
			case "int":
					paramValues[i] = Integer.parseInt(myScan.nextLine());
					paramTypes[i] = int.class;
			case "String":
					paramValues[i] = myScan.nextLine();
					paramTypes[i] = String.class;
			case "boolean":
					paramValues[i] = Boolean.parseBoolean(myScan.nextLine());
					paramTypes[i] = Boolean.class;
			case "Double":
					paramValues[i] = Double.parseDouble(myScan.nextLine());
					paramTypes[i] = Double.class;
			case "Long":
					paramValues[i] = Long.parseLong(myScan.nextLine());
					paramTypes[i] = Long.class;
		}
	}
	Method method = toCreate.getDeclaredMethod(toCall, paramTypes);
	method.invoke(instance, paramValues);

	myScan.close();
}

}
