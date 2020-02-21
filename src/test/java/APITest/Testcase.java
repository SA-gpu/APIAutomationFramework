package APITest;

import root.*;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import org.junit.*;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static root.APIValidation.*;
import static root.Rest.*;


public class Testcase{

    private Response Resp = null; 
    private JsonPath jp = null; 
 
    @Test
    public void post_01Test(){
    	Rest.setBaseURI("http://dummy.restapiexample.com");
        Rest.setBasePath("/api/v1/create");
        ResponseBody = CreateNewEmp("Test User", "2300", "25");
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
        extractJsonData((Response) ResponseBody, "id");
    }
    @Test
    public void get_02Test(){
        Rest.setBaseURI("http://dummy.restapiexample.com");
        Rest.setBasePath("/employee/");
        ResponseBody = getEmp("44");
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
    }
    @Test
    public void put_03Test(){
        Rest.setBaseURI("http://dummy.restapiexample.com");
        Rest.setBasePath("/update/");
        ResponseBody = updateEmp("Test User", "15300", "23", "44");
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
    }
    @Test
    public void delete_03Test(){
        Rest.setBaseURI("http://dummy.restapiexample.com");
        Rest.setBasePath("/delete/");
        ResponseBody = deleteEmp("44");
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
    }

   
    
}
