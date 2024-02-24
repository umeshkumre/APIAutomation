package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FileUploadAndDownlod {

	@Test
	public void testSingleFIleUpload()
	{
		File myfile=new File("file.txt");
		
		given()
		.multiPart("file",myfile)
		.contentType("multipart/form-data")
		.when()
		.post("https://localhost:8080/uploadFile")
		.then()
		.statusCode(200)
		.body("fileName",equalTo("file.txt"))
		.log().all();
	
	}
	
	
	@Test
	public void testMultipleFIleUpload()
	{
		File file1=new File("file1.txt");
		File file2=new File("file2.txt");
		
		given()
		.multiPart("files",file1).multiPart("files",file2)
		.contentType("multipart/form-data")
		.when()
		.post("https://localhost:8080/uploadMultipleFiles")
		.then()
		.statusCode(200)
		.body("[0].fileName",equalTo("file1.txt"))
		.body("[1].fileName",equalTo("file2.txt"))
		.log().all();
	
	}
}
