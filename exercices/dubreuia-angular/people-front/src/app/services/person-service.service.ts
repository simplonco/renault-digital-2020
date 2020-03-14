import {Injectable} from '@angular/core';

@Injectable()
export class PersonService {

  constructor() {
  }

  public findAll(): Promise<Response> {
    return fetch('http://localhost:8080/persons');
  }

}
