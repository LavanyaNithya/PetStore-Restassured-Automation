package api.endpoints;

public class Base {
	
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	//User module
	
	public static String Userposturl = baseUrl+"/user";
	public static String Usergeturl = baseUrl+"/user/{username}";       //username is a path parameter
	public static String Userupdateurl = baseUrl+"/user/{username}";
	public static String Userdeleteurl = baseUrl+"/user/{username}";
	
	
	//Pet module
	
	public static String Petposturl = baseUrl+"/pet";
	public static String Petgeturl = baseUrl+"/pet/{petId}";
	public static String Petupdateurl = baseUrl+"/pet";
	public static String Petdeleteurl = baseUrl+"/pet/{petId}";
	
	
	//Store module
	
	public static String Storeposturl = baseUrl+"/store/order";
	public static String Storegeturl = baseUrl+"/store/order/{orderId}";
	public static String Storedeleteurl = baseUrl+"/store/order/{orderId}";
	
	
	
	
	
	

}
