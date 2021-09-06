Feature: End to End Test for Order API

  Description : The Purpose of Test are to Cover End to End Happy Flow for Customer.
  Order URL : http://localhost:8080/OrderStore/v1/api

  Background: All Person can Acess Without Authentication

  Scenario: Any Person can Add and Delete Order
    Given A List Of Order Is Avaiable
    When He Can Add List Of Order In OrderList
    Then The Order is Added
    When He Can Remove Order From List
    Then The Order Will be Remove
