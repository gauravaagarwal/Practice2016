package practice.junit;

public class Prime {

	public static boolean checkPrime(long number) {
		if (number == 2 || number == 3)
			return true;
		if (number % 2 == 0 || number % 3 == 0)
			return false;

		int divisor = 5;
		int incrementor = 2;
		// works from 25 onwards
		while (divisor * divisor <= number) {
			if (number % divisor == 0)
				return false;
			divisor += incrementor;
			incrementor = 6 - incrementor;
		}
		return true;
	}

	public static void printPrime(int limit) {
		for (int i = 2; i <= limit; i++) {
			if (checkPrime(i)) {
				System.out.println("Prime number: " + i);
			}
		}
	}
	
	public static void main(String[] args) {
		printPrime(100);
	}
	
	public static boolean primeCheck(int number){
		if (number==2||number==3){
			return true;
		}
		if (number%2==0||number%3==0){
			return false;
		}
		int divisor = 5;
		int incrementor=2;
		while (divisor*divisor >= number){
			if (number%divisor==0) return false;
			divisor+=incrementor;
			incrementor = 6-incrementor;
		}
		return true;
	}
}
