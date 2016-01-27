# jbossws.ejb3
JAX WS EJB Endpoint

## Create Project
    mvn -s archetype:generate \
      -DarchetypeGroupId=org.codehaus.mojo.archetypes \
      -DarchetypeArtifactId=ejb-javaee6 \
      -DgroupId=sg.jbossws.ejb \
      -DartifactId=ejbws \
      -DinteractiveMode=false

## WSDL
  * Get wsdl and schema from <http://docs.spring.io/spring-ws/site/reference/html/tutorial.html>
  * Update with `HolidayResponse` element.
  * Copy in `src/main/resources/META-INF/wsdl` dir

## Generate Java artifacts from wsdl

    jdk1.7.0_85/bin/wsimport.exe -Xnocompile -keep -s src/main/java src/main/resources/META-INF/wsdl/hr.wsdl
