package com.brightpattern.testcases;

import org.testng.annotations.Test;

public class AssertTest extends API {

	@Test
	public void DimaAssert(String[] args) {
		String expected = "dima";
		String actual = "dima";
		assertNotNull(expected, actual);
	}

}
