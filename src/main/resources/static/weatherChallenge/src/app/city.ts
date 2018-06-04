export class City {
    
    id:Number;
    name:String;
    longitude:Number;
    latitude:Number;
    countryCode:String;

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }
}
