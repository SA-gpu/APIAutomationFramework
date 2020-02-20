package root;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class APIValidation {

	 
	    public static void checkStatusIs200 (Response resp) {
	        assertEquals("Status Check Failed!", 200, resp.getStatusCode());
	    }
	 
	    
	 
	    
	}

