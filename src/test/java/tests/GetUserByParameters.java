package tests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
public class GetUserByParameters {
	@Test
	public void getUserByParam() {
		RestAssured.baseURI = "http://tekschool-test-env.herokuapp.com/";
		RequestSpecification request = RestAssured.given();
		Response response = request.queryParam("id", "818").
				get("jpa/users/byparam").
				then().
				assertThat().
				statusCode(200).
				header("Server", "Cowboy").
				header("Content-type", "application/json").
				extract().
				response();
		String responseBody = response.asString();
		System.out.println(responseBody);
		JsonPath jsonBodyValidation = response.jsonPath();
		String firstName = jsonBodyValidation.get("firstName");
		String lastName = jsonBodyValidation.get("lastName");
		Assert.assertEquals(firstName, "Bradley");
		Assert.assertEquals(lastName, "Aguilar");
	}
}











