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

## IMPORTANT NOTE 2: After you complete the PRELAB tasks, do not forget to commit your changes and push them to your repository on Github.
-------------------------------------------------------------------------------------------------------------------------------
## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

# Lab-5 Prelab: A Type Hierarchy for Vehicles #

In this programming lab, you are asked to build a Java type hierarchy aimed to represent the described types for vehicles and their up to date conditions using **inheritance and polymorphism related concepts**. You are provided with a Java project template and you should do your development on this template. In the given Java project, a main program code Test.java in package work is provided to test your code. Note that we may test your codes with other test cases as well. You should see another package called vehicles, which includes all the types described below. You should decide whether each type should be an abstract class, a concrete class, superclass, subclass, or an interface.

- `Vehicle:` Refers to the general base entity that can be driven.
- `FueledVehicle:` A kind of vehicle that runs on petroleum, it can be driven and refueled. 
- `Car:` A kind of fueled vehicle.  
- `Motorbike:` A kind of fueled vehicle.  
- `Drivable:` All Vehicle objects are drivable objects. They should implement their own void drive() method.
- `Refuelable:` All FueledVehicle objects are refuelable objects. They should implement their own void refuel() method.

**Important Note:** For each class implementation, you need to decide which access modifiers should be used for instance variables (e.g. private, protected or public). The fields and methods of these types are described below:

-------------------------------------------------------------------------------------------------------------------------------

#### A `Vehicle` has the following members:
- A `static` field `vehicleQuantity` of type `int` with an initial value of zero. Holds the total number of vehicle objects generated so far.
- A field `brandAndModel` of type `String`, carries the brand and model information of the vehicle,
- A field `vehiclePrice` of type `double`, denotes the price of the vehicle in USD,
- A field `vehicleMaxRange` of type `double`, denoting the maximum range of the vehicle when its tank is full,
- A field `vehicleCurrentRange` of type `double`, denoting the current range of the vehicle,
- A `static` method `int getVehicleQuantity()` that returns the field `vehicleQuantity`
- Getter and setter methods for the non-static fields
- An `abstract` method `void setVehicleMaxRange()`( In addition to the plain setter) that can be implemented differently for different subtypes of `Vehicles`.
- An `abstract` method `void setVehicleCurrentRange()` (In addition to the plain setter) that can be implemented differently for different subtypes of Vehicles.
- An `abstract` method `void drive()` that can be implemented differently for different subtypes of Vehicles.
- A constructor `Vehicle(String brandAndModel, double vehiclePrice)`, initializes `brandAndModel` and `vehiclePrice` fields with input arguments and increments the `vehicleQuantity` field by one. **Note:** Make sure you check the input values inside the constructor properly. The `vehiclePrice` cannot be less than zero and the `brandAndModel` should not be empty.
- An `abstract` method `String toString()` that would print out the information about the vehicle and can be implemented differently for different subtypes of Vehicles.

-------------------------------------------------------------------------------------------------------------------------------

#### A `FueledVehicle` has the following members:
- A field `fuelTank` of type `double`, signifies the storage capacity of the tank of the `FueledVehicle`,  in terms of liters. 
 
**Note** that the field `fuelTank` cannot be less than 10.

- A field `fuelLevel` of type `double`, denotes the current fuel level of the tank of the `FueledVehicle`, in terms of liters. **Bear in mind** that the field `fuelLevel` cannot be less than zero and cannot be greater than `fuelTank`.

- A field `fuelToRangeRatio` of type `double`, denotes the ratio that is used to convert the current `fuelLevel` (in liters) to the `vehicleCurrentRange` (in kms) of the `FueledVehicle`. **Important Note:** For this assignment, we will assume that the relation between the `fuelLevel` and the `vehicleCurrentRange` is linear, i.e., `vehicleCurrentRange (km) = fuelLevel (lt) * fuelToRangeRatio (km/lt)`. 
 
**Note** that the field `fuelToRangeRatio` cannot be less than 1.

- The methods `void setVehicleMaxRange()`, `void setVehicleCurrentRange()`. ***Notice that*** these methods carry the same name with the ones that are shared in the `Vehicle` type description. As their names suggest, these methods should be implemented in a way to update the `FueledVehicle`’s maximum and current ranges accordingly. 

**Hint:** Use the simple linear equation that is shared above in order to implement the `setVehicleCurrentRange()` method. Following a similar intiution, implement `setVehicleMaxRange()`, while doing so, bear in mind that the maximum `fuelLevel` that a `FueledVehicle` can has is its `fuelTank`. 

- A constructor `FueledVehicle(String brandAndModel, double vehiclePrice, double tank, double fuel, double ratio )` 
 
**Important Note:** The constructor should check the input arguments according to the notes shared above and initialize the object fields with the given input parameters. ***In addition to initializing the instance variables***, the constructor should also **set** both the `FueledVehicle`’s maximum and current ranges.

- Getter methods for the `fuelLevel`, `fuelTank`, and `fuelToRangeRatio` fields

- The method `void refuel(double fuelLevel)`. As stated earlier, all `FueledVehicle` objects are `Refuelable` objects. Hence, the `FueledVehicle` type should implement its own `refuel(double fuelLevel)` method. The method refuels the tank of the `FueledVehicle` according to the mathematical formulation that was described above in the `fuelToRangeRatio` subsection. Then the method prints the name of the refueled vehicle and its updated range. To be more specific, the method first checks if the input argument `fuelLevel` is reasonable (greater than 0, lower than `fuelTank`). If it is greater than 0 and lower than `fuelTank`, the method updates the `FueledVehicle`’s `fuelLevel` field accordingly. If the input argument is equal to or greater than `fuelTank`, the method must assign `fuelTank` as the current `fuelLevel`.The method finally sets the `Vehicle`'s updated range and prints its actions. Take a closer look at the sample output to see method’s behavior in more detail.

- The method `void drive(double km)`. As mentioned previously, all `Vehicle` objects are `Drivable` objects. Since a `FueledVehicle` is a kind of `Vehicle`, it must implement its own `drive(double km)` method. The method first checks whether input argument is reasonable, i.e. greater than zero. If it is, then it checks the input argument against the `FueledVehicle`s current range. If input argument `km` is within `FueledVehicle`s current range, then the method drives the `FueledVehicle`, meaning it updates its `fuelLevel` according to the same criteria outlined during the description of the `fuelToRangeRatio` section. The method should finally set the `FueledVehicle`s current range and print the name of the fueled vehicle, its updated range and fuel level. Take a closer look at the sample output to see the method’s behavior in more detail.
- A `toString()` method that returns the information about the `FueledVehicle`’s `brandAndModel`,  `price`, `fuelLevel`, `maxRange`, `currentRange`.

-------------------------------------------------------------------------------------------------------------------------------

#### A `Car` has the following members:
- A `static` field `id` of type `String` with the value designated as`Car`. This field should be initialized once and in a way that it cannot be altered after that.
- A `static` field `carQuantity` of type `int` with an initial value of zero. Holds the total number of `Car` units generated so far.
- A constructor `Car(String brandAndModel, double vehiclePrice, double tank, double fuel, double ratio)` that Initializes necessary fields with the input arguments and increments the `carQuantity` field by one.
- A `toString()` method that would print out the information about the `Car`. Note that this method should print out the `id` field of the `Car`, in addition to other information that the `Car` inherits. Take a closer look at the sample output to see the `Car`’s `toString()` method’s behavior in more detail.

-------------------------------------------------------------------------------------------------------------------------------

#### A `Motorbike` has the following members:
- A `static` field `id` of type `String` with the value designated as`Motorbike`. This field should be initialized once and in a way that it cannot be altered after that.
- A `static` field `carQuantity` of type `int` with an initial value of zero. Holds the total number of `Motorbike` units generated so far.
- A constructor `Motorbike(String brandAndModel, double vehiclePrice, double tank, double fuel, double ratio)` that Initializes necessary fields with the input arguments and increments the `carQuantity` field by one.
- A `toString()` method that would print out the information about the `Motorbike`. Note that this method should print out the `id` field of the `Motorbike`, in addition to other information that the `Motorbike` inherits. Take a closer look at the sample output to see the `Motorbike`’s `toString()` method’s behavior in more detail.
```
------------------------------------------- Sample Output ---------------------------------------

Total number of Vehicles before creating vehicles: 0

Total number of Vehicles after creating vehicles: 4
Total number of Cars after creating vehicles: 3
Total number of Motorbikes after creating vehicles: 1

Vehicle Type: Car
Fueled Vehicle Name: BMW 530 
Fueled Vehicle Price: 54000.0 $ 
Fueled Vehicle Max Range: 560.0 kms 
Fueled Vehicle Current Fuel Level: 30.0 liters 
Fueled Vehicle Current Range: 240.0 kms

Vehicle Type: Car
Fueled Vehicle Name: Mercedes-Benz E300 
Fueled Vehicle Price: 66000.0 $ 
Fueled Vehicle Max Range: 630.0 kms 
Fueled Vehicle Current Fuel Level: 10.0 liters 
Fueled Vehicle Current Range: 90.0 kms

Vehicle Type: Car
Fueled Vehicle Name: Volvo S60 
Fueled Vehicle Price: 40000.0 $ 
Fueled Vehicle Max Range: 720.0 kms 
Fueled Vehicle Current Fuel Level: 25.0 liters 
Fueled Vehicle Current Range: 300.0 kms

Vehicle Type: Motorbike
Fueled Vehicle Name: Harley-Davidson 
Fueled Vehicle Price: 20000.0 $ 
Fueled Vehicle Max Range: 375.0 kms 
Fueled Vehicle Current Fuel Level: 5.0 liters 
Fueled Vehicle Current Range: 125.0 kms

Fueled Vehicle BMW 530 could only drive 240.00 kilometers, 0.00 liters of fuel left 
Please Refuel !!
Fueled Vehicle Current Range: 0.00 kilometers 

Fueled Vehicle Mercedes-Benz E300 drove 50.0 kilometers, 4.44 liters of fuel left 
Fueled Vehicle Current Range: 40.00 kilometers 

Fueled Vehicle Volvo S60 drove 240.0 kilometers, 5.00 liters of fuel left 
Fueled Vehicle Current Range: 60.00 kilometers 

Fueled Vehicle Harley-Davidson drove 120.0 kilometers, 0.20 liters of fuel left 
Fueled Vehicle Current Range: 5.00 kilometers 

Fueled Vehicle BMW 530 couldnt drive...  0.00 liters of fuel left 
Please Refuel !!
Fueled Vehicle Current Range: 0.00 kilometers 

Fueled Vehicle Mercedes-Benz E300 could only drive 40.00 kilometers, 0.00 liters of fuel left 
Please Refuel !!
Fueled Vehicle Current Range: 0.00 kilometers 

Fueled Vehicle Volvo S60 could only drive 60.00 kilometers, 0.00 liters of fuel left 
Please Refuel !!
Fueled Vehicle Current Range: 0.00 kilometers 

Fueled Vehicle Harley-Davidson could only drive 5.00 kilometers, 0.00 liters of fuel left 
Please Refuel !!
Fueled Vehicle Current Range: 0.00 kilometers 

Fueled Vehicle BMW 530's tank is fully refueled!!
Fueled Vehicle BMW 530's Current Range: 560.00 kms 

Fueled Vehicle Mercedes-Benz E300's tank is refueled! Added: 50.00 liters of fuel! 
Fueled Vehicle Mercedes-Benz E300's Current Range: 450.00 kms 

Fueled Vehicle Volvo S60's tank is refueled! Added: 50.00 liters of fuel! 
Fueled Vehicle Volvo S60's Current Range: 600.00 kms 

Fueled Vehicle Harley-Davidson's tank is fully refueled!!
Fueled Vehicle Harley-Davidson's Current Range: 375.00 kms 

Fueled Vehicle BMW 530 could only drive 560.00 kilometers, 0.00 liters of fuel left 
Please Refuel !!
Fueled Vehicle Current Range: 0.00 kilometers 

Fueled Vehicle Mercedes-Benz E300 drove 445.0 kilometers, 0.56 liters of fuel left 
Fueled Vehicle Current Range: 5.00 kilometers 

Fueled Vehicle Volvo S60 drove 300.0 kilometers, 25.00 liters of fuel left 
Fueled Vehicle Current Range: 300.00 kilometers 

Fueled Vehicle Harley-Davidson drove 150.0 kilometers, 9.00 liters of fuel left 
Fueled Vehicle Current Range: 225.00 kilometers 

-----------------------------------------------------------------------------------------------------
