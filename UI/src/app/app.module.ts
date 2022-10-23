import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BookingsComponent } from './bookings/bookings.component';
import { MaterialModule } from './material/material.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { SharedModule } from './shared/shared.module';
import { ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './shared/header/header.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { ServiceBookingComponent } from './service-booking/service-booking.component';

@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    BookingsComponent,
    RegistrationComponent,
    ServiceBookingComponent
  ],
  entryComponents: [
    LoginComponent, RegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule, MaterialModule, HttpClientModule, SharedModule, ReactiveFormsModule
  ],

  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
