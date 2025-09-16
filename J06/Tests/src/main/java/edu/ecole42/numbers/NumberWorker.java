package edu.ecole42.numbers;
import edu.ecole42.numbers.exceptions.IllegalNumberException;

public class NumberWorker {
	
	public boolean isPrime(int number) {
		if (number <= 1) {
			throw new IllegalNumberException("Error: Number minor or equal to one");
		}
		for (int i = 2; i < (number/2) + 1; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int sumDigit(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

}
