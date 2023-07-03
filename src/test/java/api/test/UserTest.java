package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserendPoints;
import api.payload.user;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	user userPayload;
	public Logger loger;
	@BeforeClass
	public void setupData() {
		faker=new Faker();
		userPayload=new user();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		loger=LogManager.getLogger(this.getClass());
	}

	@Test(priority=1)
	public void testPostUser()
	{
		loger.info("*****************Creating User*****************");
		Response response=UserendPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		loger.info("*****************User is created*****************");

	}
	@Test(priority=2)
	public void getuserByName() 
	{
		loger.info("*****************Get user*****************");

	Response response = UserendPoints.getUser(this.userPayload.getUsername());	
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	
	loger.info("*****************User data is displayed in consol *****************");

	}
	
	@Test(priority=3)
	public void updatetheUser() {
		loger.info("*****************Updating User*****************");

		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		Response response=UserendPoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Checking the data after update
		Response responseAfterUpdate = UserendPoints.getUser(this.userPayload.getUsername());	
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
		loger.info("*****************User data successfully updated*****************");

		
	}
	@Test(priority=4)
	public void deleteuser() {
		
		loger.info("*****************Delete User*****************");

		 Response response = UserendPoints.deleteUser(this.userPayload.getUsername());
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
			loger.info("*****************User is successfully deleted*****************");

	}
}
