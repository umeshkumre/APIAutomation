package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BearerTokenAuth {
	
	@Test
	public void testBearerToken()
	{
	String bearerToken="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";
	given()
	.header("Authorization","Bearer"+bearerToken)
	.when()
	.get("https://api.github.com/user/repos")
	.then()
	.statusCode(401)
	.log().all();
	

	}
}
