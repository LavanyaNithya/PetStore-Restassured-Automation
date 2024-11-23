package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserEndPoints {
	
	public static Response createUser(UserPayload userdata)
	{
	    Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(userdata)
		   
		.when()
		   .post(Base.Userposturl);
	     
	    return response;
		
}
	
	public static Response getUser(String userName)
	{
		Response response = given()
		   .pathParam("username", userName)
		   
		.when()
		   .get(Base.Usergeturl);
		
		return response;
		
	}
	
	public static Response updateUser(String userName,UserPayload userdata)
	{
		Response response = given()
		    .contentType(ContentType.JSON)
            .contentType(ContentType.JSON)
            .body(userdata)
            .pathParam("username", userName)
            
        .when()
           .put(Base.Userupdateurl);
		
		return response;
		
		
	}
	public static Response deleteUser(String userName)
	{
		Response response = given()
            .pathParam("username", userName)	
                
        .when()
            .delete(Base.Userdeleteurl);
		
		return response;
		
		
		
		
	}

}
