# NFTA Technical Design Document 
## Tech Stack
Mobile Application
Language: Java (inbuilt)
Framework: Android
IDE: Android Studio
Library: Android SDK version 24
Device RAM: 
Device Storage: 
Device OS Version: Android 7.7.1
	
## Web Development
FrontEnd
Language: JavaScript
Framework: ReactJS
IDE: Visual Studio Code
## BackEnd
Language: Java 8
Framework: Spring Boot 2.0
IDE: Spring Tool Suite
RDBMS Database: MySQL 5.5
Apache Tomcat version 8 (UNIX)
Library: Google Maps
Source Version Control Software: Git


## 2. Accounts and Infrastructure
### 2.1 Development
Development Server: Our web application will be deployed on Apache Tomcat 8 server (To confirm on server environment and tomcat server environment supported).
Mobile application: For development, we will be using the Android studio with the minimum supported SDK  library version as 24.

Database Server: MySQL version 5.5 (TBD on max version supported)

JAVA version 8

IDE: Spring Tool suite with spring 2.0 for Web application and Android Studio (No specific version)
Testing Environment: AWS EC2

Local Machines: 2 Macbooks, 2 Windows.
### 2.2 Production
Production Server: Our web application will be deployed on Apache Tomcat 8 server (To Be Discussed server environment. Assumption UNIX server)

Mobile application: Tablets android version is 7.7 (SDK version 24). We will be packaging the application with the Android SDK version 24.

Database Server: MySQL version 5.5 (TBD max supported version)

JAVA version 8 (TBD max supported version)

IDE: Spring Boot 2.0 for Web application and Android Studio.
Data Sources, Models, Timing
### 1.1 Data Sources
#### 1.1.1 Stops Inventory Data
The data related to stops - stop ID, location, directions etc. will be fed from the application as form inputs by the infield crew.
The stop update requests data will be fed from the website by the administrator.

#### 1.1.2 Administrator Data
The administrators can configure the user credentials in the User database using the website console.


### 1.2 Data Models and Structure78








## PostgreSQL Schema of database

CREATE TABLE "Transaction Information" (
	"TransactionNo" serial NOT NULL,
	"RequestID" serial NOT NULL,
	"DeviceID" integer NOT NULL,
	"AdminID" integer NOT NULL,
	"StopId" integer NOT NULL,
	"Direction" VARCHAR(255) NOT NULL,
	"StreetOn" VARCHAR(255),
	"NearestCrossStreet" VARCHAR(255),
	"Position" VARCHAR(255),
	"FastenedTo" VARCHAR(255),
	"Latitude" VARCHAR(255),
	"Longitude" VARCHAR(255),
	"County" VARCHAR(255) NOT NULL,
	"DateTime" DATETIME NOT NULL,
	"Status" VARCHAR(255) NOT NULL,
	"Shelter" BOOLEAN,
	"Advertisement" BOOLEAN,
	"Bench" BOOLEAN,
	"BikeRack" BOOLEAN,
	"TrashCan" BOOLEAN,
	"TimeTable" BOOLEAN,
	"System Map" BOOLEAN,
	"Photo" bytea,
	"AdminComments" VARCHAR(255),
	"AdditionalInformation" VARCHAR(255),
	CONSTRAINT "Transaction Information_pk" PRIMARY KEY ("TransactionNo")
) WITH (
  OIDS=FALSE
);

ALLOWED VALUES:
County:Erie,Niagara
Status:Resolved,Pending,Unresolved
Direction:North,South,East,West,Inbound,Static
FastenedTo:Utility pole,Shelter,Telspar,Other
Position:Nearside,Farside,Mis-block,Static

CREATE TABLE "Service Request" (
	"RequestID" integer NOT NULL,
	"AdminUserID" integer NOT NULL,
	"RequestedUser" VARCHAR(255) NOT NULL,
	"Date" DATE NOT NULL,
	"Location" FLOAT NOT NULL,
	"Direction" VARCHAR(255) NOT NULL,
	"Route" VARCHAR(255),
	"Reason" VARCHAR(255),
	"Additional Information" VARCHAR(255),
	"Status" VARCHAR(255) NOT NULL,
	"StopID" integer NOT NULL,
	CONSTRAINT "Service Request_pk" PRIMARY KEY ("RequestID")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Admin User" (
	"UserID" integer NOT NULL,
	"Name" VARCHAR(255) NOT NULL,
	"EmailId" VARCHAR(255) NOT NULL,
	"Password" VARCHAR(255) NOT NULL UNIQUE,
	"Date" DATE NOT NULL,
	CONSTRAINT "Admin User_pk" PRIMARY KEY ("UserID")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "RouteListed" (
	"TransactionNo" integer NOT NULL,
	"RouteId" VARCHAR(255) NOT NULL,
	CONSTRAINT "RouteListed_pk" PRIMARY KEY ("TransactionNo","RouteId")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Routes" (
	"RouteID" serial NOT NULL,
	"RouteInfo" VARCHAR(255) NOT NULL,
	CONSTRAINT "Routes_pk" PRIMARY KEY ("RouteID")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "Transaction Information" ADD CONSTRAINT "Transaction Information_fk0" FOREIGN KEY ("RequestID") REFERENCES "Service Request"("RequestID");
ALTER TABLE "Transaction Information" ADD CONSTRAINT "Transaction Information_fk1" FOREIGN KEY ("AdminID") REFERENCES "Admin User"("UserID");

ALTER TABLE "Service Request" ADD CONSTRAINT "Service Request_fk0" FOREIGN KEY ("AdminUserID") REFERENCES "Admin User"("UserID");


ALTER TABLE "RouteListed" ADD CONSTRAINT "RouteListed_fk0" FOREIGN KEY ("TransactionNo") REFERENCES "Transaction Information"("TransactionNo");
ALTER TABLE "RouteListed" ADD CONSTRAINT "RouteListed_fk1" FOREIGN KEY ("RouteId") REFERENCES "Routes"("RouteID");


### 1.3 Timing
The data will live in the system for 3 years. After 3 years, the records will be exported to a local file and deleted from the database.







System Architecture Diagram


Deployment Methodology
The .apk file for the android application will be deployed on the production infield crew tablets. 

For the Data server, we will run a script to create the schema and update the respective Data server credentials in the properties files of the Web application server code. 

After the data properties are updated, we will generate a .jar file which will be hosted on NFTA production servers.
The web application will be hosted on NFTA servers.

