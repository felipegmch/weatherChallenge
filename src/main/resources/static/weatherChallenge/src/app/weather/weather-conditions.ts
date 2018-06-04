import { Weather } from "./weather";
import { Main } from "./main";
import { Rain } from "./rain";
import { Clouds } from "./clouds";
import { Wind } from "./wind";
import { Coordinates } from "./coordinates";
import { Snow } from "./snow";
import { System } from "./system";

export class WeatherConditions {

    coord:Coordinates;
    weather:Weather[];
    base:string;
    main:Main;
    wind:Wind;
    clouds:Clouds;
    rain:Rain;
    snow:Snow;
    dt:number;
    sys:System;
    id:number;
    name:String;
    code:number;

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }
}
