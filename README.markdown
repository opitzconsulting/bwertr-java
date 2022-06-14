ATDD Sample Application bwerter
===============================

---
**NOTE**
This repository is DEPRECATED!
---

A simple sample application demonstration ATDD.

* `start-db` starts a H2 database service on port 9092. Hit Ctrl-C to stop the service.
* `start-jetty` starts a Jetty web server on port 8080. Hit Ctrl-C to stop the service.

You can also run the integration tests with Maven by activating the `spec` profile:

`mvn -Pspec clean verify`

Start up and shut down of the H2 and Jetty server is handled by `jetty-maven-plugin` and
`exec-maven-plugin` and should work with your CI server.

The bwertr kata
===============

If you want practice different parts of the bwertr kata, you can use the `iteration` branches with
its various tags as starting point:

* `iteration-1` points to the "blank" project. Start here, if you want to do the whole kata.
* `iteration-2` contains tests and solution for "Show number of ratings" and "Rate a presentation",
  but needs heavy refactoring. Start here, if you want to practice your refactoring skills.
* `iteration-3` is the well factored version of `iteration-2` and is ready for implementing
  "See average rating", which we use for demonstrating TDD.
* `iteration-4` contains tests and solution for all three of the original features. Additionally,
  there is a specification for "Only one rating per user allowed". Start here, if you want to practice
  the whole outside-in development approach.
