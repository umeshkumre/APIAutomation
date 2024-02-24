package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ApiKeyAuthentication {
	@Test
	public void testApiKeyAuth()
	{
		given()
		.queryParam("appid","feqc5dd7e01d74764611c3fc9eaf2c")
        .when()
        .get("https://api.openweathermap.og/data/2.5/forecast/daily?q=delhi&units=metric&cnt=7")
        .then()
        .statusCode(200)
        .log().all();
	}
	
	//@Test
	public void testApiKeyAuth2()
	{
		given()
		.queryParam("","")
		.pathParam("","")
		.queryParam("","")
        .when()
        .get("")
        .then()
        .log().all();
	}

	
}
