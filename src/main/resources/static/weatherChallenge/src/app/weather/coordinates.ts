export class Coordinates {
    lon:number;
    lat:number;

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }
}
