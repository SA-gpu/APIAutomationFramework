package root;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Rest extends ConfigReader{

		public static String path = null;
		public static Response ResponseBody;
		//public static final Logger LOG =  LoggerFactory.getLogger(Rest.class);
	    
	    public static Response post(String fName, String lName, Integer price, Boolean dPaid, String aNeeds, String cIn, String cOut) {
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
			Response response = given().auth().preemptive().basic("admin","password123").delete(getUrl);
			return response;
	    }

	    public static Response put(String fName, String lName, Integer price, Boolean dPaid, String aNeeds, String cIn, String cOut, Integer id) {
			ConfigReader.getConfig();
			String getUrl = ConfigReader.URI + "/" + id;

			Map<String, Object> APIBody = new HashMap<>();
			APIBody.put("firstname", fName);
			APIBody.put("lastname", lName);
			APIBody.put("totalprice", price);
			APIBody.put("depositpaid", dPaid);
			APIBody.put("additionalneeds", aNeeds);
			APIBody.put("bookingdates", new HashMap<String, String>() {{
				put("checkin", cIn);
				put("checkout", cOut);
			}});
			RequestSpecBuilder builder = new RequestSpecBuilder();
			builder.setBody(APIBody);
			builder.setContentType("application/json");
			RequestSpecification requestSpec = builder.build();
				Response response = given().auth().preemptive().basic("admin", "password123").
						spec(requestSpec).when().put(getUrl);
			return response;
		}

		public static Response patch(String fName, String lName, Integer price, Boolean dPaid, String aNeeds, String cIn, String cOut, Integer id) {
			ConfigReader.getConfig();
			String getUrl = ConfigReader.URI + "/" + id;

			Map<String, Object> APIBody = new HashMap<>();
				if (fName != ""){
			APIBody.put("firstname", fName);
				}
				if (lName != ""){
			APIBody.put("lastname", lName);
				}
				if (price != 0){
			APIBody.put("totalprice", price);
				}
				if (dPaid != null){
			APIBody.put("depositpaid", dPaid);
				}
				if (aNeeds != ""){
			APIBody.put("additionalneeds", aNeeds);
				}
				if (cIn != "" || cOut != ""){
			APIBody.put("bookingdates", new HashMap<String, String>() {{
						if (cIn != ""){
				put("checkin", cIn);}
						if (cOut != ""){
				put("checkout", cOut);}
			}});
				}
			RequestSpecBuilder builder = new RequestSpecBuilder();
			builder.setBody(APIBody);
			builder.setContentType("application/json");
			RequestSpecification requestSpec = builder.build();
			Response response = given().auth().preemptive().basic("admin", "password123").
					spec(requestSpec).when().patch(getUrl);
			return response;
		}

}
