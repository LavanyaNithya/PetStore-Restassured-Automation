package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {

	
	public static ResourceBundle getProperty()
	{
		
		ResourceBundle p = ResourceBundle.getBundle("URL");      //To read the property file
		return p;
		
	}
	
	public static Response createUser(UserPayload payload)
	{
		
	    String post_url = getProperty().getString("post_url");	    //To get the property value
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		   
		.when()
		   .post(post_url);
	     
	    return response;
		
}
	
	public static Response getUser(String userName)
	{
		
		String get_url = getProperty().getString("get_url");
		Response response = given()
		   .pathParam("username", userName)
		   
		.when()
		   .get(get_url);
		
		return response;
		
	}
	
	public static Response updateUser(String userName,UserPayload payload)
	{
		
		String update_url = getProperty().getString("update_url");
		Response response = given()
		    .contentType(ContentType.JSON)
            .contentType(ContentType.JSON)
            .body(payload)
            .pathParam("username", userName)
            
        .when()
           .put(update_url);
		
		return response;
		
		
	}
	public static Response deleteUser(String userName)
	{
		
		String delete_url = getProperty().getString("delete_url");
		Response response = given()
            .pathParam("username", userName)	
                
        .when()
            .delete(delete_url);
		
		return response;
		
		
		
		
	}
	
	
}
