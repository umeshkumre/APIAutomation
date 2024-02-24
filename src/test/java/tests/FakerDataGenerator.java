package tests;

import org.testng.annotations.Test;


import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FakerDataGenerator {
	
	@Test
	public void testFakerData()
	{
		Faker faker=new Faker();
		String firstName=faker.name().firstName();
		String lastName=faker.name().lastName();
		String fullName=faker.name().fullName();
		
		String userName=faker.name().username();
		String password=faker.internet().password();
		
		String phoneNo=faker.phoneNumber().cellPhone(); 
		String email=faker.internet().emailAddress();
		
		System.out.println("Firstname :-"+firstName);
		System.out.println("Lastname:-"+lastName);
		System.out.println("Fullname:-"+fullName);
		System.out.println("Username:-"+userName);
		System.out.println("password:-"+password);
		System.out.println("phoneNo:-"+phoneNo);
		System.out.println("Emailddress:-"+email);
	}

}
