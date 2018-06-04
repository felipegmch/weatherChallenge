import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';

import { map, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { WeatherConditions } from '../weather/weather-conditions';
import { City } from '../city';

import { DropdownQuestion } from './../question-dropdown';
import { QuestionBase }     from './../question-base';
import { Unit } from '../unit';

@Injectable({
  providedIn: 'root'
})
export class CityService {

  private baseUrl:string='http://localhost:8080/api';
  private headers = new Headers({'Content-Type':'application/json'});
  private options = new RequestOptions({headers:this.headers});

  constructor(private _http:Http) { }

  // API: GET /cities
  public getCities() {
    return this._http.get(this.baseUrl + '/cities').pipe(
      map(response => {
        const city = response.json();
        return city.map((city) => new City(city));
      }),
      catchError(this.errorHandler)
    );
  }

  // API: GET /cities/top100
  public getCitiesTop100() {
    return this._http.get(this.baseUrl + '/cities/top100').pipe(
      map(response => {
        const city = response.json();
        return city.map((city) => new City(city));
      }),
      catchError(this.errorHandler)
    );
  }

  // API: GET /cities/count
  public getCitiesCount() {
    return this._http.get(this.baseUrl + '/cities/count').pipe(
      map(response => {
        return response.json();
      }),
      catchError(this.errorHandler)
    );
  }

  // API: GET /cities/id
  public getWeatherbyCityId(id:number, units:string) {
    return this._http.get(this.baseUrl + '/cities/id' + '?' + 'id=' + id + (units != null ? "&units=" + units : "")).pipe(
      map(response => {
        return response.json();
      }),
      catchError(this.errorHandler)
    );
  }

  // API: GET /cities/name
  public getWeatherbyCityNameAndCountryCode(cityName:string, countryCode:string, units:string) {
    return this._http.get(this.baseUrl + '/cities/name' + '?' + 'cityName=' + cityName + (countryCode != null ? "," + countryCode : "") + (units != null ? "&units=" + units : "")).pipe(
      map(response => {
        const weatherConditions = response.json();
        return weatherConditions.map((weatherConditions) => new WeatherConditions(weatherConditions));
      }),
      catchError(this.errorHandler)
    );
  }

  errorHandler(error:Response) {
    return throwError(error || "SERVER ERROR");
  }

}
