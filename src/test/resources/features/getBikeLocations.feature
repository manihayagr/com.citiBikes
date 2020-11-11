Feature: Get citiBikes Locations
  Scenario: Get the  location of the cityBikes across globe
    Given I want to get the citiBikes location
    When  I send request with "/networks"
    Then I get the successful response 200


  Scenario: Get the bike locations of the CityBike for the city Frankfurt
    Given I want to get the citiBikes location
    When  I send request with "/networks/visa-frankfurt"
    Then I get the successful response 200
    And I am looking for the "frankfurt"
    And I got the details for it

