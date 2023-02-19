## IMPORTANT NOTE 1:
For each lab assignment, **you must include and sign (by writing your name and student id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```

## IMPORTANT NOTE 2: After you complete the task, do not forget to commit your changes and push them to your repository on Github.

## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.


# Lab-4 Prelab : KU-Request #

In this lab, you will be practicing with Inheritance and its related concepts. Inheritance is one of the key aspects that make Object-Oriented Programming (OOP) possible and incentivizes code reuse by modeling an “is-a” relation between an existing class (Superclass) and derived classes (Subclasses).

To practice with the concepts of Inheritance, you are going to implement a student issue tracking application named KU-Request like our own Koç University’s Track-it system.

In this application, there are going to be 5 classes which are: 

- Student class that is going to create new requests to the system.
- Staff class that is going to resolve the opened requests.
- Request class that specifies the common internal data of a request.
- ITRequest class that specifies a request’s data related to the Information Technology department.
- HousingRequest class that specifies a request’s data related to the Housing Management department.

You are going to represent different request types that can be created at KU-Request system using the following class hierarchy.

![class_hierarchy](https://user-images.githubusercontent.com/47361682/159703271-a1dba797-454b-4c96-8ab4-44bd8b5e344c.png)

**NOTE:** For each class implementation, you need to decide which access modifiers should be used for instance variables (e.g. private, protected or public). In some of the classes, you need to decide on which data types and names you should use for those variables as well. 

## Task 1: Implement Request Class ##

1. You are given an empty Request Class under kurequest package.
2. Complete the Request Class with these variables:
    - int requestID : ID number of the request.
    - boolean isResolved : To check if the request is resolved or not.
    - int satisfactionPoints : The points given after this request is resolved. Is between 0 and 5 (both inclusive). 
    - Student requestCreator : The Student that created this request.
    - Staff requestResolver : The Staff that is working on or finished this request.
    - LocalDateTime creationTime : The date and time when this request is created.
        - **Note**: LocalDateTime is an immutable class from the java.time package. You can create an immutable instance by using LocalDateTime.of() method.  
             - Example: LocalDateTime.of(2022,03,24,16,30)
    - String title : Title of the Request.
    - ArrayList<String> comments : The comments on the request are stored here. Must not change this after initialization of the instance.
    - ArrayList<Request> requests : All requests that are created are stored here. Must not be able to change this after initialization of the variable.
3. Write a constructor with the parameters: Student requestCreator , LocalDateTime creationTime and String title. “requestID” can be the index of the requests array where the new instance is stored.
    - **Note:** Do not forget to initialize the requestResolver with a dummy instance (Eg. with empty strings). 
4. Write getters and setter methods for all instance variables.
    - **Note:** For setting the satisfactionPoints variable, do not forget to check if the parameter is in bounds and if the request is resolved or not before setting the variable.  
5. Write a toString method which its output template should look like: 

Request:
  
ID: requestID, Title: title, Resolved: [“Yes” or “No” (as in a string)], Creation Time: [creationTime.toString()], Satisfaction: satisfactionPoints

 Creator: [Creator’s toString()]

 Resolver:  [Resolver’s toString()]

 Comments: [List All Comments]



## Task 2: Extend the Request class with ITRequest class ##

1. You are given an empty ITRequest class under kurequest package. The ITRequest class must be defined as a subclass of the Request class.
2. Complete ITRequest Class with these variables.
    - int type : Shows the type of IT request it is. 
        - If type equals to 0, then it is a **general** IT request.
        - If type equals to 1, then it is a **computer** related IT request.
        - If type equals to 2, then it is a **classroom** related IT request. 
    - String classroomName : Name of the classroom.
    - String computerName : Name of the computer that is given by the student.
    - int computerSerialNumber : The serial number of the computer that is given by the student.
    - ArrayList<ITRequest> ITRequests : All IT requests that are created are stored here. Must not be able to change this after initialization of the variable.
3. Write a constructor with the parameters: Student requestCreator, LocalDateTime creationTime, String title, int type, String classroomName, String computerName, int computerSerialNumber.
    - Must check the “type” parameter to decide on which variables to write. 
        - Example: if the “type” corresponds to a computer related IT request, then computerName and  computerSerialNumber should be initialized, classroomName should be initialized as an empty String.
4. Write getter and setter methods for all variables.
5. Write a toString method which its output template should look like: 
  
IT[superclass’s toString()]

[Classroom Location: “Name of the classroom”] or [Computer: Name: “Name of the computer”, Serial Number: “Serial number of the computer”] or “” (based on the type of the ITRequest)


  
## Task 3: Extend the Request class with HousingRequest class ##

1. You are given an empty HousingRequest class under kurequest package. The HousingRequest class must be defined as a subclass of the Request class.
2. Complete HousingRequest class with these variables:
    - int type : Shows the type of IT request it is.
        - If type equals to 0, then it is a **housing life** related housing request.
        - If type equals to 1, then it is a **planning** related housing request.
        - If type equals to 2, then it is a **financial** related housing request. 
        * If type equals to 3, then it is a **student conduct** related housing request.
    - String locationName : The location of the dormitory that the student resides in. E.g. West Campus.  
    - String roomName : The room’s name that the student resides in. E.g: A7 420
    - ArrayList<HousingRequest> HousingRequests : All Housing requests that are created are stored here. Must not be able to change this after initialization of the variable.
3. Write a constructor with the parameters: Student requestCreator, LocalDateTime creationTime, String title, int type, String locationName, String roomName.
4. Write getter and setter methods for all variables.
5. Write a toString method which its output template should look like: 

Housing[Superclass’s toString()]

Type: [“Housing Life” or “Financial” or “Planning” or “Student Conduct”], Location: “name of the location”, Room: “name of the room”


  
## Task 4: Implement Student Class ##

1. You are given an empty Student class under kurequest package.
2. Complete Student Class with these variables:
    - The ID number of the student.
    - The name of the student.
    - The name of the faculty which the student applied to.
    - ArrayList<Request> requests : Student’s created requests are stored here. Must not be able to change this after initialization of the instance.
    - ArrayList<Student> allStudents : All students that are using this application are stored here. Must not be able to change this after initialization of the variable.
1. Write a constructor with the parameters, the name of the student and the name of the faculty. The ID number of the student can be the index of the allStudents array where the new instance is stored.
2. Write getter and setter methods for these variables.
3. Write a method called “openITRequest” which creates an IT request and adds it to the requests list.
    - The method takes : 
        - ITRequestType type
        - LocalDateTime creationTime
        - String title, 
        - String classroomName,
        - String computerName,
        - int computerSerialNumber
    - Outputs a newly created ITRequest instance.
4. Write a method called “openHousingRequest” which creates a Housing request and adds it to the requests list.
    - The method takes : 
        - HousingRequestType type, 
        - LocalDateTime creationTime, 
        - String title, 
        - String locationName, 
        - String roomName
    - Outputs a newly created HousingRequest instance.
5. Write a method called “addCommentToRequest” which adds a comment to a specified request. 
    - The Method takes: 
        - An integer which specifies which request should take the comment, starts from 1. 
        - A string which is the actual comment.
    - The entry to the request should be like:  “Name of Student” “: ” “Comment”
6. Write a method called “giveSatisfactionPoints” which sets the satisfaction point of a specified request. 
    - The Method takes: 
        - An integer which specifies which request should take the comment, starts from 1. 
        - An integer which is the actual satisfaction point.
7. Write a “toString” method which its output template should look like: 

Student: ID: “ID of the student”, Name: “Name of the student”, Faculty: “Name of the faculty”



## Task 5: Implement Staff Class ##

1. You are given an empty Staff class under kurequest package
2. Complete Staff Class with these variables:
    - The ID number of the staff.
    - The name of the staff.
    - The name of the department which the staff is in.
    - The name of the position that the staff holds.
    - ArrayList<Request> requests : Created request per instance of Student, must not change this after initialization of the instance.
    - ArrayList<Student> allStaff: All students that are using this application are stored here. Must not be able to change this after initialization of the variable.
1. Write a constructor with the parameters: The name of the staff, the name of the department and the name of the position. The ID number of the staff can be the index of the allStaff array where the new instance is stored.
2. Write getter and setter methods for these variables.
3. Write a method called assignRequest which sets the request’s resolver to itself and adds it to the requests list.
    - The Method takes: 
        - An integer which specifies which request should take the comment, starts from 1. 
4. Write a method called closeRequest which closes a request by setting the request’s isResolved to true.
    - The Method takes: 
        - An integer which specifies which request should take the comment, starts from 1. 
5. Write a method called addCommentToRequest which adds a comment to a specified request. 
    - The Method takes: 
        - An integer which specifies which request should take the comment, starts from 1. 
        - A string which is the actual comment.
    - The entry to the request should be like:  “ “Name of Staff” : “Comment” ”
6. Write a toString method which its output template should look like: 

Staff: ID: “ID of the staff”, Name: “Name of the staff”, Department: “Name of the department, Position: “Name of the position” ”

 ## Testing ##  
    
To test your code, you should **only** change the 2. Student’s name and department (student2) to your name and your department. After that, run the Main.java under the main package **without changing other parts of Main.java**. 



### Sample Output ###
  
<br/>
  
HousingRequest:

ID: 0, Title: Request for Deposit Reimbursement, Resolved: Yes, Creation Time: 2022-03-10T14:45, Satisfaction: 5

 Creator: Student: ID: 0, Name: Dogan Sagbili, Faculty: Engineering

 Resolver: Staff: ID: 0, Name: Can Kucuksozen, Department: Housing, Position: Coordinator

 Comments:

  Dogan Sagbili: I have graduated, Please, give my money back.

  Can Kucuksozen: Your money is given to your account.

 Type: Planning, Location: Main Campus, Room: P 230

<br/>
  
ITRequest:

ID: 2, Title: Projector Broke, Resolved: Yes, Creation Time: 2022-02-12T13:30, Satisfaction: 4

 Creator: Student: ID: 0, Name: Dogan Sagbili, Faculty: Engineering

 Resolver: Staff: ID: 1, Name: Vahideh Hayyolalam, Department: IT, Position: Technician

 Comments:

  Dogan Sagbili: It is Urgent, Need to teach my classmates with the projector.

  Vahideh Hayyolalam: Fixed.

 Classroom Location: ENG Z50
