import { Component, OnInit } from '@angular/core';
import { City } from '../../city';
import { CityService } from '../../shared_service/city.service';
import { WeatherConditions } from '../../weather/weather-conditions';
import { Unit } from '../../unit';

@Component({
  selector: 'app-citylist',
  templateUrl: './citylist.component.html',
  styleUrls: ['./citylist.component.css']
})
export class CitylistComponent implements OnInit {
  private cities:City[];
  private weatherConditions:WeatherConditions;
  private units:Unit;

  constructor(private _cityService:CityService) { }

  ngOnInit() {
    this._cityService.getCitiesTop10().subscribe((cities) => {
      this.cities = cities;
    }, (error) => {
      console.log(error);
    })
  }

  getWeather(city, unit) {
    console.log(city);
    console.log(unit);
    this._cityService.getWeatherbyCityId(city, unit).subscribe((weatherConditions) => {
      this.weatherConditions = weatherConditions;
    }, (error) => {
      console.log(error);
    })
  }

}
