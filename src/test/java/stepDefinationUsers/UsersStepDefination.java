package stepDefinationUsers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import jdk.internal.org.jline.terminal.spi.JansiSupport;
import model.order.users.response.Created;
import model.order.users.response.Registration;
import model.order.users.response.Users;
import org.junit.Assert;

public class UsersStepDefination {
    public static final String URL = "https://reqres.in/";
    public static Response response;
    public static String jsonString;

    @When("enter mail id and password is correct")
    public void enter_mail_id_and_password_is_correct() {
        Registration registration1 = this.CreateSample();
        RestAssured.baseURI = URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body(registration1).post("/api/register");
        jsonString = response.asString();
        int statusCode = response.getStatusCode();
        System.out.println(response.getStatusCode());
        System.out.println(jsonString);
        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(jsonString.contains("token"),true);

    }

    @Then("user able to log in")
    public void user_able_to_log_in() {
  System.out.println(" User registration has been completed.");
    }

    private   Registration CreateSample()
    {
 Registration registration = new Registration();
 registration.setEmail("eve.holt@reqres.in");
 registration.setPassword("pistol");
 return registration;
    }

    @When("user want to add need to provide correct data")
    public void user_want_to_add_need_to_provide_correct_data() {
       Created created1 = this.samepleCreated();
        RestAssured.baseURI = URL;
   RequestSpecification request1 = RestAssured.given();
        request1.header("Content-Type", "application/json");
        response = request1.body(created1).post("/api/users");
        String jsonString1 = response.asString();
        System.out.println(jsonString1);
        System.out.println("the status code is:" +response.getStatusCode());

    }

    @Then("creation done")
    public void creation_done() {

    }
 private Created samepleCreated(){

     Created created = new Created();
     created.setName("morpheus");
     created.setJob("zion resident");
     return created;
 }

    @When("user want to update info they can update")
    public void user_want_to_update_info_they_can_update() {
        Created created2 = this.samepleCreated();
        RestAssured.baseURI = URL;
        RequestSpecification request2 = RestAssured.given();
        request2.header("Content-Type", "application/json");
        response = request2.body(created2).put("/api/users/2");
        String jsonString2 = response.asString();
        System.out.println(jsonString2);
        System.out.println("the status code is:" +response.getStatusCode());
    }

    @Then("updated data will be availble")
    public void updated_data_will_be_availble() {
    System.out.println("the user deatils has been updated");
    }
    @When("you want to retrive all user deatils")
    public void you_want_to_retrive_all_user_deatils() {

        RestAssured.baseURI = URL;
        RequestSpecification request3 = RestAssured.given();
        response = request3.get("/api/users/2");
        String jsonString4 = response.asString();
        System.out.println(jsonString4);
        System.out.println("the status code is:" +response.getStatusCode());
        JsonPath jasonPath = response.jsonPath();
      Integer dataId = jasonPath.get("data.id");
      System.out.println("the iid is:" +dataId);
     Assert.assertEquals(2,dataId.intValue());
     String firstName = jasonPath.get("data.first_name");
     System.out.println("the name is :"+firstName);
     Assert.assertEquals("Janet", firstName);
     Users users = response.getBody().as(Users.class);
     System.out.println("the response body of users:" +users.getData().getEmail());
     System.out.println("the response body of users :" +users.getSupport().getUrl());

    }


    @Then("you will get all user deatils")
    public void you_will_get_all_user_deatils() {
        RestAssured.baseURI = URL;
        RequestSpecification request4 = RestAssured.given();
        response = request4.get("/api/users?page=2");
        String jsonString5 = response.asString();
        System.out.println(jsonString5);
        System.out.println("the status code is:" +response.getStatusCode());
        JsonPath jasonPath = response.jsonPath();
        String data = jasonPath.get("data[2].email");
        System.out.println("the value of data is:" +data);

}

}
