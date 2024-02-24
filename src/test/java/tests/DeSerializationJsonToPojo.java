package tests;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class DeSerializationJsonToPojo {
	
	@Test
	public void testDeserializatiojn() throws JsonMappingException, JsonProcessingException
	{
		String jsondata="{\r\n"
				+ "  \"eid\" : 111,\r\n"
				+ "  \"ename\" : \"umesh\",\r\n"
				+ "  \"elocation\" : \"pune\",\r\n"
				+ "  \"phoneNo\" : \"123456\"\r\n"
				+ "}";
		//Convert json to pojo (Deserialization)
      ObjectMapper objMapper=new ObjectMapper();
      Employee empPojo=objMapper.readValue(jsondata,Employee.class);
      System.out.println("Emp Id: "+empPojo.getEid());
     System.out.println("Emp Name: "+empPojo.getEname()); 
      System.out.println("Emp location: "+empPojo.getElocation());
      System.out.println("Emp Phone number: " +empPojo.getPhoneNo());
	}

}
