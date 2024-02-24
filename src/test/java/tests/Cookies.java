package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {
	
	//@Test
	public void testCookie()
	{
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.cookie("AEC","Ae3NU9OCy4oRSuI9lKA9vIOaYAQTD5Z_-IXII0db15x-Ej8e7LRUvOYxlg")
		.log().all();
		
	}
	
	@Test
	public void getCookieInfo()
	{
		Response res=given()
		.when()
		.get("https://www.google.com/");
		
		//get single cookie info
		//String cookiesVal=res.getCookie("AEC"); 
		//System.out.println(cookiesVal);
		
		//get all cookies info
		Map<String, String> cookieValue=res.getCookies();
		//System.out.println(cookieValue.keySet());
		
		for(String k:cookieValue.keySet())
		{
			String cookiesVal=res.getCookie(k);
			System.out.println(k+"--"+cookiesVal);
		}
		
	}

}
