import {Component, OnInit} from '@angular/core';
import {DataService} from "../services/data.service";
import {WeatherService} from "../services/weather-service.service";

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {

  private weather: string = "click a city for weather information";

  constructor(private dataService: DataService,
              private weatherService: WeatherService) {
    this.dataService.cityObservable.subscribe(city => {
      this.weatherService.getWeather(city)
        .subscribe(
          response => this.weather = `Weather for ${city} is: ${response['weather_state_name']}`,
          error => this.weather = error['error']['message']
        );
    })
  }

  ngOnInit() {
  }

}
