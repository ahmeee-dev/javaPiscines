package edu.ecole42.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import edu.ecole42.numbers.exceptions.IllegalNumberException;

public class NumberWorkerTest {

	@ParameterizedTest
	@ValueSource (ints = {5, 2, 3, 13})
	void  isPrimeForPrimes(int num) {
		NumberWorker numWork = new NumberWorker();
		assertEquals(true , numWork.isPrime(num));
	}

	@ParameterizedTest
	@ValueSource (ints = {4, 6, 123456, 9})
	void isPrimeForNotPrimes(int number) {
		NumberWorker numWork = new NumberWorker();
		assertEquals(false, numWork.isPrime(number));
	}

	@ParameterizedTest
	@ValueSource (ints = {1, 0, -1, 000001})
	void isPrimeForIncorrectNumbers(int num) {
		NumberWorker numWork = new NumberWorker();
		assertThrows(IllegalNumberException.class, () -> { numWork.isPrime(num); });
	}

	@ParameterizedTest
	@CsvFileSource(resources= "/dataTestSumDigits.csv", numLinesToSkip = 1)
	void testSumDigits(int num, int expected) {
		NumberWorker numWork = new NumberWorker();
		assertEquals(expected, numWork.sumDigit(num));
	}
	
}
