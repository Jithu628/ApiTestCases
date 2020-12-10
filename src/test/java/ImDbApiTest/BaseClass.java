package ImDbApiTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	public Response setup() {
		
		RestAssured.baseURI="http://www.omdbapi.com";
		RequestSpecification httprequest=RestAssured.given();
		Response response = httprequest.request(Method.GET,"/?t=A+star+is+born&y=2018&apikey=c16aa54d");
		return response;
	}

	
}
