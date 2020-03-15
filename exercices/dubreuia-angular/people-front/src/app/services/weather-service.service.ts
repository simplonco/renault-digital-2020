import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class WeatherService {

  constructor(private http: HttpClient) {
  }

  public getWeather(city: String): Observable<Object> {
    return this.http.get(`http://localhost:8080/weather/${city}`);
  }

}
