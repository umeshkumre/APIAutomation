package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationPojoToJson {
	
	@Test
	public void testSerialization() throws JsonProcessingException
	{
		
		Employee emp=new Employee();
		emp.setEid(111);
		emp.setEname("umesh");
		emp.setElocation("pune");
		emp.setPhoneNo("123456");
		
		//convert java object ot json object(serialization)
		ObjectMapper obj=new ObjectMapper();
		String jsondata=obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println(jsondata);
		
	}

}
