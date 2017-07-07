package practice.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestApp1.class, TestApp2.class, TestExceptionApp.class })
public class AllTests {

}
