package APITest;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import root.Rest;

import static root.APIValidation.*;
import static root.Rest.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Testcase{

    private Response Resp = null; 
    private JsonPath jp = null;

    @Test
    public void Test01_Post(){
        ResponseBody = CreateNewEmp("Test User", "2300", "25");
             System.out.println("Post result:"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
             System.out.println("Post validation done and Test Completed");
    }
    @Test
    public void Test02_get(){
        ResponseBody = CreateNewEmp("Get Call Test", "2500", "36");
              System.out.println("Post result:"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
        Integer i = extractJsonData((Response) ResponseBody, "data.id");
            System.out.print(i);
              System.out.println("Post validation done and id available");
        setBasePath("/api/v1/employee/");
        ResponseBody = getEmp(i);
        System.out.printf("Get result:", ResponseBody.asString());
        //checkStatusIs200((Response) ResponseBody);
        //checkStatusInBody((Response) ResponseBody);
             System.out.println("Get validation done and Test Completed");
    }
    @Test
    public void Test03_put(){
        ResponseBody = CreateNewEmp("Update User", "3620", "34");
            System.out.println("Post result:"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
        Integer i = extractJsonData((Response) ResponseBody, "data.id");
            System.out.println("Post validation done and id available");
        Rest.setBasePath("/api/v1/update/");
        ResponseBody = updateEmp("User Updated", "15300", "23", i);
            System.out.println("Update result"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
            System.out.println("Update validation done and Test Completed");
    }
    @Test
    public void Test04_delete(){
        ResponseBody = CreateNewEmp("delete call", "1200", "25");
            System.out.println("Post result:"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        checkStatusInBody((Response) ResponseBody);
        Integer i = extractJsonData((Response) ResponseBody, "data.id");
            System.out.println("Post validation done and id available");
        Rest.setBasePath("/api/v1/delete/");
        ResponseBody = deleteEmp(i);
            System.out.println("Delete result"+ResponseBody.asString());
        checkStatusIs200((Response) ResponseBody);
        //checkStatusInBody((Response) ResponseBody);
            System.out.println("Delete validation done and Test Completed");
    }
}
