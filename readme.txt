Used text files to input Person, Organization and Team tables.

There are 5 classes:

Helper Class
1. Person.java
2. Organization.java
3. Team.java
Main Class
4. OrgChart.java
Test Class
5. OrgChartTest.java

How to execute the program:
javac OrgChart.java 
java OrgChart --argument--

Argument: Name level(Optional)

Assumptions:
1. Used "|" in the files as delimiter and data will be given in this format
2. The person ID is considered to be unique
3. Each first name and last name are unique and if there are multiple entries for the 
same firstName/lastName, we display the OrgChart for 1st match. 
4. Each person corresponds to one organization
5. Each personID should be present in Person table
6. Every teamMember has one Manager
7. There will be no cycle in the hierarchy i.e for example X is manager
of Y and Y is manager of Z, Z cannot be manager of X
8. Minimum aceptable level as input is 1
9. If the input is a level higher than the maximum level, we display OrgChart till the maximum level. 

Input files:

1. Personal.txt
2. Team.txt
3. Organization.txt

Sample outputs:

Input: java OrgChart John

Output:

John Doe Product Engineering Manager 111-111-1111
Tom Apple Team Lead Product Engineering 222-222-2222
Harry Orange Developer Product Engineering 333-333-3333
Amit Das Team Lead Product Engineering 444-444-4444
Sam Smith Team Lead Product Engineering 555-555-5555
Matt Henry Manager Product Engineering 666-666-6666

Input: java OrgChart John 1

John Doe Product Engineering Manager 111-111-1111
Tom Apple Product Engineering Team Lead 222-222-2222
Harry Orange Product Engineering Developer 333-333-3333

Input: java OrgChart John 2

John Doe Product Engineering Manager 111-111-1111
Tom Apple Team Lead Product Engineering 222-222-2222
Harry Orange Developer Product Engineering 333-333-3333
Amit Das Team Lead Product Engineering 444-444-4444
Sam Smith Team Lead Product Engineering 555-555-5555

Input: java OrgChart John 3

John Doe Product Engineering Manager 111-111-1111
Tom Apple Team Lead Product Engineering 222-222-2222
Harry Orange Developer Product Engineering 333-333-3333
Amit Das Team Lead Product Engineering 444-444-4444
Sam Smith Team Lead Product Engineering 555-555-5555
Matt Henry Manager Product Engineering 666-666-6666