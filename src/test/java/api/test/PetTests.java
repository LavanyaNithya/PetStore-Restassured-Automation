package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints;
import api.payload.PetPayload;
import io.restassured.response.Response;

public class PetTests {
	
	Faker faker;
	PetPayload petdata;       
	
	@BeforeClass
	public void setUpData()
	{
		faker = new Faker();
		petdata = new PetPayload();
		petdata.setId(1);
		petdata.setName(faker.name().firstName());
		petdata.setStatus("available");
		
	}
	
	@Test(priority = 1)
	void testAddPet()
	{
		
		Response response = PetEndPoints.addPet(petdata);
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2)
	void testGetPet() {
		
	    Response response = PetEndPoints.getPet(petdata.getId());
	    response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 3)
	void testupdatePet() {
		
	    //updating petstatus
	
		petdata.getId();
		petdata.getName();
		petdata.setStatus("sold");
		
		
		
		Response response1 = PetEndPoints.updatePet(petdata);
	    response1.prettyPrint();
		Assert.assertEquals(response1.getStatusCode(), 200);
	
	
	}
	
	@Test(priority = 4)
	void testDeletePet() {
		
	    Response response = PetEndPoints.deletePet(petdata.getId());
	    response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
	
	
	}


}
