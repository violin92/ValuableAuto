# Getting Started

## The app consists of 3 layers:

    -Client - Website GUI
    -Server - RESTful API HTTPS server
    -MySQL server
    
-Client communicates with the HTTPS Server by sending a REST API request
-Server retrieve data from the MySQL DB and give a response back to the client

## Use cases:
	-Sign Up
	-Log in
	-Advertise a new vehicle
    	-Search a vehicle
    	-Buy the vehicle (for test purposes the buyer and seller can be the same person)
	-Ellaborate (Report) Use Case: shows a list which contains all the trades
		-Every trade consists of buyer, seller and vehicle
		-See the details of a trade

## New Features Comming Soon:
	- Services for appraisers
       	- See and approve the unapproved vehicles
       	- Add a report (with adding report will be automatically added a bill)
	- Migration to MongoDB
	- Generate fake data
