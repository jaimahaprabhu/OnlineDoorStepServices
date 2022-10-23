import { Component, Input, OnInit } from "@angular/core";
import { FormControl } from "@angular/forms";
import { ServiceDeatils } from "../services/service-details.service";
import { ServiceDto } from "../models/ServiceDto.dto";
import { LoginRegService } from "../services/login-reg.service";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.scss"],
})
export class HomeComponent implements OnInit {
  @Input() selectedService = ""; // decorate the property with @Input()
  @Input() isSearch: any;

  constructor(private loginRegService: LoginRegService) {}

  ngOnInit(): void {
    this.getStatus();
  }
  ngOnChanges() {
    this.getStatus();
  }

  getStatus(): any {
    this.loginRegService.isLogin;
  }
}
