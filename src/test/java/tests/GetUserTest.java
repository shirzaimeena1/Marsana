package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class GetUserTest {
	@Test
	public void getUser() {
		// providing URI for Rest Services or we specify the base url for this Request
		RestAssured.baseURI = "http://tekschool-test-env.herokuapp.com/";
		// Response Interface of Rest Assured Library to get response of request and
		// write asssertions.
		Response response = given().
				when().
				get("jpa/users/818"). // method type
				then().assertThat(). // then and following then we can start writing our assertions.
				statusCode(200).
				header("Server", "Cowboy").
				header("Content-Type", "application/json").
				extract(). // after																							// extract().response
				response();
		// This line of code will store Response body as string
		String responseBody = response.getBody().asString();
		// this line of code will return status code and stored in int data type
		int statusCode = response.getStatusCode();
		String Serverheader = response.getHeader("Server");
		String ContentType = response.getHeader("Content-Type");
		Assert.assertEquals(Serverheader, "Cowboy");
		Assert.assertEquals(ContentType, "application/json");
		Headers allHeaders = response.headers();
		for (Header header : allHeaders) {
			System.out.println(" Key " + header.getName() + " Value " + header.getValue());
		}
		System.out.println(responseBody);
		System.out.println(statusCode + "     was status code from response");
		System.out.println(Serverheader);
		System.out.println(ContentType);
		// we will use JasonPath class to get values of Json Response and then write
		// assertions to validate response body.
		JsonPath jsonBodyValidation = response.jsonPath();
		String firstName = jsonBodyValidation.get("firstName");
		String lastName = jsonBodyValidation.getString("lastName");
		String middleName = jsonBodyValidation.getString("middleName");
		String title = jsonBodyValidation.getString("title");
		String employmentStatus = jsonBodyValidation.getString("employmentStatus");
		Assert.assertEquals(firstName, "Bradley");
		Assert.assertEquals(lastName, "Aguilar");
		Assert.assertEquals(middleName, "Yvonne");
		Assert.assertEquals(title, "Ms");
		Assert.assertEquals(employmentStatus, "Student");
		// verify each value of lastname, middleName, title, employment stats,
		// maritalStatus
	}
}