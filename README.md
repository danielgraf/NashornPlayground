# NashornPlayground

Did you know that you can run JS in the JVM ?

The technology to do it is called Nashorn - a script engine, and has been part of Java since 1.8. This Java web app presents some slides about Nashorn, and some example Javascripts which can be executed server side at the touch of a button.

The project can be opened in NetBeans or compiled with ant, and generates a WAR file.

Deploy that to a Java web container such as Tomcat or Glassfish and have a play.

This application is also available on dockerhub as a Docker container :

docker pull grafsnow/nashorn-playground

docker run -it -d -p 8888:8080 grafsnow/nashorn-playground

the web app is then available on this URL :

http://localhost:8888/NashornPlayground/
