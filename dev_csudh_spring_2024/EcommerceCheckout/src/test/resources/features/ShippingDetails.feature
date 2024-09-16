Feature: Shipping Details

  Scenario Outline: Fill out shipping details
    Given the user has product(s) in cart and is on the checkout page
    When the user fills out <country>, <name>, <number>, <street>, <city>, <state>, <zip>
    Then the shipping address should contain <country>, <name>, <number>, <street>, <city>, <state>, <zip>

    Examples: 
      | country         | name          | number     | street                 | city      | state | zip   |
      | "United States" | "Anthony Dao" | 7143884758 | "227 N.Redrock Street" | "Anaheim" | "CA"  | 92807 |
      | "United States" | "Jupi Cadena" | 5624542254 | "8243 Quoit Street"    | "Downey"  | "CA"  | 90242 |
