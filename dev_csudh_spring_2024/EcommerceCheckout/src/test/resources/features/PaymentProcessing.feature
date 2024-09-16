Feature: Payment Processing Feature

  @tag2
  Scenario Outline: Payment Processing
    Given the user is shipping address is filled out
    And the user has items in their shopping cart
    When the user enters their payment info: <card>, <expr>, and <security code>
    Then the user payment info should match <card>, <expr>, and <sercurity code>

    Examples: 
      | card              | expr       | security code |
      | 93483204820398423 | "3/3/2029" |           342 |
      | 23412341242142343 | "3/2/2026" |           934 |
