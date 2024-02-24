package tests;

import static io.restassured.RestAssured.given;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.response.Response;



public class ValidateResponseTime {
	
	@Test
	public void testResponseTime()
	{
		Response res=given()
		.param("page",2)
		.auth().none()
		.when()
		.get("https://reqres.in/api/users");
		//.statusCode(200).log().all();
		
		System.out.println("validate Response Time using getTime method is :"+res.getTime());
		System.out.println("validate Response Time using getTimeIn method is:"+res.getTimeIn(TimeUnit.MILLISECONDS));
		System.out.println("validate Response Time using time method is :"+res.time());
		System.out.println("validate Response Time using timeIn method is :"+res.timeIn(TimeUnit.MILLISECONDS));
		
		
		
	}

	
}
