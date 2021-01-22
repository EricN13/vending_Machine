Given there are no items in stock
When I check the vending machine
Then I should see it is empty

------------------------------------

Given there are no items in stock
When I add some items
Then I should see them in the vending machine

---------------------------------------------------

Given there are some balance
When I check the balance of the vending machine
Then I should see the current balance

-------------------------------------

When I withdraw money from the vending machine
Then I should see the balance decrease

When I deposit money to the vending machine
Then I should see the balance increase


---------------------------------

Given there are items in stock
When I check what is available
Then I should see the name, price and code of the items

---------------------------------------------

Given I have inserted some money into the vending machine
When I check amount inserted
Then I should see the amount


---------------------------------------------------

Given I have inserted enough money for an item
When I enter the item code
Then I get the item
And the balance of the vending machine goes up by that amount
And the item is removed from the stock

-----------------------------------------------------------

Given I have inserted some amount of money
When I enter a non-existent item code
Then the vending machine shows no such item

-------------------------------------------------------

Given I have inserted some amount of money
When I enter an item code of an item that costs more that I have inserted
Then the vending machine shows insufficient fund

-----------------------------------------
Given I have inserted some amount of money
When I enter an item code of an item that costs less that I have inserted
Then I get the item and the change
-----------------------------------------------

Given I have inserted some amount of money
When I press the cancel button
Then I get the full amount refunded