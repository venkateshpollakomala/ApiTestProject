package api.endpoints;

/*Swagger URI -->http://petstore.swagger.io
 * 
 * create user (post):http://petstore.swagger.io/v2/user
 * Get User     (Get):http://petstore.swagger.io/v2/user/{userName}
 * Update User (Put):http://petstore.swagger.io/v2/user/{userName}
 * Delete User  (Delete):http://petstore.swagger.io/v2/user/{userName}
 * 
 * 
 * 
 * */

public class Roots {
	public static String base_url="https://petstore.swagger.io/v2";
	
	//Routs of User Module
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{userName}";
	public static String put_url=base_url+"/user/{userName}";
	public static String delete_url=base_url+"/user/{userName}";
	
	//Store module urls
	//Pet modules urls

}
