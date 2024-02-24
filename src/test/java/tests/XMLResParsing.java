package tests;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class XMLResParsing {
	
	//@Test
	public void testXmlResponse()
	{
		given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		.statusCode(200)
		.header("Content-Type","application/xml; charset=utf-8")
		//.body("TravelerinformationResponse.page",equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation.email[0]",equalTo("Developer12@gmail.com"));
	}
	
	//@Test
	public void testXmlResponse2()
	{
		Response res=given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
		
		String pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo,"1");
		
		String Email=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation.email[0]").toString();
		Assert.assertEquals(Email,"Developer12@gmail.com");
		
		
	}
	
	@Test
	public void testXMLResponseBody()
	{
		Response res=given()
				.when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		  XmlPath path=new XmlPath(res.asString());
		 List<String> travellist= path.getList("TravelerinformationResponse.travelers.Travelerinformation");
		 Assert.assertEquals(travellist.size(), 10);
		 
		 List<String> travelerEmail= path.getList("TravelerinformationResponse.travelers.Travelerinformation.email");
		  boolean status=false;
		 for(String trEmail:travelerEmail)
		 {
			 if(trEmail.equals("Developer12@gmail.com"))
			 {
				 status=true;
				 break;
			 }
		 }
		 Assert.assertEquals(status,true);
		 
	}

}
