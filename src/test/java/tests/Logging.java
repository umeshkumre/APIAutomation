package tests;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Logging {
	
	@Test
	public void testLog()
	{
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		//.log().body();
		//.log().cookies();
		//.log().headers();
	   // .log().ifStatusCodeIsEqualTo(200);
		.log().all();
		
		
	
	}

}
