import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RoomOption} from '../model/roomOption';

@Injectable({
  providedIn: 'root'
})
export class OptionService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<RoomOption[]>('/options');
  }
}
