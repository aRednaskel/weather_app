# Weather_app

Weather_app is a repository, that retrieves information about weather and air quality in Poland from [danepubliczne.imgw](https://danepubliczne.imgw.pl/api/data/synop) and [powietrze.gios.gov.pl](https://powietrze.gios.gov.pl/pjp/content/api)

This project is deployed to **[heroku](https://arednaskel-weatherapp.herokuapp.com/weather-app/swagger-ui.html#/)** and ready to interact with Swagger UI.

### Weather station

The weather information is _[connects with imgw every two hours](https://github.com/aRednaskel/weather_app/blob/master/src/main/java/com/weather/imgw/weatherApp/config/Scheduler.java)_ and saves current data to the databse.

It is possible to get the average weather properties in Poland like temperature, pressure or to find not rainy cities or cities with temperature higher than give one. 

### Air quality
###### The air quality is able to find information about air quality of city in Poland by providing the name of the city.

