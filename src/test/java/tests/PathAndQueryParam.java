package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQueryParam {
	
	@Test
	public void testQueryAndPathParam()
	{
		given()
		.pathParam("path","users")
		.queryParam("page",2)
		.queryParam("id",5)
		.when()
		.get("https://reqres.in/api/{path}")
		.then()
		//.log().ifError().assertThat().statusCode(200);
		.statusCode(200).log().all();
	}
	


}
