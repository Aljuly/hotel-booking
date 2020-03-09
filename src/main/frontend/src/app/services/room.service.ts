import { Room } from './../model/room';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private http: HttpClient) { }

  getRoomsByDates(dateFrom: string, dateTo: string): Observable<Room[]> {
    return this.http.get<Room[]>('/rooms/dates/' + dateFrom + '/' + dateTo);
  }

  getRoomsByCategory(categoryId: number): Observable<Room[]> {
    return this.http.get<Room[]>('/rooms/' + categoryId);
  }

}
