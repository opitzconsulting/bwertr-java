ATDD Sample Application bwerter
===============================

A simple sample application demonstration ATDD.

* `start-db` starts a H2 database service on port 9092. Hit Ctrl-C to stop the service.
* `start-jetty` starts a Jetty web server on port 8080. Hit Ctrl-C to stop the service.

You can also run the integration tests with Maven by activating the `spec` profile:

`mvn -P spec clean integration-test`

Start up and shut down of the H2 and Jetty server is handled by `jetty-maven-plugin` and
`exec-maven-plugin` and should work with your CI server.

If you wish to deploy to CloudFoundry, follow these steps:

* `mvn clean package`
* cd target; vmc push [application name]

Make sure to configure a MySQL service for the application.