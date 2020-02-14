# refactoring

used JDK - JDK 11.0.6

The app prints out information about people (the list is provided via file) 
from different groups (the list is provided via file), who are older then given age

# How to package the application

<code>mvn package</code>

# How to run the application

<code>java -cp target\basic-task-1.0-SNAPSHOT.jar ru.esphere.school.App</code>

# How to run tests

<code>mvn test</code>

# Class App

The main method creates object of Finder class and calls method findOldMembers() 
For finding members of the groups older then given age. 

1st parameter:
use an object of GroupsManager class and method fillGroups() for building List of GroupOfMembers
and pass custom filesPath (file with groups listing and file with members listing).

2nd parameter:
pass the method inputData() of the class UserDataInput for getting int value of the target age from the user.
 