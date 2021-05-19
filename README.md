# wipro-demo

Build the following web application -

A portal page where number of nodes are maintained in 4 clusters.

Cluster Names with default Servers-  Amazon (850), Michigan (904) , Rhino (1208), Tahoe (150). 
If the user logs in as an admin, 
it see’s an edit icon next to the cluster servers count. 
If clicked on that icon, 
it makes the number of server’s editable and you can update the number by clicking on a tick icon. 
Feel free to build the UI for the above logic as per your convenience, 
but focus on making it crisp, clean, sharp and visually appealing. 
How you want to display the UI with the cluster name and the servers count is upto you.

Each cluster has no. of nodes (servers) that belong to them. Mentioned in the brackets above.

Use Database to store the cluster details and also the number of servers against each cluster.

Users should be defined in the configuration for Spring Boot/Tomcat web service. Not in Oracle.

Use JPA for persistence.

There are 2 types of users with password - 
1. readonly/readonly
2. admin/admin

Technologies to be used. Stick to the below -

1. Java

2. Web service - Spring boot with tomcat. Login page should have user/pwd. Can run on default 8080.

3. UI - Angular/JS

4. Database - Oracle/Elastic Search

Database details can be added in an application.properties file as follows -

jpa.oracle.url=jdbc:oracle:thin:@<>:<>
jpa.oracle.user=<>
jpa.oracle.password=<>


Send over the code (for UI, Webservice, DDL/DML for database) with the steps to implement. 
Try to make the code deployment simple as possible. 

Use maven / anything else for deployment.
