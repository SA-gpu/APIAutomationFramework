package root;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.*;

public class Rest{

		public static String path = null;
		public static ResponseBody ResponseBody;
		//public static final Logger LOG =  LoggerFactory.getLogger(Rest.class);

		public static void setBaseURI (String baseURI){
	        RestAssured.baseURI = baseURI;
	    }
	
	    public static void setBasePath(String basePath){
	        RestAssured.basePath = basePath;
	    }

		public static void setBaseURI (){
			RestAssured.baseURI = null;
		}

		public static void setBasePath(){
			RestAssured.basePath = null;
		}
	    
	    public static ResponseBody CreateNewEmp(String Name, String Sal, String Age) {

			Map<String, Object> jsonAsMap = new HashMap<>();
			jsonAsMap.put("name", Name);
			jsonAsMap.put("salary", Sal);
			jsonAsMap.put("age", Age);

			ResponseBody =
					given().
							contentType(JSON).
							body(jsonAsMap).
							when().
							post(RestAssured.baseURI + RestAssured.basePath).
							thenReturn().body();
			return ResponseBody;
		}

	    public static ResponseBody getEmp(Integer id) {
			ResponseBody =
					given().
							contentType(JSON).
							when().
							get(RestAssured.baseURI + RestAssured.basePath+id).
							thenReturn().body();
			return ResponseBody;
	    }

	    public static ResponseBody deleteEmp(Integer id) {
			ResponseBody =
					given().
							contentType(JSON).
							when().
							delete(RestAssured.baseURI + RestAssured.basePath+id).
							thenReturn().body();
			return ResponseBody;
//	    	path += id;
//	        return delete(RestAssured.baseURI+RestAssured.basePath);
	    }

	    public static ResponseBody updateEmp(String Name, String Sal, String Age, Integer id) {
			Map<String, Object> jsonAsMap = new HashMap<>();
			jsonAsMap.put("name", Name);
			jsonAsMap.put("salary", Sal);
			jsonAsMap.put("age", Age);

			ResponseBody =
					given().
							contentType(JSON).
							body(jsonAsMap).
							when().
							put(RestAssured.baseURI + RestAssured.basePath + id).
							thenReturn().body();
			return ResponseBody;
		}
}
