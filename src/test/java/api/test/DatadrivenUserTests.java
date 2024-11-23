package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.UserPayload;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DatadrivenUserTests {
	
	@Test(priority =1 ,dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String id, String username, String firstname,String lastname,String email,String password,String phone,String userstatus)
	{

		UserPayload userdata = new UserPayload();         //POJO class Object
		
		userdata.setId(Integer.parseInt(id));            //Passing the data from dataprovider class
		userdata.setUsername(username);
		userdata.setFirstName(firstname);
		userdata.setLastName(lastname);
		userdata.setEmail(email);
		userdata.setPassword(password);
		userdata.setPhone(phone);
		userdata.setUserStatus(Integer.parseInt(userstatus));
		
		
		Response response = UserEndPoints.createUser(userdata);
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		}
	
	
	@Test(priority = 2 ,dataProvider = "Usernames",dataProviderClass = DataProviders.class)
	public void testGetUser(String username)
	{
		Response response = UserEndPoints.getUser(username);
	    response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 3 ,dataProvider = "Usernames",dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username)
	{
		Response response = UserEndPoints.deleteUser(username);
	    response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	
	
}
  