import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../model/User";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUsers() {
    return this.http.get<User[]>('/users');
  }

  getUser(id: number) {
    return this.http.get<User>('/users' + id);
  }

  createUser(user: User) {
    return this.http.post<void>('/users', user);
  }

}
