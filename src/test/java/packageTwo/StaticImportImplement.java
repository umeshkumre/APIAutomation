package packageTwo;

import static packageOne.StaticImportExample1.*;

import static io.restassured.RestAssured.*;

public class StaticImportImplement {

	public static void main(String[] args) {

		//Approch 1
	//	StaticImportExample1.methodTwo();// here static method access by using  classname
	
		// Approach 2 -we need to import package as static so that we dont required classname to access.without using clasname u can access
	//	methodTwo();
		//methodThree();
		
		//RestAssured.given()- without static import
		//given();
		
		given().param("page",2).auth().none()
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.statusCode(200)
		
		.log().all();
		
		
		
	}

}
