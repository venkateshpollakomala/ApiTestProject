package api.endpoints;

import static io.restassured.RestAssured.given;



import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//User endpoints .java
//Created for perform create,Read,Update,Delete requests to the endpoints
public class UserendPoints {
	
	
public static Response	createUser(user payload)
	{
		Response response= given()
		 .contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		 .post(Roots.post_url);
		
		return response;
		
	}

public static Response	getUser(String userName)
{
	Response response= given()
			.pathParam("userName", userName)	
	.when()
	 .get(Roots.get_url);
	
	return response;
}

public static Response	updateUser(String userName,user payload)
{
	Response response= given()
	 .contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(payload)
	.pathParam("userName", userName)
	.body(payload)
	.when()
	 .put(Roots.put_url);
	
	return response;
	
}

public static Response deleteUser(String userName)
{
	Response response= given()
	 .pathParam("userName", userName)
	.when()
	 .delete(Roots.delete_url);
	
	return response;
}

}