Feature: Filing Electronic Record

  # Scenario: Filing with valid PDF and clicking Save
  #   Given user logs in with username "<username>" and password "<password>"
  #   When user navigate to document filling form
  #   And select template "<template>" as the template from the template selection options and upload document "<document>"
  #   And user search and select folder "<folder>"
  #   And user fill field Keywords "<keywords>" and field Synopsis "<synopsis>"
  #   And user save the form
  #   Then system shows "The record is registered successfully."

  #   Examples:
  #       | username | password | template | document | folder | keywords | synopsis |
  #       | rewina_EU  | SqlP@ssw0rd_2023 | default | dummypdf.pdf | QA TECHNICAL TEST-ELECTRONIC FOLDER | test keywords | test synopsis |


  # Scenario: Filing with Valid PDF Record and Clicking Save as Draft
  #   Given user logs in with username "<username>" and password "<password>"
  #   When user navigate to document filling form
  #   And select template "<template>" as the template from the template selection options and upload document "<document>"
  #   And user search and select folder "<folder>"
  #   And user fill field Keywords "<keywords>" and field Synopsis "<synopsis>"
  #   And user save as draft the form
  #   Then system shows "The draft record is registered successfully."

  #   Examples:
  #       | username | password | template | document | folder | keywords | synopsis |
  #       | rewina_EU  | SqlP@ssw0rd_2023 | default | dummypdf.pdf | QA TECHNICAL TEST-ELECTRONIC FOLDER | test keywords | test synopsis |


  Scenario: Filing an Existing Record to the Same Folder
    Given user logs in with username "<username>" and password "<password>"
    When user navigate to document filling form
    And select template "<template>" as the template from the template selection options and upload document "<document>"
    And user search and select folder "<folder>"
    And user fill field Keywords "<keywords>" and field Synopsis "<synopsis>"
    And user save the form
    Then system shows "Record upload failure. The record already exists in the same file reference."

    Examples:
        | username | password | template | document | folder | keywords | synopsis |
        | rewina_EU  | SqlP@ssw0rd_2023 | default | dummypdf.pdf | QA TECHNICAL TEST-ELECTRONIC FOLDER | test keywords | test synopsis |