import {Component} from '@angular/core';
import {Observable} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  observable() {
    console.log("Observable");
    let observable = new Observable(observer => {
      observer.next("1");
      setTimeout(() => observer.next("2"), 500);
      setTimeout(() => observer.error("3"), 1000);
      observer.next("4")
    });
    let subscriber = observable.subscribe(
      (value: string) => console.log(value),
      error => console.log("error: " + error)
    );
    // setTimeout(() => subscriber.unsubscribe(), 100)
  }

  promise() {
    console.log("Promise");
    let promise = new Promise((resolve, reject) => {
      resolve("1");
      setTimeout(() => resolve("2"), 500);
      setTimeout(() => reject("3"), 1000);
      resolve("4")
    });
    promise
      .then(result => console.log("ok: " + result))
      .catch(result => console.log("error: " + result));
  }

}
