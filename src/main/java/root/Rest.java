package root;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;

public class Rest extends ConfigReader{

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
			ConfigReader.getConfig();

			Map<String, Object> jsonAsMap = new HashMap<>();
			jsonAsMap.put("name", Name);
			jsonAsMap.put("salary", Sal);
			jsonAsMap.put("age", Age);

			ResponseBody =
					given().
							contentType(JSON).
							body(jsonAsMap).
							when().
							post(ConfigReader.URI + ConfigReader.post).
							thenReturn().body();
			return ResponseBody;
		}

	    public static ResponseBody getEmp(Integer id) {
			ConfigReader.getConfig();
			ResponseBody =
					given().
							contentType(JSON).
							when().
							get(ConfigReader.URI + ConfigReader.get+id).
							thenReturn().body();
			return ResponseBody;
	    }

	    public static ResponseBody deleteEmp(Integer id) {
			ConfigReader.getConfig();
			ResponseBody =
					given().
							contentType(JSON).
							when().
							delete(ConfigReader.URI + ConfigReader.delete+id).
							thenReturn().body();
			return ResponseBody;
	    }

	    public static ResponseBody updateEmp(String Name, String Sal, String Age, Integer id) {
			ConfigReader.getConfig();
			Map<String, Object> jsonAsMap = new HashMap<>();
			jsonAsMap.put("name", Name);
			jsonAsMap.put("salary", Sal);
			jsonAsMap.put("age", Age);

			ResponseBody =
					given().
							contentType(JSON).
							body(jsonAsMap).
							when().
							put(ConfigReader.URI + ConfigReader.update + id).
							thenReturn().body();
			return ResponseBody;
		}
}
