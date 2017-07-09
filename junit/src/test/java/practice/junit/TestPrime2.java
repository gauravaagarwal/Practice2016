package practice.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)
public class TestPrime2 {

	@Before
	public void setUp() throws Exception {
	}
	@Parameters(name = "{index}: prime({0})")
	public static Integer[] data(){
		return new Integer[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73};
	}
	
	@Parameter
	public int number;
	
	@Test
	public void testCheckPrime() {
		assertTrue(new Prime().checkPrime(number));
	}

}
