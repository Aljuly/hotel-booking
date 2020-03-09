import { Booking } from './../model/booking';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Booking[]> {
    return this.http.get<Booking[]>('/bookings');
  }

  getUserBookings(userId: number): Observable<Booking[]> {
    return this.http.get<Booking[]>('/bookings/user/' + userId);
  }

  createBooking(booking: Booking) {
    return this.http.post<void>('/bookings', booking);
  }

}
