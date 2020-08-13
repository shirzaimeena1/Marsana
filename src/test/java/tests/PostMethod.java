package tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class PostMethod {
	@SuppressWarnings("unchecked")
	@Test
	public void postRequest() {
		// hit the Endpoint URL 
		RestAssured.baseURI = "http://tekschool-test-env.herokuapp.com/";
		// create object of JasonObject to pass key and value of JSon body to our post request
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("firstName", "Tim");
		jsonObj.put("lastName","John");
		jsonObj.put("middleName", "Tim");
		jsonObj.put("gender","Male");
		jsonObj.put("title", "Mr.");
		jsonObj.put("suffix","JR.");
		jsonObj.put("maritalStatus", "Single");
		jsonObj.put("languagePref","English");
		jsonObj.put("birthDate","1980-01-15T20:43:33.632Z");
		jsonObj.put("employmentStatus","Student");
		Response response = given().
				contentType("application/json").
				body(jsonObj.toJSONString()).
				when().
				post("jpa/users").
				then().
				statusCode(200).
				extract().response();
		String responseBody = response.asString();
		System.out.println(responseBody);
	}
}