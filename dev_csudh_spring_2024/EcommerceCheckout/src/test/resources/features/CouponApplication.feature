Feature: Coupon Application

  Scenario Outline: input a coupon code
    Given the user has a coupon code
    When the user is at the coupon application page
    Then the user inputs the <coupon code> into the page

    Examples: 
      | coupon code |
      | "tf3tr32"   |
      | "reiart3t"  |
