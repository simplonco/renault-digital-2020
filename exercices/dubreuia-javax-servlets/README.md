# Servlets

A Java servlet is a Java software component that extends the capabilities of a server. Although servlets can respond to many types of requests, they most commonly implement web containers for hosting web applications on web servers and thus qualify as a server-side servlet web API. Such web servlets are the Java counterpart to other dynamic web content technologies such as PHP and ASP.NET. 

## Documentation

Java Servlets are part of Java EE: https://en.wikipedia.org/wiki/Java_Platform,_Enterprise_Edition

- https://en.wikipedia.org/wiki/Java_servlet
- https://www.oracle.com/java/technologies/java-ee-glance.html (read "What's New in Java EE 8")

## TODO

### Step 1

- Modify the `WelcomeServlet` class by adding the [@WebServlet annotation](https://docs.oracle.com/javaee/7/api/javax/servlet/annotation/WebServlet.html)
- Implement the `goGet` method to forward the request to "welcome.jsp" using the [RequestDispatcher](https://docs.oracle.com/javaee/7/api/javax/servlet/RequestDispatcher.html)
- [Deploy](#deploy) using the deploy commands

### Step 2

- Modify the `WelcomeServlet` class by taking the "name" parameter from the request using [HttpServletRequest#getRequestParameter]
- Use the "name" parameter in the "welcome.jsp" file using `${variable}`
- [Deploy](#deploy) using the deploy commands

### Step 3

- Modify the "welcome.jsp" file to show a 50px `<div>` with a background-color of red only if the name is equal to "titi"
- [Deploy](#deploy) using the deploy commands

### Step 4

- Test if the request header "Content-Type" is equal to "application/json"
- Return the content as JSON `{"name": "titi"}`
    - Use `HttpServletResponse#getWriter`
    - Use [JSON-B](http://json-b.net/docs/user-guide.html)
- [Deploy](#deploy) using the deploy commands
- Test using `curl -H ...`

## Deploy

First download [Apache Tomcat 9](https://tomcat.apache.org/download-90.cgi) (download and extract in "~/Programs" folder)

```
# Build war
./gradlew war

# Copy war
cp build/libs/eugenp-javax-servlets.war ~/Programs/apache-tomcat-9.0.30-renault/webapps

# Go in tomcat manager (tomcat / admin)
http://localhost:8080/
http://localhost:8080/manager/html
```

<!--
## Tutorials

- [Introduction to Java Servlets](https://www.baeldung.com/intro-to-servlets)
- [An MVC Example with Servlets and JSP](https://www.baeldung.com/mvc-servlet-jsp)
- [Handling Cookies and a Session in a Java Servlet](https://www.baeldung.com/java-servlet-cookies-session)
- [Uploading Files with Servlets and JSP](https://www.baeldung.com/upload-file-servlet)
- [Example of Downloading File in a Servlet](https://www.baeldung.com/servlet-download-file)
- [Returning a JSON Response from a Servlet](https://www.baeldung.com/servlet-json-response)
- [Java EE Servlet Exception Handling](https://www.baeldung.com/servlet-exceptions)
- [Context and Servlet Initialization Parameters](https://www.baeldung.com/context-servlet-initialization-param)
- [The Difference between getRequestURI and getPathInfo in HttpServletRequest](https://www.baeldung.com/http-servlet-request-requesturi-pathinfo)
-->