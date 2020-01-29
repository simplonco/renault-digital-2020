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

## Deploy

```bash
./gradlew deployToTomcat
```

## References

![MVC](https://i.stack.imgur.com/pENZD.png)
