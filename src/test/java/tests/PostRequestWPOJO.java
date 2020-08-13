package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import resources.RequestBodyPOJO;
import resources.ResponseValidation;
public class PostRequestWPOJO {
	@Test
	public void postRequest() {
	RestAssured.baseURI = "http://tekschool-test-env.herokuapp.com/";	
	// create POJO request obj and pass values;
	RequestBodyPOJO requestBody = new RequestBodyPOJO("John", "Wick", null, null, null, null, null, null, null, null);
	Response response = given().
			contentType("application/json").
			body(requestBody).
			when().
			post("jpa/users");
	int responseCode = response.getStatusCode();
	Assert.assertEquals(responseCode, 200);
	// ResponseBody interface will store all properties of response from this request as a body 
	// Then we create a java class with JSON keys as a string and using the ResponseBody interface 
	// we deserialize the response bytes to Java object. 
	@SuppressWarnings("rawtypes")
	ResponseBody body = response.body();
	// create obj of Response Validation class
	ResponseValidation responseBody = body.as(ResponseValidation.class);
	// we will deserialize the response body and write assertions
	Assert.assertEquals("John",responseBody.firstName);
	Assert.assertEquals("Wick",responseBody.lastName);
	System.out.println(response.body().asString());
	}
}