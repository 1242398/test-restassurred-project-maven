package stepDefinitionOrder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.order.response.DeliverAdress;
import model.order.response.Order;
import model.order.response.Orders;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StepOrder {

    public static final String URL = "http://localhost:8080";
   public static Response response;
   public static String jsonString;
   public String orderId ;
   public String order_payload = " {  " + "\n"+"\"orders\": "+ "[ " + "{" + "\n"+
            "\"orderId\"" +":" + "\"generate_orderid\""+ "," +"\n"+
            "\"orderNo\"" + ":" + "\"asd\"" +  "," +"\n"+
            "\"itemName\"" + ":"+ "\"biscuit\"" + " ," + "\n"+
            "\"quantity\"" + ":" +  "\"100\"" + "," + "\n" +
            "\"amount\"" + ":" + "\"50\""  + ","  + "\n" +

            "\"deliverAdress\"" + ":" +  "{" + "\n" +
            "\"name\"" + ":" + "\"putu\"" +  "," + "\n" +
            "\"houseNo\"" + ":" + "\"301\""  + ","  + "\n" +
            "\"street\"" + ":" + "\"ghgg\"" +  "," + "\n" +
            "\"pinNo\"" + ":" + "\"276543\""  + "\n" +
            "\n" + "}"
            + "}" +
            " ]" + "\n" +
            "}";

    @Given("A List Of Order Is Avaiable")
    public void a_List_Of_Order_Is_Avaiable()
    {

        Orders orders= this.createSampleOrder();
        RestAssured.baseURI = URL;
        orderId = "1234";
        RequestSpecification request = RestAssured.given();
        String updated_payLoad =  order_payload.replace("generate_orderid",orderId);
        System.out.println(updated_payLoad);

     request.header("Content-Type", "application/json");
      response = request.body(orders).post("/OrderStore/v1/api");
        jsonString = response.asString();
System.out.println(response.getStatusCode());

    }
private Orders createSampleOrder()
{

        Order order = new Order();

        order.setOrderId("8617");
        order.setOrderNo("Putul_Pal");
        order.setItemName("choclate");
        order.setQuantity("10");
        order.setAmount("5");
        DeliverAdress deliverAdress = new DeliverAdress();
        deliverAdress.setName("puspita");
        deliverAdress.setStreet("2nd cross");
        deliverAdress.setHouseNo("301");
        deliverAdress.setPinNo("712122");
        order.setDeliverAdress(deliverAdress);
        //element 2

    Order order2= new Order();
    order2.setOrderId("3456");
    order2.setOrderNo("puts");
    order2.setItemName("bis");
    order2.setQuantity("445");
    order2.setAmount("23456");
    DeliverAdress deliverAdress2 = new DeliverAdress();
    deliverAdress2.setName("puspita23");
    deliverAdress2.setStreet("34nd cross");
    deliverAdress2.setHouseNo("234");
    deliverAdress2.setPinNo("234567");
    order2.setDeliverAdress(deliverAdress2);

        Orders orders= new Orders();

        List<Order> orders1= new ArrayList<>();
        orders1.add(order);
        orders1.add(order2);

        orders.setOrders(orders1);
      return orders;


}
    @When("He Can Add List Of Order In OrderList")
    public void he_Can_Add_List_Of_Order_In_OrderList() {
    orderId = "9870";
       String updated_payLoad =  order_payload.replace("generate_orderid",orderId);
    System.out.println(updated_payLoad);
    RestAssured.baseURI = URL;
    RequestSpecification request = RestAssured.given();
    request.header("Content-Type" ,"application/json");
    Response response= request.body(updated_payLoad).post("/OrderStore/v1/api");
    System.out.println("he_Can_Add_Ljava.lang.ClassCastException: class java.util.LinkedHashMap cannot be cast to classist_Of_Order_In_OrderList response code is :" +(response.statusCode()));
    System.out.println("he_Can_Add_List_Of_Order_In_OrderList response value is : " +response.asString());
    //testcase 1: check the response code as 201
    Assert.assertEquals(201,response.getStatusCode());
    Order  jsonList[] = response.as(Order[].class);

     System.out.println("the order list is :" +jsonList);
     System.out.println("sfsjfb= "+jsonList[0]);
     //testcase 2: check whether out is null or not
     Assert.assertNotEquals(null,jsonList);
     // testcase 3: verify the orderId
     Assert.assertEquals("9870",jsonList[0].getOrderId());

    }

    @Then("The Order is Added")
    public void the_Order_is_Added() {
        RestAssured.baseURI= URL;
        RequestSpecification requestSpecification =RestAssured.given();
        Response response = requestSpecification.get("OrderStore/v1/api");
        System.out.println("putul order:" +response.asString());
        Orders responseOrder = response.as(Orders.class);
        List< Order> listOfOrders=  responseOrder.getOrders();
        for( int i = 0; i<listOfOrders.size(); i++) {
            Order retriveOrder = listOfOrders.get(i);
            System.out.print("the orderid is :" + retriveOrder.getOrderId());
            System.out.print("  the orderno is :" + retriveOrder.getOrderNo());
            System.out.print("the item name is :" + retriveOrder.getItemName());
            System.out.print("the quantity is :" + retriveOrder.getQuantity());
            System.out.print("the amount is :" + retriveOrder.getAmount());
            DeliverAdress address= retriveOrder.getDeliverAdress();
            System.out.println("The deliver adress is :" + "name:" + address.getName()
                    + "houseno  is " +address.getHouseNo()
                    + " street no is: "+address.getStreet()
                    + " pin no is :"  +address.getPinNo() );

        }
    }

    @When("He Can Remove Order From List")
    public void he_Can_Remove_Order_From_List() {
      orderId = "9870";

      System.out.println("the latest orderid is :" +orderId);
        RestAssured.baseURI = URL;
        String delete_Url = "/OrderStore/v1/api/" + orderId;
        RequestSpecification request = RestAssured.given();
        Response response = request.delete(delete_Url);
        System.out.println("he_Can_Remove_Order_From_List resposecode= "+response.statusCode());
        System.out.println(response.getBody().asString());

    }

    @Then("The Order Will be Remove")
    public void the_Order_Will_be_Remove() {

    }
}
