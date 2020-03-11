import {Injectable} from '@angular/core';

@Injectable()
export class PersonService {

  private usersUrl: string;

  constructor() {
    this.usersUrl = 'http://localhost:8080/persons';
  }

  public findAll(): Promise<Response> {
    return fetch(this.usersUrl);
  }

}
