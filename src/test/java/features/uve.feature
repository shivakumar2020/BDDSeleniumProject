Feature: Verify TodoMVC List scenarios

Scenario: Verify TodoMVC user able to launch url and access todo list
    Given Launch the Browser with provided url
    When Show Home Page  
    Then Verify able to see todo list
    
Scenario: Verify to create list of three in todo items
    Given Launch the Browser with provided url
    When Add "Item1","Item2","Item3"  to Todolist
    Then Verify the three items added to List
    
Scenario: Verify to remove two items in todo items
    Given Launch the Browser with provided url
    When Add "Item1","Item2","Item3"  to Todolist
    And Remove "Item1","Item2" from Todolist
    Then Verify the remaining items in to List
    
    