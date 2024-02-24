package tests;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SerializationDeserilization {
	
	@Test
	public void convertPojoToJSon() throws JsonProcessingException
	{
		//created java object using pojo classes
		Student studPojo=new Student();//pojo
	
		studPojo.setName("umesh");
		studPojo.setLocation("chandrapur");
		studPojo.setPhone("1234567");
		String courseArr[]={"java","selenium"};
		studPojo.setCourses(courseArr);
		
		//convert java obj to json obj is called as serialization
		ObjectMapper obm=new ObjectMapper();
		String jsondata=obm.writerWithDefaultPrettyPrinter().writeValueAsString(studPojo);
		System.out.println(jsondata);
	}
	
	@Test
	public void convertJsonToPojo() throws JsonMappingException, JsonProcessingException
	{
		String jsonData="{\r\n"
				+ "  \"name\" : \"umesh\",\r\n"
				+ "  \"location\" : \"chandrapur\",\r\n"
				+ "  \"phone\" : \"1234567\",\r\n"
				+ "  \"courses\" : [ \"java\", \"selenium\" ]\r\n"
				+ "}";
		
		// convert json data to pojo object
		ObjectMapper objMapper=new ObjectMapper();
		Student studPojo=objMapper.readValue(jsonData,Student.class);
		System.out.println(studPojo.getName());
		System.out.println(studPojo.getLocation());
		System.out.println(studPojo.getPhone());
		System.out.println(studPojo.getCourses()[0]);
		System.out.println(studPojo.getCourses()[1]);
		
		
		
	}

}
