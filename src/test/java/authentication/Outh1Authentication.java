package authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Outh1Authentication {
	
	@Test
	public void testOuth1Auth()
	{
		given()
		.auth()
		.oauth("consumerKey", "consumerSecret", "accessToken","TokenSecret")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().all();
	}

}
