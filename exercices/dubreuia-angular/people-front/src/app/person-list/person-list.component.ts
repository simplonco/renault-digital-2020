import {Component, OnInit} from '@angular/core';
import {Person} from '../models/person';
import {PersonService} from '../services/person-service.service';
import {DataService} from "../services/data.service";

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  persons: Person[];

  constructor(private personService: PersonService,
              private dataService: DataService) {
    this.personService = personService;
  }

  ngOnInit() {
    this.personService.findAll()
      .then(result => result.json())
      .then(result => this.persons = result)
  }

  showWeather(person: Person) {
    this.dataService.cityObserver.next(person.city)
  }

}
