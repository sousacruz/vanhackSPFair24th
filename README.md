# SkipOnTheFly - VanHack SP Fair 2018
A project developed for the SkipTheDishes challenge at Vanhack Sao Paulo Fair 2.0
The SkipOnTheFly is a Rest API for client consumer including features to help couriers find orders waiting for delivery.


## Features
* As a couriers I want to...
  - list waiting orders by restaurant
  - know how many orders I can pick through certain route
  - list restaurants by location
  - list customer by location
  - list orders by target location
  - list orders by source location
  
### Services
  
It will be used a single project for rest API which includes:

### Orders API 

* specific order
   - http://localhost:8080/order/{id}
* listing of all orders
   - http://localhost:8080/order
* listing orders by the target location (customer location)
   - http://localhost:8080/order/target/{locationCode}
* listing orders by the source location (restaurant location)
   - http://localhost:8080/order/source/{locationCode}
* listing orders assigned to given courier 
   - http://localhost:8080//order/{courierId}


### Restaurant API 

* specific restaurant
   - http://localhost:8080/restaurant/{id}
* listing of all restaurants
   - http://localhost:8080/restaurant
* listing of restaurants by location
   - http://localhost:8080/restaurant/{locationCode}

   
### Customer API 

* specific customer
   - http://localhost:8080/customer/{id}
* listing of all customers
   - http://localhost:8080/customer
* listing of customers by location
   - http://localhost:8080/customer/{locationCode}
   
   
### Courier API 

* specific courier
   - http://localhost:8080/courier/{id}
* listing of all courier
   - http://localhost:8080/courier
* listing of courier by name
   - http://localhost:8080/courier/{name}
* listing of courier by availabity
   - http://localhost:8080/courier/availables
   
   
### Basic Scenario
1.	Courier will search for waiting orders.
2.	With the chosen restaurant, a list of orders will be retrieved
3.	He can choose the specified delivers to do and submit the assignment
4.	Another service is the list of the assignment.






