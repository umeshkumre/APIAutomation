package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class HttpRequest {
	
	int id;
	
	@Test(priority=1)
	public void getUsers()
	{
		
		given()
		.when()
		  .get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	}
	
	@Test(priority=1)
	public void createUser()
	{
		HashMap data=new HashMap();
		data.put("name","umesh");
		data.put("job","Tester");
		
		id=given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		//.then()
		//.statusCode(201).log().all();
	}
	
	@Test(priority=2,dependsOnMethods= {"createUser"})
	public void updateUser()
	{
		HashMap data=new HashMap();
		data.put("name","Gajanan");
		data.put("job","Developer");
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.put("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(200).log().all();
	}
	
	@Test(priority=4)
	public void deleteUser()
	{
		given()
		.when()
		.get("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(404)
		.log().all();
				
	}

	

}
