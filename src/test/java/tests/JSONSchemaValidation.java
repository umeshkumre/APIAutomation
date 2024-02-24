package tests;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;


public class JSONSchemaValidation {
	
	@Test
	public void testJSONSchemaValidation()
	{
		given()
		.when()
		.get("http://localhost:3000/students")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("DataJSONSchema.json"));
	}

}
