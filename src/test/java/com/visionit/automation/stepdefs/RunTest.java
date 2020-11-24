package com.visionit.automation.stepdefs;

import org.junit.Assert;
import org.junit.Test;

public class RunTest {
	@Test
	public void t_01_test_case_is_failed(){
		System.out.println("This test case supposed to be failed");
		Assert.assertEquals("Test assertion is failed", true, false);
	}
	
	@Test
	public void t_02_test_case_is_passed(){
		System.out.println("This test case supposed to be passed");
		Assert.assertEquals("Test assertion is passed", true, true);
	}

}
