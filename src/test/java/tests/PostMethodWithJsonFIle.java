package tests;
import java.io.File;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class PostMethodWithJsonFIle {
	@Test
	public void postMethod() {
		RestAssured.baseURI = "http://tekschool-test-env.herokuapp.com/";
		// In order to read JSON body from .json file we need to 
		// create object of File class and pass the Json file path 
		File file = new File(".\\src\\main\\java\\resources\\RequestBody.json");
		//String jsonContent = null;
		Response response = given().
				contentType("application/json").
				body(file).
				when().
				post("jpa/users").then().
				assertThat().
				statusCode(200).
				extract().
				response();
		String responseBody = response.asString();
		System.out.println(responseBody);
	}
}