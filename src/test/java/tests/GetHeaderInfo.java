package tests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetHeaderInfo {

	@Test
	public void testHeaderInfo()
	{
		 given()
		.when()
		.get("https://www.google.com/")
		.then()
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.and()
		.header("Server","gws")
		.and()
		.header("Content-Encoding","gzip");
		
	}
	
	@Test
	public void getHeaderInfo()
	{
		 Response res=given()
		.when()
		.get("https://www.google.com/");

          String headerVal=res.getHeader("Content-Type");
          System.out.println("Header value is :"+headerVal);
          System.out.println("========================================");
          
         Headers header= res.getHeaders();
         System.out.println("Headers value is : "+header);
         System.out.println("=========================================");
         
         for(Header head:header)
         {
        	 System.out.println(head.getName()+"--"+head.getValue());
         }
		
		

	}
	
	
}
