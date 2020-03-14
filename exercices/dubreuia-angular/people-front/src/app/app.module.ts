import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {PersonListComponent} from './person-list/person-list.component';
import {PersonService} from './services/person-service.service';
import {WeatherService} from "./services/weather-service.service";
import {WeatherComponent} from './weather/weather.component';
import {DataService} from "./services/data.service";

@NgModule({
  declarations: [
    AppComponent,
    PersonListComponent,
    WeatherComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      {path: 'persons', component: PersonListComponent},
    ])
  ],
  providers: [PersonService, WeatherService, DataService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
