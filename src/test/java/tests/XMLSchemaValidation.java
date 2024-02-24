package tests;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XMLSchemaValidation {
	
	@Test
	public void testXmlSchemaVAlidation()
	{
		given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("output.xsd"));

	}

}
