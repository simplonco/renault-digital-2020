import {Component, OnInit} from '@angular/core';
import {Person} from '../models/person';
import {PersonService} from '../services/person-service.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  persons: Person[];

  constructor(private personService: PersonService) {
    this.personService = personService;
  }

  ngOnInit() {
    this.personService.findAll()
      .then(result => result.json())
      .then(result => this.persons = result);
  }

}
