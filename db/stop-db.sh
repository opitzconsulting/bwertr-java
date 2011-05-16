#!/bin/bash
java -jar hsqldb.jar --inlineRc url=jdbc:hsqldb:hsql://localhost/bwertr,user=sa,password= --sql 'shutdown;'
