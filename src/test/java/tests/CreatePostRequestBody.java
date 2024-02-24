 package tests;

import org.json.JSONObject;

import org.json.JSONTokener;

import tests.PostReqUsingPojo;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CreatePostRequestBody {
	
 //	@Test(priority=1)
	public void testPostUsingHashMap()
	{
		LinkedHashMap data=new LinkedHashMap();
		data.put("name","Mayur");
		data.put("location","Wani");
		data.put("phone","12345678");
		
		String courseArr[]= {"javascript","php"};
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name",equalTo("Mayur"))
		.body("location",equalTo("Wani"))
		.body("phone",equalTo("12345678"))
		.body("courses[0]",equalTo("javascript"))
		.body("courses[1]",equalTo("php"))
		.header("Content-Type","application/json")
		.log().all();
	}
	
	@Test(priority=2)
	public void testDelete()
	{
		given()
		.when()
		.delete("http://localhost:3000/students/4")
		.then()
		.statusCode(404);
	}
	
	//@Test(priority=1)
	public void testPostUsingJsonLibrary()
	{
		JSONObject data=new JSONObject();
		data.put("name","aditya");
		data.put("location","yawatmal");
		data.put("phone","992221128");
		
		String courseArr[]= {"nodejs","python"};
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name",equalTo("aditya"))
		.body("location",equalTo("yawatmal"))
		.body("phone",equalTo("992221128"))
		.body("courses[0]",equalTo("nodejs"))
		.body("courses[1]",equalTo("python"))
		.header("Content-Type","application/json")
		.log().all();
	}
	
	//@Test
	public void testPostUsingPoJo() {
		
		PostReqUsingPojo pojo=new PostReqUsingPojo();
		pojo.setName("umesh");
		pojo.setLocation("chandrapur");
		pojo.setPhone("9876542");
		String courseArr[]= {"java","python"};
		pojo.setCourses(courseArr);
	
		given()
		.contentType("application/json")
		.body(pojo)
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name",equalTo("umesh"))
		.body("location",equalTo("chandrapur"))
		.body("phone",equalTo("9876542"))
		.body("courses[0]",equalTo("java"))
		.body("courses[1]",equalTo("python"))
		.header("Content-Type","application/json")
		.log().all();
		}
	
	@Test
	public void testPostUsingExternalJson() throws IOException {
		
		File f=new File("C:\\Users\\gnsan\\eclipse-workspace\\ApiAutomationUsingRest-Assured\\DATA1.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);//
		JSONObject data=new JSONObject(jt);
	// A JSONTokener takes a source string and extracts characters and tokens from it. 
	// It is used by the JSONObject and JSONArray constructors to parse JSON source strings.
		
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("http://localhost:3000/students")
		.then()
		.statusCode(201)
		.body("name",equalTo("ajay"))
		.body("location",equalTo("wardha"))
		.body("phone",equalTo("12345"))
		.body("courses[0]",equalTo("csharp"))
		.body("courses[1]",equalTo("ruby"))
		.header("Content-Type","application/json")
		.log().all();
		}
	
	
	
	

}
