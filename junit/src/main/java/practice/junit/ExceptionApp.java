package practice.junit;

public class ExceptionApp {
	
	public int divide (int i, int j){
		return i/j;
	}

	public int divide2 (int i, int j) throws Exception {
		return i/j;
	}
}
