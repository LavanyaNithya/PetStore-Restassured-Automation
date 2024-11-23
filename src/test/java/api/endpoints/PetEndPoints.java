package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.PetPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	
	public static Response addPet(PetPayload petdata)
	{
	    Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(petdata)
		   
		.when()
		   .post(Base.Petposturl);
	     
	    return response;
		
   }
	
	public static Response getPet(int id)
	{
		Response response = given()
		   .pathParam("petId", id)
		   
		.when()
		   .get(Base.Petgeturl);
		
		return response;
		
	}
	
	public static Response updatePet(PetPayload petdata)
	{
		Response response = given()
		    .contentType(ContentType.JSON)
            .contentType(ContentType.JSON)
            .body(petdata)
            
        .when()
           .put(Base.Petupdateurl);
		
		return response;
		
		
	}
	public static Response deletePet(int id)
	{
		Response response = given()
            .pathParam("petId", id)	
                
        .when()
            .delete(Base.Petdeleteurl);
		
		return response;
		
		
		
		
	}
}
