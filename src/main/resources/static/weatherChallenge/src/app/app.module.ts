import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CitylistComponent } from './components/citylist/citylist.component';
import { CityformComponent } from './components/cityform/cityform.component';
import { CityweatherComponent } from './components/cityweather/cityweather.component';
import { CityService } from './shared_service/city.service';

const appRoutes:Routes=[
  {path:'', component:CitylistComponent},
  {path:'op', component:CityformComponent},
  {path:'weather', component:CityweatherComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    CitylistComponent,
    CityformComponent,
    CityweatherComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [CityService],
  bootstrap: [AppComponent]
})
export class AppModule { }
