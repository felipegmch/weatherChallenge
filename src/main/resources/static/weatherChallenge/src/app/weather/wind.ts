export class Wind {

    speed:number;
    deg:number;
    
    constructor(values: Object = {}) {
        Object.assign(this, values);
    }
}
