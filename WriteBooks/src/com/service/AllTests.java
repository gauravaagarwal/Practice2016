package com.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestSpringJdbcService.class, TestSpringJdbcService2.class })
public class AllTests {

}
