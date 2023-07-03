package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Utilities.DataProviders;
import api.endpoints.UserendPoints;
import api.payload.user;
import io.restassured.response.Response;

public class DDTests {

	Faker faker;
	user userPayload;
	public Logger loger;		
			
	@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String UserID, String userName,String fname,String lname,String useremail,String pwd,String phone)
	
	{
		
		user userPayload=new user();
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		
		loger=LogManager.getLogger(this.getClass());
				
		Response response = UserendPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		loger.info("*****************Creating User*****************");
	}
	
	
	@Test(priority=3, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void deleteUser(String userName )
	{
		
		loger.info("*****************Get User*****************");
		Response response = UserendPoints.deleteUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		loger.info("*****************User Data is displayed*****************");
	}
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProviders.class)
	public void getUserByName(String userName)
	{
		loger.info("*****************Delete User*****************");
		Response response = UserendPoints.getUser(userName);
	  response.then().log().all();
	  Assert.assertEquals(response.getStatusCode(), 200);
	  loger.info("*****************User is Successfully Deleted*****************");
	}
	
}
