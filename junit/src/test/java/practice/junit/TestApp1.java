/**
 * 
 */
package practice.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author gauravaagarwal
 *
 */
public class TestApp1 {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass1");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass1");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp1");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown1");
	}

	/**
	 * Test method for {@link practice.junit.App#prepareMyBag()}.
	 */
	App app = new App();
	String[] schoolbag = { "Books", "Notebooks", "Pens" };
	@Test
	public void testPrepareMyBag() {
		assertArrayEquals("Unexpected items found in schoolbag",schoolbag, app.prepareMyBag());;
	}
	@Test
	public void testPrepareMyBag2() {
		assertArrayEquals("Unexpected items found in schoolbag",schoolbag, app.prepareMyBag());;
	}
}
