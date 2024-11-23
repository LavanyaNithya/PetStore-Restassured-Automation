package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.UserPayload;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class UserTests{
	
	Faker faker;
	UserPayload userdata;       //POJO class
	
	@BeforeClass
	public void setUpData()
	{
		faker = new Faker();
		userdata = new UserPayload();
		userdata.setId(faker.idNumber().hashCode());
		userdata.setUsername(faker.name().username());
		userdata.setFirstName(faker.name().firstName());
		userdata.setLastName(faker.name().lastName());
		userdata.setEmail(faker.internet().safeEmailAddress());
		userdata.setPassword(faker.internet().password(5,10));
		userdata.setPhone(faker.phoneNumber().cellPhone());
		userdata.setUserStatus(0);
		
	}
	
	@Test(priority = 1)
	void testPostUser()
	{
		
		Response response = UserEndPoints.createUser(userdata);
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority = 2)
	void testGetUser() {
		
	    Response response = UserEndPoints.getUser(userdata.getUsername());
	    response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("userdataSchema.json"));
	
	
	}
	
	@Test(priority = 3)
	void testupdateUser() {
		
	    //updating email and userstatus
		
		userdata.setEmail(faker.internet().safeEmailAddress());
		userdata.setUserStatus(1);
		
		
		
		Response response1 = UserEndPoints.updateUser(userdata.getUsername(),userdata);
	    response1.prettyPrint();
		Assert.assertEquals(response1.getStatusCode(), 200);
		
		//To verify whether the data is updated
		
		Response response2 = UserEndPoints.getUser(userdata.getUsername());
		response2.prettyPrint();
	
	
	}
	
	@Test(priority = 4)
	void testDeleteUser() {
		
	    Response response = UserEndPoints.deleteUser(userdata.getUsername());
	    response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
	
	
	}

}
