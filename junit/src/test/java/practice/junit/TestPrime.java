package practice.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)
public class TestPrime {

	@Before
	public void setUp() throws Exception {
	}
	@Parameters(name = "{index}: prime({0})")
	public static Integer[] data(){
		return new Integer[]{4,6,8,9,10,12,14,16,18,20,21,24,26,27,28,30,32,33,34,35,36,38,39,40};
	}
	
	@Parameter
	public int number;
	
	@Test
	public void testCheckPrime() {
		assertFalse(new Prime().checkPrime(number));
	}

}
