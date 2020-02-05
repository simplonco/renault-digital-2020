# Cars

Implement a car client / server application.

## TODO

### Step 1

For the first step, implement the "TODO step 1" comments. The returned HTML from the url http://localhost:8080/dubreuia-cars/cars should correspond to [step1.html](step1.html).

- In `CarsService`, implement the `getBrands()` method:
    - The method should return the brands from the .csv
    - For example: "BMW", "Cadillac", etc.
- In `CarsServlet`, implement the `goGetHtml()` method:
    - Forward the request to the ".jsp" file
    - Add the set of brands to the request attributes
- In `cars.jsp` page, implement the loop to show the buttons:
    - Use a `for` loop, in the loop, use the `<%= variable %>` syntax
    - The buttons should show as: `<button data-brand="BMW">BMW</button>`

### Step 2

For the second step, implement the "TODO step 2" comments. The resulting DOM should correspond to [step2.html](step2.html).

- In `CarsService`, implement the `getCars()` method:
    - The method should return the cars from the .csv
    - The method should filter on the provided argument
    - Use the `Car` constructor with the brand and model
- In `CarsServlet`, implement the `goGetJson()` method:
    - Use [JSON-P](https://javaee.github.io/jsonp/getting-started.html) to convert to JSON
    - Use `PrintWriter writer = response.getWriter()` to print the output
- In `cars.jsp` page, implement the js to send the request to the server:
    - Use the [`fetch` API](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch)
    - Send a request to the proper URL for example "http://localhost:8080/dubreuia-cars/cars?brand=BMW"
    - Put the content in the `div` element with the "content" id
    
### Step 3

For the third step, start a MySql server using Docker, and use Java to insert and query data in the database.

- Start a MySql database
    - Install [docker](https://www.docker.com/get-started)
    - Run latest mysql image `docker run --name mysql_renault -e MYSQL_ROOT_PASSWORD=12345 -d mysql:latest`
    - Run latest mysql image (windows) `docker run --name mysql_renault -e MYSQL_ROOT_PASSWORD=12345 -d -P mysql:latest`
    - Make sure the "mysql_renault" image is running `docker ps` (note the port on windows, it will change)
    - Use inspect to find the IP of the running docker `docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mysql`
    - Try connecting to it using docker `docker run -it --rm mysql mysql -h 172.17.0.2 -u root -p` (password: 12345)
    - Try connecting to it using docker (windows) `winpty docker run -it --rm mysql mysql -h 172.17.0.2 -u root -p` (password: 12345)
    - In Mysql, you need to create a database first, use `CREATE DATABASE renault`
    - Then use the database using `USE renault`
    - (`docker stop mysql_renault`, `docker ps -a`, `docker start mysql_renault`)
    - (`docker inspect mysql_renault` show volume)
    - (`docker rm mysql_renault` loses data!)
    - (`docker image list`, `docker image rm`)
- Use Java to modify and query the database 
    - Add the Mysql connector jar to build.gradle `https://mvnrepository.com/artifact/mysql/mysql-connector-java`
    - In `CarsDatabaseInsert` read the "cars.csv" file and insert the content in the database
    - Use the connection `DriverManager.getConnection("jdbc:mysql://172.17.0.2:3306/renault", "root", "12345");`
    - Modify the `CarService` class to read from the database instead of the "csv" file

## Deploy

```bash
./gradlew deployToTomcat
```

## References

![MVC](https://i.stack.imgur.com/pENZD.png)
