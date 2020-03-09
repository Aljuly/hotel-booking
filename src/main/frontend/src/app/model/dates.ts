export class Dates {

    private _checkInDate: string;
    private _checkoutDate: string;

    constructor(checkInDate: string, checkoutDate: string) {
        this._checkInDate = checkInDate;
        this._checkoutDate = checkoutDate;
    }

    public get checkInDate(): string {
        return this._checkInDate;
    }

    public set checkInDate(value: string) {
        this._checkInDate = value;
    }

    public get checkoutDate(): string {
        return this._checkoutDate;
    }
    public set checkoutDate(value: string) {
        this._checkoutDate = value;
    }

}
