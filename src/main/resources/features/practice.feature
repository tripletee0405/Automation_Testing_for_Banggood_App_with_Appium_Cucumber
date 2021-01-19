Feature: Practice Final
  # TC_01
  Scenario: Verify product name and product price
    Given I open Banggood Easy Online Shopping App
    When I click to close popup button
    And I Click to the Category on footer menu
    And I Scroll and click to Home and Garden in Left menu
    And I click to the Home Decor
    And I click to the Filter and input price from 20 to 30
    And I click Done
    And I click first product
    Then Display product name and product price in range 20 to 30

#   TC_02
  Scenario: Verify product name, product price and quantity
    Given I open Banggood Easy Online Shopping App
    When I click to close popup button
    And I Scroll to Hot Category
    And I click to the first category
    And I click to the first product
    And I click Add to Carttttt
    And I click Add to Cart button
    And I click to Cart icon on footer
    Then Display product name, product size, product price and quantity

  # TC_03
  Scenario: Verify Sign In screen
    Given I open Banggood Easy Online Shopping App
    When I click to close popup button
    And I click Account on footer menu
    And I click View All Order
    Then Display login screen displayed with : Email, password, Sign In button