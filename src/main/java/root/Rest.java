package root;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.*;

public class Rest{
	
	    public static String path = "http://dummy.restapiexample.com" + "/api/v1/create";
	 
	    public static void setBaseURI (String baseURI){
	        RestAssured.baseURI = baseURI;
	    }
	
	    public static void setBasePath(String basePath){
	        RestAssured.basePath = basePath;
	    }
	    
	    public static ResponseBody<Response> CreateNewEmp(String Name, String Sal, String Age) {
	    	// post API form code 
	    	
	    	RequestSpecification req = RestAssured.given().contentType("application/JSON").
	    			formParam("name", Name).
	    			formParam("salary", Sal).
	    			formParam("age", Age);
	    	return req.post(path);
	    }
	 
	    public static Response getEmp(int id) {
	    	path += id;
	        return get(path);
	    }
	    
	    public static Response deleteEmp(int id) {
	    	path += id;
	        return delete(path);
	    }
	    
	    public static Response updateEmp(String Name, String job, int id) {
	    	path += id;
	    com.jayway.restassured.specification.RequestSpecification req = RestAssured.given().contentType("application/JSON").
	    			formParam("name", Name).
	    			formParam("job", job);
	        return req.put(path);
	    }
	    
	    public static JsonPath getJsonPath (ResponseBody<Response> resp) {
	        String json = resp.toString();
	        //System.out.print("returned json: " + json +"\n");
	        return new JsonPath(json);
	    }
}
