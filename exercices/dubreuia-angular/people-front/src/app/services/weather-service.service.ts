import {Injectable} from '@angular/core';

@Injectable()
export class WeatherService {

  constructor() {
  }

  public getWeather(city: String): Promise<Response> {
    return fetch(`http://localhost:8080/weather/${city}`);
  }

}
