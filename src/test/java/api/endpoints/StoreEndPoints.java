package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.StorePayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	public static Response createOrder(StorePayload orderdata)
	{
	    Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(orderdata)
		   
		.when()
		   .post(Base.Storeposturl);
	     
	    return response;
		
   }
	
	public static Response getOrder(int id)
	{
		Response response = given()
		   .pathParam("orderId", id)
		   
		.when()
		   .get(Base.Storegeturl);
		
		return response;
		
	}
	
	
	public static Response deleteorder(int id)
	{
		Response response = given()
            .pathParam("orderId", id)	
                
        .when()
            .delete(Base.Storedeleteurl);
		
		return response;
		
		
		
		
	}

}
