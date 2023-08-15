import { Component } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";

type APIResult = {content: string; id: number}

@Component({
  selector: 'app-greeting',
  templateUrl: './greeting.component.html',
  styleUrls: ['./greeting.component.css']
})
export class GreetingComponent {
  public userName: string = "";
  public displayGreeting = false;
  public id: number = 0;
  greeting: string = "";

  constructor(private http: HttpClient) {
    console.log("Constructed with", this.userName, this.displayGreeting)
  }
  public postUserInformation(): void {
    if(this.userName){
      console.log("your name is userName", this.userName)
      this.http.get<APIResult>("/greeting",
        {params: new HttpParams().append('name', this.userName)}).subscribe(result => {
          this.greeting = result['content'];
          this.id = result['id'];
          console.log(result)
      })
      this.displayGreeting = true;
    } else {
      console.log("No userName provided")
    }

  }


}
