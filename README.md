# refactoring
The app prints out information about people (the list is provided via file) 
from different groups (the list is provided via file), who are older then given age

# How to package the application

mvn package

# How to run the application

java -cp target\basic-task-1.0-SNAPSHOT.jar ru.esphere.school.App

# How to run tests

mvn test

# Class App

The main method creates object of Finder class and calls method findOldMembers() 
For finding members of the groups older then given age. 

1st parameter:
use an object of GroupsManager class and method fillGroups() for building List of GroupOfMembers
and pass custom filesPath (file with groups listing and file with members listing).

2nd parameter:
pass the method inputData() of the class UserDataInput for getting int value of the target age from the user.
 