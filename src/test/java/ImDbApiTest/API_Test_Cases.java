package ImDbApiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_Test_Cases extends BaseClass {

	Response response = setup();	
	String responseBody=response.getBody().asString();
	@Test(priority=1)
	void API_Verification() {
		int Statuscode=response.getStatusCode();
		String StatusLine= response.getStatusLine();
		Assert.assertEquals(StatusLine, "HTTP/1.1 200 OK");
	    Assert.assertEquals(Statuscode, 200);
	}
	@Test(priority=2)
	void API_TC_01() {
		Assert.assertEquals(response.jsonPath().get("Response"), "True");	
	}
	@Test (priority=3)
	void API_TC_02() {
		
		Assert.assertNotEquals(response.jsonPath().get("Response"), "False");
		Assert.assertEquals(responseBody.contains("Error"),false);
	}
	@Test (priority=4)
	void API_TC_03() {
		Assert.assertEquals(response.jsonPath().get("Year"), "2018");
	}
	@Test(priority=5)
	void API_TC_04() {
		Assert.assertEquals(responseBody.contains("Bradley"),true);
	}
	@Test(priority=6)
	void API_TC_05() {
		long responseTime=response.getTime();
		Assert.assertEquals(responseTime<300L, true);
	}
	@Test(priority=7)
	void API_TC_07() {
		String contentType=response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}
	
}
