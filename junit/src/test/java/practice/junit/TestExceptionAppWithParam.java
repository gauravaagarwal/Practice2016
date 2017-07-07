package practice.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith (Parameterized.class)
public class TestExceptionAppWithParam {

	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 { 4, 4, 1 }, { 1, 1 , 1}, { 2, 1, 2 }, { 3, 2,1 }, { 4, 3 , 1}, { 5, 5 ,1}, { 8, 8,1 }  
           });
    }

	ExceptionApp app = new ExceptionApp();
	@Parameter
	public int i;
	@Parameter(1)
	public int j;
	@Parameter(2)
	public int expected;
	@Test
	public final void testDivide() {
		assertEquals(expected,app.divide(i, j));
	}

}
