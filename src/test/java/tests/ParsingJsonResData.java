package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ParsingJsonResData {

	
  // @Test  /// passed
	public void testJsonResponse()
	{
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/students")
		.then()
		.statusCode(200)
		.header("Content-Type","application/json")
		.body("[1].name",equalTo("gajanan"));
		//.log().all();
		
	}
	
	//@Test //passed
	public void testJsonResponse2()
	{
		Response res=given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/students");
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json");
		String stdName =res.jsonPath().get("[2].name").toString();
		Assert.assertEquals(stdName,"ajinkya");
		
	}
	
	@Test
	public void testJsonResponseBodyData()
	{
		Response res=given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:3000/student");
		
		JSONObject jobj=new JSONObject(res.asString());
		boolean status=false;
		
		for(int i=0;i<jobj.getJSONArray("student").length();i++)
		{
			String author=jobj.getJSONArray("book").getJSONObject(i).get("author").toString();
			if(author.equals("gajanan"))
			{
				status=true;
				break;
			}
			Assert.assertEquals(status,true);
			
		}
		
	}
}
