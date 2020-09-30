# NFTA-Project
NFTA Project(CSE 611 Development)
Dependencies:
MySql 5.7
Java 8
Tomcat 8

Tools required:
1) Spring tool suite IDE for Backend server development link: https://spring.io/tools
2) Mysql Workbench for Mysql work view and executing queries.
3) Mysql 5.7.28 server from https://downloads.mysql.com/archives/community/

For MySQL server
1) setup the installation and setup the username/passowrd.
2) Update the credentials in the application.properties under src/main/resources folder of the codebase.

## Requirements and Description

### NFTA Requirements Document
  
#### 1. Introduction
##### 1.1 Overview
The purpose of this project is to develop a mobile application and web console for Niagara Frontier Transportation Authority to reduce the communication gap between infield maintenance crew and the service planning department. The objective of this project is to keep a better track of infield assets and their locations. 

##### 1.2 Scope of the Product
The product is a mobile application supported on Android operating system and a website for content management. The application does not need to be launched on the play store, it will be directly installed on the devices in use. Integration of our product with any other system in Out Of Scope.

##### 1.3 Business Case for the Product
The end-users of this application are the infield maintenance crew and service planning department at NFTA. Currently, the information about changes to bus stop inventory is communicated through phone calls, paper documents or not communicated at all. Thus there is no solid method to query old records or stop history. The application will make maintaining records, resolving issues and tracking changes easier for the service planning department.

#### 2. General Description 
The goal of this project is to develop a tool of communication between infield maintenance crew and service planning department. The mobile application will be used by the maintenance crew at NFTA to record the changes made to stops and accordingly notify the service planning department. The service planning department will use the web console to raise requests for in-field crew and view and update the stop changes. 
##### 2.1 Product Perspective
We are developing this product to ease and automate the process of changing the location of the stops at NFTA. This product will be owned by NFTA  and primary stakeholders would be field crew of NFTA and app administrator. NFTA has proposed this project on which we are working as a part of our MS Project Development under the guidance of instructor Mr.Alan Hunt.
##### 2.2 Product Functions
Major functions of the application would be:- 
Give the infield operator the ability to record new stops. 
The infield maintenance crew will be able to enter information about the updated stop in the application including its details like coordinates and site photos etc.
View and process the service requests raised by the service planning department.
Ability to view the history of stops updated by the infield crew. (good to have)
In-app notification for the new service request raised by the service planning department.
Email to the service planning department for the stop updates.
Major functions of the web console would be:-
Provide users management to the service planning department.
Provide service planning department with the ability to raise service requests for the infield maintenance crew.
Review the stop update information and provide the ability to flag the stop updates as ‘Complete’
Fetch the previous stop update records and download them.
##### 2.3 User Characteristics
Our Application will support two kinds of users:
InField maintenance crew
Admin (Service Planning Department)
The mobile application will be used by the infield maintenance crew and the website will be used by the service planning department.

##### 2.4 Assumptions and Dependencies
We are assuming that the users have a basic experience of working with android devices and are able to use android applications. 
#### 3. Specific Requirements
##### 3.1 User Requirements
Following are the set of functionalities which will be supported by the users in the application.

InField Maintenance crew:
Recording Infield Stop changes: Application will have features to capture the GPS location, Image capture, Text input form of the infield stops.
GPS location should  be updated automatically while using the application
Image Capture: Image can be captured either from the camera or fetched from the images saved over the device. At most 3 images can be sent for a particular record. (to be discussed)
Form: Application will provide the form with the custom fields to be filled with the information by the crew members. 
Once crew members fill the respective stop related information they will be able to submit the details which will be captured in the Content management system and notify the administration regarding the update. 
Notification: users will be notified by in-app notification.
The crew will be able to view and process the incoming service requests from the Service planning department (admins).
The crew will be able to view the history of the processed stops update request. (Good to have)

Admin (Service Planning Department)
User Management: The website will support the user’s functionality for the Admin users.
Login.
Create users.
Edit user details.
Change password.
Delete Users.
Logout.
Monitor Stop Service Requests: Admins will be able to track the information updated by the infield crew members. 
Admin users can view the request and change the respective request status to open, ongoing or completed. 
Admin users can select the record from the list on the website to view or edit the detailed information of the stop update.
Admin users will be able to view the stops request’s transaction history.
Admin users will be able to raise requests for the infield crew to make any changes on the website.
Admin users will be able to add and update route List.

##### 3.2 System Requirements

The application must be able to effectively store and access data to/from the database.
The application will allow crew members to upload various formats of data likewise: Images, text, numbers etc.

##### 3.3 Interface Requirements
Wireframes
#### 4. Appendices
Bus Stop App Asset Management Data Fields link








