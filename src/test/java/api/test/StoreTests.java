package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.StoreEndPoints;
import api.payload.StorePayload;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class StoreTests {
	
	StorePayload orderdata;     
	
	@BeforeClass
	public void setUpData()
	{
	    orderdata = new StorePayload();
	    orderdata.setId(1);
	    orderdata.setPetId(1);
	    orderdata.setQuantity(1);
	    orderdata.setShipDate("2024-10-04T10:40:49.517Z");
	    orderdata.setStatus("placed");
	    orderdata.setComplete(true);
		
	}
	
	@Test(priority = 1)
	void testCreateOrder()
	{
		
		Response response = StoreEndPoints.createOrder(orderdata);
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2)
	void testGetOrder() {
		
	    Response response = StoreEndPoints.getOrder(orderdata.getId());
	    response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storedataSchema.json"));
	
	
	}
	
	
	@Test(priority = 3)
	void testDeleteOrder() {
		
	    Response response = StoreEndPoints.deleteorder(orderdata.getId());
	    response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
	
	
	}	

}
