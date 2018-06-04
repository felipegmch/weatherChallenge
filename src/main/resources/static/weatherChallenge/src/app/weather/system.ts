export class System {
    type:number;
    id:number;
    message:number;
    country:string;
    sunrise:number;
    sunset:number;

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }
}
