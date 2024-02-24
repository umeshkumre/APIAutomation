package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.config.LogConfig;

public class HideHeaderInformation {

	public static void main(String[] args) {

		
		given().config(config().logConfig(LogConfig.logConfig().blacklistHeader(DEFAULT_BODY_ROOT_PATH, args)))
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then().log().all().statusCode(200);
	}

}
