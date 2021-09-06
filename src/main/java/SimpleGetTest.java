import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
//import org.junit.Assert;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public class SimpleGetTest {


    @Test
    public void GetWeatherDetails() {
        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/78789798798/rr");
        int statusCode = response.getStatusCode();
        int s = response.statusCode();
        Assert.assertEquals(  400,statusCode);
        String responseBody = response.getBody().asString();
       System.out.println("Response Body is =>  " + responseBody);
       System.out.println(s+" the status code is :" +statusCode);

    }

    @Test
    public void dummyRestExample(){
        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"Hyderabad");
        String statusLine = response.getStatusLine();
        Assert.assertEquals( "corect data will be :", "HTTP/1.1 200 OK", statusLine  );
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        //System.out.println(" the status code is :" +statusCode);

    }
    @Test
    public void dummyRest1Example(){

        RestAssured.baseURI = "https://www.google.in";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
                String contentType = response.header("content-type");
        System.out.println("content type is :"+contentType);
        String serverType = response.header("Server");
        System.out.println("the surver is" +serverType);
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content encoding is : " +acceptLanguage);
        //System.out.println("response is :"+ response.getBody().asString());

    }


    @Test
        public void example() {
            RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.get("/Hyderabad");
            //ResponseBody body = response.getBody();
            System.out.print("Response body is :" + response.getBody().asString());
        }

        @Test
    public void registrationSucessful()
        {
            RestAssured.baseURI ="https://demoqa.com/customer";
            RequestSpecification request = RestAssured.given();
            JSONObject requestParams = new JSONObject();
            requestParams.put("FirstName", "Virender");
            requestParams.put("LastName", "Singh");
            requestParams.put("UserName", "sdimpleuser2dd2011");
            requestParams.put("Password", "password1");
            requestParams.put("Email",  "sample2ee26d9@gmail.com");
            request.body(requestParams.toString());
            Response response = request.post("/Register");
            int statusCode = response.getStatusCode();
            System.out.println("then status code is : " +statusCode);




        }

        @Test
    public void updateRecords(){
            int empid = 15410;

            RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
            RequestSpecification request = RestAssured.given();

            JSONObject requestParams = new JSONObject();
            requestParams.put("name", "Zion"); // Cast
            requestParams.put("age", 23);
            requestParams.put("salary", 12000);

            request.body(requestParams.toJSONString());
           // Response response = request.put("/update/"+ empid);
            Response response = request.delete("/delete/"+ empid);
            int statusCode = response.getStatusCode();
            System.out.println(response.asString());
            Assert.assertEquals(statusCode, 200);
        }


        @Test
    public void jasonPathUsage() throws MalformedURLException
        {
          RestAssured.baseURI = "https://restapi.demoqa.com/utilities/books/getallbooks";
          RequestSpecification request = RestAssured.given();
          Response response = request.get();
          System.out.println(response.body().asString());
            JsonPath jsonPathEvalutor = response.jsonPath();
            List<String> allBooks =jsonPathEvalutor.getList("books.title");
            for(String book : allBooks)
            {
                System.out.println("the book is :" +book);
            }

        }

}

