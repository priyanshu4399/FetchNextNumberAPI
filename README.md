# FetchNextNumberApi

Assumptions
1. Availability of database
Requirements
2. The API FetchNextNumber shall take a CategoryCode as parameter in JSON
3. Search a table where CategoryCode and value are stored and fetch value. [No result
shall be considered as 0 value]
4. Update the table with a number such that it is:
a. greater than the fetched Value
b. sum of the individual digits become 1 [for example if fetched number is 10, then
the next number should be 19 as 1+9 = 10 => 1+0 = 1]
c. the number is the smallest next available number
d. While calculating the next number, introduce a delay of 5 seconds overall to the
minimum.[simulating other processing]
5. The return value is in JSON with OldValue and NewValue
6. API shall be simultaneously executed by multi users and the outcome should be unique.
Example System
Api: http://localhost:8080/FetchNextNumber/ >> Fetches the available number and next number
