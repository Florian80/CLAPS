patientpath
==============

A Demo Application "Medical-Appointment-Manager" for Patients undergoing a long-time treatment.
Providing a simple to use appointment management tool helping patients to see future and
past appointments.


Workflow
========

To compile the entire project, run "mvn install".

For Eclipse: Import as maven project.

For manual import: use vaadin archetype "Application"

Database: For Database access, call master.

To Run without database access, Comment out all vaadin elements, using DAO - Methods (most "Grids")

To run the application, run "mvn jetty:run" and open http://localhost:8080/ .

To produce a deployable production mode WAR: good luck, we didn't try yet...


Client-Side compilation
-------------------------

The generated maven project is using an automatically generated widgetset by default.


Theme
-------------------------

App uses Vaadin standard theme "Valo". New Theme is under construction.

