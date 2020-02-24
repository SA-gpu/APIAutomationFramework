package root;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class Rest extends ConfigReader{

		public static String path = null;
		public static Response ResponseBody;
		//public static final Logger LOG =  LoggerFactory.getLogger(Rest.class);
	    
	    public static Response create(String fName, String lName, Integer price, Boolean dPaid, String aNeeds, String cIn, String cOut) {
			ConfigReader.getConfig();
			String getUrl = ConfigReader.URI;

			Map<String, Object> APIBody = new HashMap<>();
			APIBody.put("firstname", fName);
			APIBody.put("lastname", lName);
			APIBody.put("totalprice", price);
			APIBody.put("depositpaid", dPaid);
			APIBody.put("additionalneeds", aNeeds);
			APIBody.put("bookingdates", new HashMap<String,String>() {{
				put("checkin", cIn );
				put("checkout", cOut);
			}});
			RequestSpecBuilder builder = new RequestSpecBuilder();
			builder.setBody(APIBody);
			builder.setContentType("application/json");
			RequestSpecification requestSpec = builder.build();
			Response response = given().
					spec(requestSpec).when().post(getUrl);
			return response;
		}

	    public static Response get(Integer id) {
			ConfigReader.getConfig();
			String getUrl = ConfigReader.URI +"/"+id;
			Response getResp = given().when().get(getUrl);
			return getResp;
	    }

	    public static Response delete(Integer id) {
			ConfigReader.getConfig();
			String getUrl = ConfigReader.URI +"/"+id;
			Response getResp = given().auth().preemptive().basic("admin","password123").delete(getUrl);
			return getResp;
	    }

	    public static Response update(String Name, String Sal, String Age, Integer id) {
			ConfigReader.getConfig();
			Map<String, Object> jsonAsMap = new HashMap<>();
			jsonAsMap.put("name", Name);
			jsonAsMap.put("salary", Sal);
			jsonAsMap.put("age", Age);

			RequestSpecification req = (RequestSpecification) given().
					given().
							contentType(JSON).
							body(jsonAsMap).
							when().
							put(ConfigReader.URI + id).
							thenReturn().body();
			return (Response) req;
		}
}
