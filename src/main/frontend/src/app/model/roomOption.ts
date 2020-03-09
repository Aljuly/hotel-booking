import {Resource} from './resource';

export class RoomOption extends Resource {
  private _optionName: string;
  private _cost: number;

  constructor(id: number, optionName: string, cost: number) {
    super(id);
    this._optionName = optionName;
    this._cost = cost;
  }


  get optionName(): string {
    return this._optionName;
  }

  set optionName(value: string) {
    this._optionName = value;
  }

  get cost(): number {
    return this._cost;
  }

  set cost(value: number) {
    this._cost = value;
  }
}
