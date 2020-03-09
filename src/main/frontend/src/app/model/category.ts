import { Resource } from './resource';
export class Category extends Resource {

    private _name: string;
    private _description: string;

    constructor(id: number, name: string, description: string) {
        super(id);
        this._name = name;
        this._description = description;
    }

    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    }
    public get description(): string {
        return this._description;
    }
    public set description(value: string) {
        this._description = value;
    }

}
