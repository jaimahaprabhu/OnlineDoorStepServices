import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { MatChipInputEvent } from "@angular/material/chips";
import { FloatLabelType } from "@angular/material/form-field";
import { ServiceDto } from "../models/ServiceDto.dto";
import { COMMA, ENTER, F } from "@angular/cdk/keycodes";
import { ServiceDeatils } from "../services/service-details.service";
import { LoginRegService } from "../services/login-reg.service";
import { Router } from "@angular/router";
import { UserDto } from "../models/UserDto.dto";
import * as OnlineServicesProperties from "../utils/online-service-properties";
@Component({
  selector: "app-registration",
  templateUrl: "./registration.component.html",
  styleUrls: ["./registration.component.scss"],
})
export class RegistrationComponent implements OnInit {
  visible = true;
  selectable = true;
  removable = true;
  addOnBlur = true;
  services: ServiceDto[] = [];
  myForm!: FormGroup;
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];
  userDto: UserDto = new UserDto();
  formattedDate: any;
  cities = OnlineServicesProperties.cities;
  svc!: string[];
  hide = true;
  constructor(
    private _serviceDetails: ServiceDeatils,
    private loginRegService: LoginRegService,
    private router: Router
  ) {
    //  this.isServiceProvider = this.loginRegSvc.getUserDetails().isServiceProvider;
  }

  ngOnInit(): void {
    this.getServices();
    this.myForm = new FormGroup({
      svcProvider: new FormControl(false, Validators.required),
      firstname: new FormControl(
        [],
        [Validators.required, Validators.pattern("[a-zA-Z]{3,25}")]
      ),
      lastname: new FormControl(
        [],
        [Validators.required, Validators.pattern("[a-zA-Z]{1,30}")]
      ),
      email: new FormControl(
        [],
        [
          Validators.required,
          Validators.pattern("[a-zA-Z0-9]{3,}@[A-Za-z]{2,10}.com"),
        ]
      ),
      gender: new FormControl(
        OnlineServicesProperties.gender,
        Validators.required
      ),
      dob: new FormControl([], Validators.required),
      contact: new FormControl(
        [],
        [Validators.required, Validators.pattern("[0-9]{10}")]
      ),
      password: new FormControl(
        [],
        [
          Validators.required,
          Validators.pattern(OnlineServicesProperties.pwdValPattern),
        ]
      ),
      serviceProv: new FormControl(this.svc, Validators.required),
      floatLabelControl: new FormControl(
        OnlineServicesProperties.always as FloatLabelType
      ),
      city: new FormControl(
        OnlineServicesProperties.cities,
        Validators.required
      ),
      address: new FormControl(
        [],
        [
          Validators.required,
          Validators.minLength(20),
          Validators.maxLength(60),
        ]
      ),
    });
  }

  /* get services list */
  private getServices(): ServiceDto[] {
    this._serviceDetails.getAllService().subscribe((data: any) => {
      this.services = data;
    });
    this.services.forEach((ser) => this.svc.push(ser.serviceName));
    return this.services;
  }

  date(e: any) {
    this.formattedDate = new Date(e.target.value);
    this.myForm
      .get(OnlineServicesProperties.dob)
      ?.setValue(this.formattedDate, {
        onlyself: true,
      });
  }
  /* Handle form errors in Angular 8 */
  public errorHandling = (control: string, error: string) => {
    return this.myForm.controls[control].hasError(error);
  };
  /* Add dynamic services */
  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    // Reset the input value
    if (input) {
      input.value = "";
    }
  }
  /* Remove dynamic services */
  remove(subject: ServiceDto): void {
    const index = this.services.indexOf(subject);
    if (index >= 0) {
      this.services.splice(index, 1);
    }
  }

  submitForm(): void {
    console.log(this.myForm.value);
    this.populateUserDetails();
    console.log(this.userDto);
    if (this.myForm.status) {
      this.loginRegService.setUserDetails(this.userDto);
      this.loginRegService.register().subscribe((response) => {
        if (response instanceof Boolean && response) {
          this.router.navigateByUrl("");
          this.myForm.reset();
        } else {
          this.router.navigateByUrl(
            OnlineServicesProperties.backslash + OnlineServicesProperties.reg
          );
          this.myForm.reset();
        }
      });
    } else {
      console.log("jm");
    }
  }

  /* populating userDetails */
  populateUserDetails() {
    this.userDto.firstName =
      this.myForm.controls[OnlineServicesProperties.firstname].value;
    this.userDto.email =
      this.myForm.controls[OnlineServicesProperties.email].value;
    this.userDto.lastName =
      this.myForm.controls[OnlineServicesProperties.lastname].value;
    this.userDto.gender =
      this.myForm.controls[OnlineServicesProperties.genderVar].value;
    this.userDto.dob = new Intl.DateTimeFormat(
      OnlineServicesProperties.dateIntlFrmt
    ).format(this.formattedDate);
    this.userDto.contact =
      this.myForm.controls[OnlineServicesProperties.contact].value;
    this.userDto.password =
      this.myForm.controls[OnlineServicesProperties.pwd].value;
    this.userDto.isServiceProvider =
      this.myForm.controls[OnlineServicesProperties.svcProvider].value;
    this.userDto.location =
      this.myForm.controls[OnlineServicesProperties.city].value;
    this.userDto.address =
      this.myForm.controls[OnlineServicesProperties.address].value;
  }
}
