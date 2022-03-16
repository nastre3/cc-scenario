Feature: Find city cafe
  Scenario: choose city
    Given open url of dodo pizza 'https://dodopizza.ru/'
    Then fill input with 'Владивосток'
    And assert that chosen city is 'Владивосток'
  Scenario: choose absent city
    Given open url of dodo pizza 'https://dodopizza.ru/'
    Then fill input with 'Лапландия'
    And assert that user get message 'Пиццерия в этом городе еще не открылась'