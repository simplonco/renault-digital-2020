import {Component, OnInit} from '@angular/core';
import {Person} from './person';
import {PersonService} from './person-service.service';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  persons: Person[];

  constructor(private personService: PersonService) {
    console.log("fu2")
    this.personService = personService;
  }

  ngOnInit() {
    console.log("fu1")
    this.personService.findAll()
      .then(result => result.json())
      .then(result => this.persons = result)
  }

}
