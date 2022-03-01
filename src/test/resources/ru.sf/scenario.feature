Feature: Filling cart
  Scenario: add item to cart
    Given open url h&m 'https://www2.hm.com/en_au/index.html'
    When website is open accept all cookie
    Then start search 'dress'
    Then click on first image
    And choose size
    Then click add button
