Feature: Find city cafe
  Scenario: choose city
    Given open url of dodo pizza 'https://dodopizza.ru/'
    Then fill input with 'Владивосток'
    And assert that choosen city is 'Владивосток'
