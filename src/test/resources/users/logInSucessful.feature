Feature: log in page of users
  URL:https://reqres.in/

  Scenario: its registartion page
    When enter mail id and password is correct
    Then user able to log in
    When user want to add need to provide correct data
    Then creation done
    When user want to update info they can update
    Then updated data will be availble
    When you want to retrive all user deatils
    Then you will get all user deatils



