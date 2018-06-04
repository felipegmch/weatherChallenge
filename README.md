# weatherChallenge

This project is a coding challenge for Everis Chile.
I plan to polish my skills in Angular given the complexity.
To keep it simple, I packed backend and frontend in this project. I usually would have two repositories for this.

It took me around 20 hours to do this challenge. Considering that I have never made a project in Spring andd Angular from scratch. I had to do a good bit of research to do this accordingly.

Tools
IntelliJ IDEA 2018.1.4 (Community Edition) -> Backend
Visual Studio Code 1.23.1 -> Frontend
Angular CLI: 6.0.7
Node: 8.11.2
OS: win32 x64
Angular: 6.0.3
Java: 1.8.0_171

Considerations
I decided to use H2 to simulate the city list database. A DAO/DAL layer would be useful if it were used a real database. As for now using H2 was to simplify my own development process given the core of the challenge was the integration with OpenWeatherMap and the frontend with Angular.
I decided to show the first 100 cities in the city list provided. It is inpractical to load 74071 elements in a form-control. An asyncronous method to search lazily for the city should be added.

To start the backend, open the project in IntelliJ IDEA and add a new configuration (Application):
Main class: com.weather.Application
Use classpath or module: WeatherChallenge
JRE: 1.8.0_171
Backend runs by default in http://localhost:8080/
The API has the endpoint /api
The endpoints available are the following:
/cities: GET, no parameters. Retrieves the list of all cities in the database.
/cities/count: GET, no parameters. Retrieves the count of the cities in the database.
/cities/top100: GET, no parameters. Retrieves the first 100 cities in the database.
/cities/id: GET, parameters {id: long, units: String (optional)}. Calls the openWeatherMap API and retrieves the weather conditions of by the id of the city, which is present in the database. The units are optional (default: Kelvin, metric: Metric, fahrenheit: Fahrenheit).
/cities/name: GET, parameters {cityName: String, countryCode: String (optional), units: String (optional)}. Calls the openWeatherMap API and retrieves the weather conditions of by the name of the city (cityName) and the code of the country (countryCode - optional), which is present in the database. The units are optional (default: Kelvin, metric: Metric, fahrenheit: Fahrenheit).

To start the frontend, in a terminal/prompt
cd ./src/main/resources/static/weatherChallenge
ng serve --open
Frontend runs by default in http://localhost:4200/

