## IMPORTANT NOTE 1:
For each lab assignment, **you must include and sign (by writing your name and intern id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
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
SIGNATURE: <Name Surname, Intern id>
********************************************************************************/
```

## IMPORTANT NOTE 2: After you complete the PRELAB tasks, do not forget to commit your changes and push them to your repository on Github.

## IMPORTANT NOTE 3: This README.md file only contains the instructions for the PRELAB. You will also have INLAB questions.

# Lab-6 Prelab: Training Management Program

In this programming lab, you are asked to implement a simple training management program using the concepts of **Java Collections Framework**. You are provided with a Java project template and you should do your development on this template. In the given Java project, a main program code Main.java is provided to test your code. Note that we may test your codes with other test cases as well. 

- `Main:` **This class and the test code are already provided to you.** You should create a package named *management* and move this class there. 

Create or move all the following classes to *organization* package you will create.
- `Engineer:` The class that holds the engineer related information. **This class is already provided to you.**
- `Branch:` The class that holds the information of a branch. **This class is partially provided and you can follow the TODO comments to complete this class.**
- `Intern:`  The class that holds the information of an intern and handles the operations regarding training enrollment.  
- `Training:` The class that holds the information of a training.   

**Important Note:** For each class implementation, you need to decide data structures from the Java Collection Framework to use. The requirements for each field that will help you choose the appropriate data structure (List, Set or Map) are indicated below:

-------------------------------------------------------------------------------------------------------------------------------

#### A `Training` has the following members:
- A field `name` of type `String`, 
- A field `code` of type `String`, denotes the code of the training,
- A field `term` of type `String`, denoting the term which the training is given (such as Fall21),
- A field `engineer` of type `Engineer`,
- A field `branch` of type `Branch`,
- A field `capacity` of type `int`, which is immutable,
- A field `credits` of type `double`, which is immutable,
- A field `interns` with a type you will decide. The interns should be kept in the order they are added where the elements are not stored in contiguous locations.
- A field `waitlist` with a type you will decide. The interns in the waitlist should be kept in the order they are added where the elements are not stored in contiguous locations


- First add getters, setters and a toString method to this class as usual.
- Create constructor with the signature `Training(String name, String code, String term, Engineer engineer, Branch branch, int capacity, double credits)`.
- Inside the constructor, you should add the training to branch's and engineer's training list using the related methods provided to you in those trainings.

- Implement `boolean addIntern(Intern intern)` method, which adds the intern to the interns field if the capacity of the training is not exceeded and returns true. If the training is full, you should add the intern to the waitlist and return false.
- Implement `boolean removeIntern(Intern intern)` method, which removes the intern from interns field if there is such intern in the list. After removel, remove the first added intern from waitlist and add it to training interns. Return true if the removal of given intern was successful.
Do not forget to add this training to the training list of the new intern and remove it from the removed intern's training list.

-------------------------------------------------------------------------------------------------------------------------------

#### An `Intern` has the following members:
- A field `name` of type `String`, 
- A field `ID` of type `String`, 
- A field `grades` with a type you will decide. This field should be able to keep String codes of the trainings that interns have enrolled, and given the training code, it should return the grade the intern got from the corresponding training as a double. 
- A field `takenTrainings` with a type you will decide. The trainings should be kept in the order they are added.

- First add getters, setters and a toString method to this class as usual.
- Create constructor with the signature `Intern(String name, String ID)`.

- Implement `void enroll(Training c)` method, which uses the result of `boolean addIntern(Intern intern)` method of training and add the training to the training list and grades structure with a grade of 0.0.
- Implement `void unenroll(Training c)` method, which uses the result of `boolean removeIntern(Intern intern)` method of training and remove the training from the training list and removes from grade structure.
- Implement `void addGrade(Training internTraining, double grade)` method, which adds the given grade of the given training to grades structure if the training exists in it.
- Implement `double calculateSPA(String term)` method, which calculates the SPA for that term. You should multiply the grades of the trainings that intern is enrolled that term with the training credit and find the average grade by diving it to total credits.
- Implement `Comparable` interface, which can be used to sort interns by their ID.

-------------------------------------------------------------------------------------------------------------------------------

#### A `Branch` has the following members:

- A field `name` of type `String`, 
- A field `code` of type `String`, denotes the code of the branch,
- A field `engineers` with a type you will decide. The engineers should be kept in the order they are added where the elements are not stored in contiguous locations.
- A field `interns` with a type you will decide. The interns data structure cannot have duplicate elements and insert new items while preserving the ID order of the interns. (ascending order by ID) 
- A field `offeredTrainings` with a type you will decide. The interns should be kept in the order they are added.

- Create constructor with the signature `Branch(String name, String code)`.

- Implement method `void printTrainings()` which prints all the trainings using the toString method of Training class. You should use **iterators** to implement this method, otherwise you will not receive any points for this part.
- Implement method `void printCommonEngineers(Branch other)` which takes another branch, and prints the common engineers of the branch and the given branch.

You can use the following method to remove elements that does not exists in the other list:

`list1.retainAll(list2)`



```
Intern John Wick is added to the training ICDL.
Intern John Wick is added to the training E-commerce.
Intern John Wick is added to the training IT management.
Intern John Wick is added to the training IT management.
Intern Elaine Benes is added to the training ICDL.
Intern Elaine Benes is added to the training E-commerce.
Intern Elaine Benes is added to the training IT management.
Training E-commerce is full, Rogan Roy added to the waitlist.
Intern Rogan Roy is added to the training sales and marketing ethic.
Intern George Constanza is added to the training Network.
Intern George Constanza is added to the training IT management.
Intern George Constanza is added to the training sales and marketing ethic.

Intern John Wick SPA grade in term Fall21: 3.666667
Intern John Wick SPA grade in term Spring21: 3.222222
Intern John Wick is removed from the training E-commerce.
Intern Rogan Roy is added to the training E-commerce.
Intern John Wick SPA grade in term Spring21: 3.000000

Trainings in the Tech branch: 

Training: ICDL
Code: Tech01
Term: Fall21
Engineer: Mr. Muhammed Noori
Capacity: 5
Credits: 4.0

Training: E-commerce
Code: Tech02
Term: Spring21
Engineer: Mr. Muhammed Noori
Capacity: 2
Credits: 4.0

Training: IT management
Code: Tech03
Term: Fall21
Engineer: Mr. Ali Yilmaz
Capacity: 5
Credits: 2.0

Training: Network
Code: Tech04
Term: Spring21
Engineer: Mr. Cem Ege
Capacity: 2
Credits: 3.0

Trainings in the Man branch: 

Training: IT management
Code: man104
Term: Spring21
Engineer: Mr. Kemal Gul
Capacity: 4
Credits: 5.0

Trainings in the Eth branch: 

Training: sales and marketing ethic
Code: man104
Term: Spring21
Engineer: Mr. Murat Yildirim
Capacity: 4
Credits: 5.0

Interns in the Tech branch: 

Intern: Walter White
ID: 0

Intern: Rogan Roy
ID: 1

Intern: John Wick
ID: 2

Intern: Bobby Axelrod
ID: 3

Interns in the Man branch: 

Intern: Elaine Benes
ID: 4

Intern: Michael Scott
ID: 8

Intern: Luna Lovegood
ID: 9

Interns in the Eth branch: 

Intern: George Constanza
ID: 5

Intern: Cosmo Kramer
ID: 6

Intern: Chandler Bing
ID: 7

Common engineers of the Tech branch and Man branch: 
Mr. James Kelly

Common engineers of the Man branch and Tech branch: 
Mr. James Kelly

Common engineers of the Tech branch and Eth branch: 
There are no common engineers of the Tech branch and Eth branch. 
```
-----------------------------------------------------------------------------------------------------
