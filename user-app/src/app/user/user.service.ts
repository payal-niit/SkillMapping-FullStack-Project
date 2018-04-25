import { Injectable } from '@angular/core';
import { User } from "./user";
import { Http, Response } from "@angular/http";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import { Observable } from "rxjs/Observable";
//import { HttpClient } from 'selenium-webdriver/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { error } from 'protractor';
import { catchError, map, tap } from 'rxjs/operators';
import { of }         from 'rxjs/observable/of';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  

  private apiUrl = 'http://localhost:8080/SkillMapping-WebClient/api/user';


  constructor(private http: Http) {
  }

  findAll(): Observable<User[]>  {
    return this.http.get(this.apiUrl)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw('Server error'));
  }

  // findAll(): Observable<User[]>  {
  //   return this.http.get<User[]>(this.apiUrl).pipe(
      
  //     catchError(this.handleError('getHeroes', []))
  //   );
  // }

  // private handleError<T> (operation = 'operation', result?: T) {
  //   return (error: any): Observable<T> => {
  
  //     // TODO: send the error to remote logging infrastructure
  //     console.error(error); // log to console instead
  //     return of(result as T);
  //   }
  // }
  
  saveUser(user: User): Observable<User> {
    return this.http.post(this.apiUrl, user)
      .catch((error:any) => Observable.throw(error.json().error || 'Server error')); 
  }  

  findById(user_id: number): Observable<User> {
    return this.http.get(this.apiUrl + '/' + user_id)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw('Error'));      
  }
 
  updateUser(user_id: number,user: User): Observable<User> {
     
    return this.http.put(this.apiUrl+ '/' + user_id, user)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw('Server error'));
  }


 deleteUserById(user_id: number): Observable<boolean> {
    return this.http.delete(this.apiUrl + '/' + user_id)
      .map((res:Response) => res.ok);
      
  }

  validateUser(email_id: string) {
    return this.http.get(this.apiUrl+'/validate/'+ email_id).map((res:Response) => res.json())
    .catch((error:any) => Observable.throw(error.json().error || 'Error'));
  }
}