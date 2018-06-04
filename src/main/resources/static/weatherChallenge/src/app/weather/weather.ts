export class Weather {

    id:number;
    main:string;
    description:string;
    icon:string;

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }
}
