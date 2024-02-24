package authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Outh2Authentication {
	@Test
	public void testOuth2Authentication()
	{

		given()
		.auth()
		.oauth2("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")// outh2 requires only access token
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().all();
	}

}
