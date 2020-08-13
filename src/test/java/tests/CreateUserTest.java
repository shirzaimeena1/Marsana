

	package tests;
	import org.testng.annotations.Test;
	import static io.restassured.RestAssured.given;
	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	public class CreateUserTest {
		// pass the payload or requst body as a string 
		String payload = "{\r\n" + 
				"  \"birthDate\": \"1980-01-15T20:43:33.632Z\",\r\n" + 
				"  \"employmentStatus\": \"Retired\",\r\n" + 
				"  \"firstName\": \"Mike\",\r\n" + 
				"  \"gender\": \"Male\",\r\n" + 
				"  \"languagePref\": \"English\",\r\n" + 
				"  \"lastName\": \"Tyson\",\r\n" + 
				"  \"maritalStatus\": \"Single\",\r\n" + 
				"  \"middleName\": \"BadMan\",\r\n" + 
				"  \"suffix\": \"Senior\",\r\n" + 
				"  \"title\": \"Mr.\"\r\n" + 
				"}";
		@Test 
		public void createUser() {
			RestAssured.baseURI = "http://tekschool-test-env.herokuapp.com/";
			Response response = given().
					contentType("application/json").
					body(payload).
					when().
					post("jpa/users").
					then().
					assertThat().
					statusCode(200).
					extract().response();
			String responseBody = response.body().asString();
			System.out.println(responseBody);
		}
	} 
	
	
	
