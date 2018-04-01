Feature: This is a simple test using Cucumber & Selenium.

  Scenario: Testing open broswer and search "Selenium"
    Given I am on the Baidu search page "https://www.baidu.com"
    When Enter "Selenium" on the search text
    And Click Search button
    Then Check the title of website is "selenium_百度搜索" 