# Author: Anthony Dao
# CSUDH CSC 581 SELENIUM TEST
Feature: User Login

	
  Scenario: Successful login with valid crendentials
    Given the user is on login page
    When the user enters a valid username and password
    And the user clicks on login button
    Then the user should be redirected to the homepage
    And a welcome message should be displayed