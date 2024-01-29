@ChangeProfilePic
Feature: ChangeProfilePic through API Automation

  Scenario Outline: Verify ChangeProfilePic to the application through API Autmation
    Given user adds headers and passes <Authorization>,<Bearer >+<logtoken> and <Content-Type>, <multipart/form-data> as header to change the profile pic
    When user send the formdata <profile_picture>, <ProfilePic> as payload to change profile pic
    And user sends "POST" request to ChangeProfilePic endpoint
    And user should verify the status code 200 from the response
    Then user verifies the response body message matched as "Profile updated Successfully"
