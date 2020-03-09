import { Dates } from './dates';
import { RoomOption } from './roomOption';
import { Resource } from './resource';
import { User } from './User';
export class Booking extends Resource {

    private _roomId: number;
    private _user: User;
    private _dates: Dates;
    private _optinos: RoomOption[];

    constructor(id: number, roomId: number, user: User, dates: Dates, optinos: RoomOption[]) {
        super(id);
        this._roomId = roomId;
        this._user = user;
        this._dates = dates;
        this._optinos = optinos;
    }

    public get roomId(): number {
        return this._roomId;
    }
    public set roomId(value: number) {
        this._roomId = value;
    }
    public get user(): User {
        return this._user;
    }
    public set user(value: User) {
        this._user = value;
    }
    public get dates(): Dates {
        return this._dates;
    }
    public set dates(value: Dates) {
        this._dates = value;
    }
    public get optinos(): RoomOption[] {
        return this._optinos;
    }
    public set optinos(value: RoomOption[]) {
        this._optinos = value;
    }

}

