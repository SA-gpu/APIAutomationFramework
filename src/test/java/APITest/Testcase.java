package APITest;

import org.junit.runners.MethodSorters;
import root.*;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.*;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;
import static root.APIValidation.*;
import static root.Rest.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Testcase{

    private Response Resp = null; 
    private JsonPath jp = null; 

    @Test
    public void Test01_Post(){
    	Rest.setBaseURI("http://dummy.restapiexample.com");
        Rest.setBasePath("/api/v1/create");
        ResponseBody = CreateNewEmp("Test User", "2300", "25");
             System.out.println("Post result:"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
             System.out.println("Post validation done and Test Completed");
    }
    @Test
    public void Test02_get(){
        setBaseURI("http://dummy.restapiexample.com");
        setBasePath("/api/v1/create");
        ResponseBody = CreateNewEmp("Get Call", "1400", "18");
              System.out.println("Post result:"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
        Integer i = extractJsonData((Response) ResponseBody, "data.id");
              System.out.println("Post validation done and id available");
        setBasePath("/employee/");
        ResponseBody = getEmp(i);
            System.out.print("Get result:"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
             System.out.println("Get validation done and Test Completed");
    }
    @Test
    public void Test03_put(){
        setBaseURI("http://dummy.restapiexample.com");
        setBasePath("/api/v1/create");
        ResponseBody = CreateNewEmp("Update User", "3620", "34");
            System.out.println("Post result:"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
        Integer i = extractJsonData((Response) ResponseBody, "data.id");
            System.out.println("Post validation done and id available");
        Rest.setBasePath("/update/");
        ResponseBody = updateEmp("User Updated", "15300", "23", i);
            System.out.println("Update result"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
            System.out.println("Update validation done and Test Completed");
    }
    @Test
    public void Test04_delete(){
        setBaseURI("http://dummy.restapiexample.com");
        setBasePath("/api/v1/create");
        ResponseBody = CreateNewEmp("delete call", "1200$", "25");
            System.out.println("Post result:"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
        Integer i = extractJsonData((Response) ResponseBody, "data.id");
            System.out.println("Post validation done and id available");
        Rest.setBasePath("/delete/");
        ResponseBody = deleteEmp(i);
            System.out.println("Delete result"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
            System.out.println("Delete validation done and Test Completed");
    }
}
