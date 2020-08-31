Feature: Credit Card

  Script to test end to end checkout flow for purchasing
  “Pillow” using Credit Card as payment method.

  Background:
    Given I am on "https://demo.midtrans.com" website
    When I click on buy now button
    And I click on checkout button
    And I click on continue button

  @e2e @payment_flow @success
  Scenario Outline: Valid Credit Card
    And I fill the details with "<card_number>" , "<expiry_date>", "<cvv_number>"
    And I click on pay now button
    And I enter "<bank_otp>"
    Then I should be able to see "Transaction successful"
    Examples:
      | card_number      | expiry_date | cvv_number | bank_otp |
      | 4811111111111114 | 1224        | 123        | 112233   |

  @e2e @payment_flow @unsuccess
  Scenario Outline: Invalid Credit Card
    When I fill the details with "<card_number>" , "<expiry_date>", "<cvv_number>"
    And I click on pay now button
    Then I should not be able to see "Transaction successful"
    Examples:
      | card_number      | expiry_date | cvv_number |
      | 4911111111111113 | 0220        | 123        |

  @e2e @payment_flow @cancel
  Scenario Outline: User cancels the transaction
    And I fill the details with "<card_number>" , "<expiry_date>", "<cvv_number>"
    And I click on pay now button
    And I click on cancel button
    Then I should be able to see "Transaction failed"
    Examples:
      | card_number      | expiry_date | cvv_number |
      | 4811111111111114 | 1224        | 123        |