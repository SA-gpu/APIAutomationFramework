package APITest;

import com.jayway.restassured.RestAssured;
import root.*;
import root.APIValidation;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import org.junit.*;
import org.junit.runners.MethodSorters;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
 

public class Post{

    private Response Resp = null; 
    private JsonPath jp = null; 
 
    @Test
    public void setup (){
        //Test Setup
    	Rest.setBaseURI("http://dummy.restapiexample.com");
        Rest.setBasePath("/api/v1/create");
        		System.out.print("path is set");


       ResponseBody<Response> Resp= Rest.CreateNewEmp("Test User", "15300", "43");
        System.out.print(Resp);
      //  jp = Rest.getJsonPath(Resp);

       // System.out.println("jsonpath" + jp.getString("status"));//Get JsonPath*/



    }
    
//    @Test
//    public void checkStatusCode() {
//        //Check duplicate videos exist?
//    	APIValidation.checkStatusIs200(res);
//    }	
//  
//    @After
//    public void afterTest (){
//        //Reset Values
//        Rest.resetBaseURI();
//        Rest.resetBasePath();
//    }
 
   
    
}
