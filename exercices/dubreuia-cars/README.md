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

## Deploy

```bash
./gradlew deployToTomcat
```

## References

![MVC](https://i.stack.imgur.com/pENZD.png)
