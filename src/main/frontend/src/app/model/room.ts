import { Category } from './category';
import { Resource } from './resource';
import { Booking } from './booking';
export class Room extends Resource {

    private _number: string;
    private _beds: number;
    private _price: number;
    private _bookings: Booking;
    private _category: Category;

    constructor(id: number, roomNumber: string, bookings: Booking, category: Category, beds: number, price: number) {
        super(id);
        this._number = roomNumber;
        this._bookings = bookings;
        this._category = category;
        this._beds = beds;
        this._price = price;
    }

    public get bookings(): Booking {
        return this._bookings;
    }
    public set bookings(value: Booking) {
        this._bookings = value;
    }
    public get category(): Category {
        return this._category;
    }
    public set category(value: Category) {
        this._category = value;
    }
    public get number(): string {
        return this._number;
    }
    public set number(value: string) {
        this._number = value;
    }
    public get beds(): number {
        return this._beds;
    }
    public set beds(value: number) {
        this._beds = value;
    }
    public get price(): number {
        return this._price;
    }
    public set price(value: number) {
        this._price = value;
    }

}
