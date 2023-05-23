package testNGInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InterviewQuestions {
	//@Test(retryAnalyzer = RetryExample.class)
	@Test
	public void testcase() {
		Assert.assertEquals(true, false);
	}
	@Test
	public void testcase1() {
		Assert.assertEquals(true, false);
	}
	
	@Test
	public void testcase2() {
		Assert.assertEquals(true, true);
	}
}
