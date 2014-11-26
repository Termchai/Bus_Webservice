# KU Smart Bus Service
Showing all KU buses lines and locations in real time in the KU Bangkhen campus.

## What's it for?
* Web Application: KU students and staffs (who do not have smart devices that have internet access) in Bangkhen campus can easily look up the locations of the KU buses through accessing website so that they can plan their time to travel in the campus.
* Mobile application: KU students and staffs in Bangkhen campus who have smart devices that have internet access can easily look up the locations of the KU buses through applications anywhere.

## User Stories
* As a user, I want an application that can tell me in real time the location of buses so that I can plan the time.
* As a user, I want to know my current location in the campus.
* As a user, I want to know the location of my desired bus line.
* As a user, I want to get notify when my desired bus almost arrive at the stop so that I have to reach the stop as fast as I can.
* As a user, I want to know which bus can take me from my location to my destination.
* As a user, I want to know how long (in minutes) does it take me to travel from my location to my destination.
* As a user, I want to know which bus lines pass my selected bus stop.
* As a user, I want to know when will the bus arrive at my selected bus stop.

## Use Cases
Precondition: A user launch the application and the device has internet connection.
* See my own current location process: User select the function to see the overview of the campus. Finally, the user can see his current location in the campus.
* Get notification process: The user select notification function in the application. The user select his desired bus stop. The user select the desired bus line. The user enter the range (how far between the desired bus and the bus stop). Once everything is input, the user finish the process.
* Notify user process: Once the bus of the desired bus line arrives in the specified range from the bus stop, the application would notify user either by vibration of the smart devices or ringing sound so user would know that the bus almost arrives at the stop.
* See buses locations process: User select top view function of the application. User can see overview of buses locations around the campus.

## API

[API](https://github.com/Termchai/Bus_Webservice/wiki/Smart-Bus-Service-API-Specification)

## Mock-ups
...coming soon...

## Stakeholder
* User (students, faculties, staffs)

## Example Request
*

## How is it?
* JAX-RS RESTful web service.

## Contributors
* Sarit Suriyasangpetch 5510546191
* Supavit Kongwudhikunakorn 5510546671
* Suttanan Charoenpanich 5510547031
* Termchai Sadsangchan 5510546042
