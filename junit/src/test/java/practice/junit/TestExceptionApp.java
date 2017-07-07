package practice.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestExceptionApp {

	ExceptionApp app = new ExceptionApp();

	@Test
	public final void testDivide() {
		new ExceptionApp().divide(0, 1);
	}

	@Test
	public final void testDivide2() {
		try {
			app.divide(1, 0);
			fail("ArithmeticException not thrown");
		} catch (ArithmeticException ex) {
			assertEquals("/ by zero", ex.getMessage());
		}

	}

	@Test(expected = ArithmeticException.class)
	public final void testDivide3() {
		app.divide(1, 0);

	}
	@Rule
	public ExpectedException exception = ExpectedException.none(); 

	@Test
	public final void testDivide4() {
		exception.expect(ArithmeticException.class);
		exception.expectMessage("/ by zero");
		app.divide(1, 0);
		app.divide(1, 0);
		app.divide(1, 1);

	}
	
	@Test
	public final void testDivide5() throws Exception {
		exception.expect(ArithmeticException.class);
		exception.expectMessage("/ by zero");
		app.divide2(1, 0);


	}
}
