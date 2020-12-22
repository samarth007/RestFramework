package stepDefination;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


import RESTApi.RestFramework.Utils;

public class stepDefination extends Utils {

ResponseSpecification resspec;
Response res;
	

    @Given("^user provides the get api$")
    public void user_provides_the_get_api() throws Throwable {
    
	   resspec= new ResponseSpecBuilder().expectContentType(ContentType.JSON)
			   .expectStatusCode(200).build();
	   
		
	}

    @When("^user call the get place \"([^\"]*)\" with get and \"([^\"]*)\" http request$")
    public void user_call_the_get_place_with_get_and_http_request(String arg1, String arg2) throws Throwable {
		res= given().spec(request(arg2)).when().get(arg1).then().extract().response();
		
	   	}

	@Then("^Api call got success with status code (\\d+)$")
	public void api_call_got_success_with_status_code(int arg1) throws Throwable {
		
	    assertEquals(res.getStatusCode(), arg1);
	}

	@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String arg1, String arg2) throws Throwable {
	    
	            String r=res.asString();
	            JsonPath js = new JsonPath(r);
	            assertEquals(js.getString(arg1),arg2);
	}


}
