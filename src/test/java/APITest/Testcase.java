package APITest;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static root.APIValidation.*;
import static root.Rest.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Testcase{

  //  private Response Resp = null;
    private JsonPath jp = null;

    @Test
    public void test01_Post(){
        Response response = post("Test", "asdas", 50, true, "Lunch", "2020-02-23","2020-02-24");
             System.out.println("Post result:"+response.asString());
        checkStatusIs200(response);
        int i= extractJsonData(response, "bookingid");
             System.out.println(i +"\n"+"Post validation done and Test Completed");
    }
    @Test
    public void test02_get(){
        Response response = post("Get Call", "asdas", 520, true, "Lunch", "2020-02-23","2020-02-24");
            System.out.println("Post result:"+response.asString());
        checkStatusIs200(response);
        int i= extractJsonData(response, "bookingid");
            System.out.println(i);
            System.out.println("Post validation done and id available");
        response = get(i);
            System.out.println("Get result:" + response.asString());
        checkStatusIs200(response);
        String j= extractJsonData(response, "firstname");
            System.out.println(j);
            System.out.println("Get validation done and Test Completed");
    }
    @Test
    public void test03_put(){
        Response response = post("Create", "User", 24, false, "Booking Create", "2020-02-23","2020-02-24");
            System.out.println("Post result:"+response.asString());
        checkStatusIs200(response);
        int i= extractJsonData(response, "bookingid");
            System.out.println(i);
            System.out.println("Post validation done and id available");
        response = put("booking", "User", 120, true, "booking updated", "2020-02-23","2020-02-24", i);
            System.out.println("Update result: "+response.asString());
        checkStatusIs200(response);
            System.out.println("Update validation done and Test Completed");
    }
    @Test
    public void test04_patch(){
        Response response = post("Create", "User", 2540, false, "Booking Create", "2020-02-23","2020-02-24");
        System.out.println("Post result:"+response.asString());
        checkStatusIs200(response);
        int i= extractJsonData(response, "bookingid");
        System.out.println(i);
        System.out.println("Post validation done and id available");
        response = patch("", "", 120, true, "partial update", "","2020-02-24", i);
        System.out.println("Update result: "+response.asString());
        checkStatusIs200(response);
        System.out.println("Update validation done and Test Completed");
    }
    @Test
    public void test05_delete(){
        Response response = post("Delete Call", "asdas", 520, true, "Lunch", "2020-02-23","2020-02-24");
            System.out.println("Post result:"+response.asString());
        checkStatusIs200(response);
        int i= extractJsonData(response, "bookingid");
            System.out.println(i);
            System.out.println("Post validation done and id available");
        response = delete(i);
        System.out.println("Get result:" + response.asString());
        checkStatusIs201(response);
            System.out.println("Delete validation done and Test Completed");
    }
}
