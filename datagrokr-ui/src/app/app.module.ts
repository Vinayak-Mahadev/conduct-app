import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UpdateConductComponent } from './update-conduct/update-conduct.component';
import { ConductListComponent } from './conduct-list/conduct-list.component';
import { ConductDetailsComponent } from './conduct-details/conduct-details.component';
import { CreateConductComponent } from './create-conduct/create-conduct.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    CreateConductComponent,
    UpdateConductComponent,
    ConductListComponent,
    ConductDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
