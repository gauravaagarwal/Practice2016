package practice.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith (Parameterized.class)
public class TestExceptionAppWithParam2 {

	/*@Parameters
	public static Collection<Object> data1() {
        return  Arrays.asList(new Object[]{ 4, 4, 1 }) ;
    }
	
	@Parameters
	public static Collection<Object> data2() {
        return  Arrays.asList(new Object[]{ 4, 4, 1 }) ;
    }*/
	
	@Parameters(name = "{index}: divide({0},{0})=1")
	public static Integer[] data() {
        return  new Integer[]{ 4, 4, 1 } ;
    }

	ExceptionApp app = new ExceptionApp();
	@Parameter
	public int i;

	public int expected=1;
	@Test
	public final void testDivide() {
		assertEquals(expected,app.divide(i, i));
	}

}
