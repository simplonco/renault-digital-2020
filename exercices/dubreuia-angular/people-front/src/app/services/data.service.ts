import {Injectable} from '@angular/core';
import {Observable, Observer} from "rxjs";

@Injectable()
export class DataService {

  public cityObserver: Observer<string>

  public cityObservable: Observable<string> = new Observable<string>((observer) => {
    this.cityObserver = observer
  });

  constructor() {
  }

}
