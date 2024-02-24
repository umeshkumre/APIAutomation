package apiChaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
	
	@Test
	public void createUser()
	{
		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender","male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken="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";
 
		int id=given()
				.headers("Authorization","Bearer "+bearerToken)
				.contentType("application/json")
				.body(data.toString())
				.when()
				.post("https://gorest.co.in/public/v2/users")
				.jsonPath().getInt("id");
		  System.out.println("Generate id is:"+id);
	}
    
	
	

}
