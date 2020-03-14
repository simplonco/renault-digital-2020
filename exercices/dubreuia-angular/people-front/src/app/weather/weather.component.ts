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
      // TODO use obervable for service
      weatherService.getWeather(city)
        .then(response => response.text())
        .then(response => this.weather = `Weather for ${city} is: ${response}`)
    })
  }

  ngOnInit() {
  }

}
