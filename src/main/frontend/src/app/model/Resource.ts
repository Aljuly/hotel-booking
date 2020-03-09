export class Resource {
  private _id: number;

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  constructor(id: number) {
    this._id = id;
  }
}
