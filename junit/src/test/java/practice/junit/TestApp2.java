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
public class TestApp2 {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass2");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass2");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp2");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown2");
	}
	App app = new App();
	String[] schoolbag = { "Books", "Notebooks", "Pens" , "Pencils"};
	/**
	 * Test method for {@link practice.junit.App#addPencils()}.
	 */
	@Test
	public final void testAddPencils() {
		assertArrayEquals("Unexpected items found in schoolbag",schoolbag, app.addPencils());;
	}

	@Test
	public final void testAddPencils2() {
		assertArrayEquals("Unexpected items found in schoolbag",schoolbag, app.addPencils());;
	}
}
