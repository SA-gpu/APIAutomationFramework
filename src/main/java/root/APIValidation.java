package root;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class APIValidation {

	 
	    public static void checkStatusIs200 (Response resp) {
	        assertEquals("Status Check Failed!", 200, resp.getStatusCode());
	    }

		public static void checkStatusInBody (Response resp) {
			assertEquals("Response Body Status Failed!", "success", resp.jsonPath().get("status"));
		}

		public static String extractJsonData (Response resp, String key) {
			String value = resp.jsonPath().get(key);
			return value;
		}

	}

