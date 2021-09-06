package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class Steps {

    @Given("I am a authorized user")
    public void i_am_a_authorized_user() {
        RestAssured.baseURI = "http://localhost:8080/getuser/putulp12345@gmail.com";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        Response response = request.get();
        System.out.println(response.statusCode());
        System.out.println(response.body().asString());

    }

    @Given("A list of books are available")
    public void a_list_of_books_are_available() {


    }
    @When("I add a book to my reading list")
    public void i_add_a_book_to_my_reading_list() {

    }
    @Then("The book is added")
    public void the_book_is_added() {

    }

    @When("I remove a book from my reading list")
    public void i_remove_a_book_from_my_reading_list() {

    }

    @Then("The book is removed")
    public void the_book_is_removed() {

    }


}
