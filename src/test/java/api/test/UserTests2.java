package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.UserPayload;
import io.restassured.response.Response;

public class UserTests2 {
	
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
		
		Response response = UserEndPoints2.createUser(userdata);
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority = 2)
	void testGetUser() {
		
	    Response response = UserEndPoints2.getUser(userdata.getUsername());
	    response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
	
	
	}
	
	@Test(priority = 3)
	void testupdateUser() {
		
	    //updating email and userstatus
		
		userdata.setEmail(faker.internet().safeEmailAddress());
		userdata.setUserStatus(1);
		
		
		
		Response response1 = UserEndPoints2.updateUser(userdata.getUsername(),userdata);
	    response1.prettyPrint();
		Assert.assertEquals(response1.getStatusCode(), 200);
		
		//To verify whether the data is updated
		
		Response response2 = UserEndPoints2.getUser(userdata.getUsername());
		response2.prettyPrint();
	
	
	}
	
	@Test(priority = 4)
	void testDeleteUser() {
		
	    Response response = UserEndPoints2.deleteUser(userdata.getUsername());
	    response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
	
	
	}



}
