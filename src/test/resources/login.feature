Feature: Login feature

  Scenario Outline: Login with valid credentials
    Given user visits the website
    When  user enters username "<username>" and password "<password>"
    And  user presses submit button
    Then  user can visit the dashboard
    Examples:
      | username        | password     |
      | standard_user   | secret_sauce |
      | problem_user    | secret_sauce |
      | performance_glitch_user   | secret_sauce |

  Scenario Outline: Login with invalid credentials
    Given user visits the website
    When  user enters username "<username>" and password "<password>"
    And  user presses submit button
    Then  Then user can not visit the dashboard "username" "password"
    Examples:
      | username        | password     |
      | standard_user   | secret__sauce |
      | problem_use    | secret_sauce |
      | performance_user   | secret_sauce |