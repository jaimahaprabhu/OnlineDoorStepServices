import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";
import { RegistrationComponent } from "./registration/registration.component";
import { SearchServiceComponent } from "./search-service/search-service.component";
import { ServiceBookingComponent } from "./service-booking/service-booking.component";

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "myBookings", component: ServiceBookingComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule, FormsModule, ReactiveFormsModule],
})
export class AppRoutingModule {}
export const routingComponents = [
  HomeComponent,
  SearchServiceComponent,
  ServiceBookingComponent,
  LoginComponent,
  RegistrationComponent,
];
