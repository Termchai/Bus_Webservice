# KU Smart Bus Service
Showing all KU buses lines and locations in real time in the KU Bangkhen campus.

## Purpose
* Web Application: KU students and staffs (who do not have smart devices that have internet access) in Bangkhen campus can easily look up the locations of the KU buses through accessing website so that they can plan their time to travel in the campus.
* Mobile application: KU students and staffs in Bangkhen campus who have smart devices that have internet access can easily look up the locations of the KU buses through applications anywhere.

## User Stories
* As a user, I want (an application that can tell me)  in real time the location of buses so that I can plan the time.
** ''I don't want an application, I just want the result!''
* As a user, I want to know my current location in the campus.
** ''I already have Google Maps. I don't want another app for this!'' Besides, this is easy -- just copy example from 
Android developers site. You won't earn any credit for this.
* As a user, I want to know the location of my desired bus line.
* As a user, I want to get notify when my desired bus almost arrive at my stop, so that I can be there on time for the bus.
* As a user, I want to know which bus can take me from my location to my destination.
* As a user, I want to know how long (in minutes) does it take me to travel from my location to my destination.
* As a user, I want to know which bus lines pass my selected bus stop.
* As a user, I want to know when will the bus arrive at my selected bus stop.

## Use Cases
Precondition: A user launch the application and the device has Internet connection.
* See my own current location process: User selects the function to see a map of the campus. Finally, the user can see his current location in the campus.
** ''can'' is not use case style.  You learned this is SS&D.
* Get notification: The user selects notification function in the application. The user selects his desired bus stop. The user selects the desired bus line. The user enters the range (how far between the desired bus and the bus stop). Once everything is input, the user finish the process.
** ''So what? He did all this work but didn't get anything!'' ''This isn't a user goal. You should combine this with next "use case" into one.''
* Notify user: Once the bus of the desired bus line arrives in the specified range from the bus stop, the application would notify user either by vibration of the smart devices or ringing sound so user would know that the bus almost arrives at the stop.
** Don't use the word "process".  User doesn't want a process -- he wants what he wants. Besides, "process" and "system" are vague words to be avoided in use case names.
* See buses locations '''process''': User selects top view function of the application. User can see overview of buses locations around the campus.
* See buses lines locations '''process''': User selects top view function of the application. After that, user selects filter buses by line id.

## API

[API](https://docs.google.com/document/d/1bQ04_zdIkMoU-EarHBBjsYQv5mKZXpe37UpgESOocSA/edit)

## Mock-ups
[MOCK-UPs](...link...)

## Stakeholder
* User (students, faculty, staff)

## Contributors
* Sarit Suriyasangpetch 5510546191
* Supavit Kongwudhikunakorn 5510546671
* Suttanan Charoenpanich 5510547031
* Termchai Sadsangchan 5510546042

* Team Name: T3S
