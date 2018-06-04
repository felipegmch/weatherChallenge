import { Component, OnInit } from '@angular/core';
import { City } from '../../city';
import { CityService } from '../../shared_service/city.service';

@Component({
  selector: 'app-citylist',
  templateUrl: './citylist.component.html',
  styleUrls: ['./citylist.component.css']
})
export class CitylistComponent implements OnInit {
  private cities:City[];

  constructor(private _cityService:CityService) { }

  ngOnInit() {
    
    this._cityService.getCitiesTop10().subscribe((cities) => {
      this.cities = cities;
    }, (error) => {
      console.log(error);
    })

  }

}
