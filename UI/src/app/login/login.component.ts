import { Component, EventEmitter, Inject, OnInit, Output } from "@angular/core";
import { UserDto } from "../models/UserDto.dto";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { FloatLabelType } from "@angular/material/form-field/form-field";
import { LoginRegService } from "../services/login-reg.service";

import { Router } from "@angular/router";
import { MatDialog, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { RegistrationComponent } from "../registration/registration.component";
import * as OnlineServicesProperties from "../utils/online-service-properties";
import { SearchServiceComponent } from "../search-service/search-service.component";
import { HttpClientModule, HttpStatusCode } from "@angular/common/http";
import { HttpResoponseError } from "../models/HttpResponseError";
import { MatSnackBar } from "@angular/material/snack-bar";
@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.scss"],
})
export class LoginComponent implements OnInit {
  myForm!: FormGroup;
  eg!: boolean;
  email!: string;
  pwd!: string;
  user!: UserDto;
  errorMsg!: string;

  @Output() loginEvent = new EventEmitter<UserDto>();

  ngOnInit(): void {
    this.myForm = new FormGroup({
      email: new FormControl([], [Validators.required, Validators.email]),
      password: new FormControl(
        [],
        [
          Validators.required,
          Validators.pattern(OnlineServicesProperties.pwdValPattern),
        ]
      ),
      floatLabelControl: new FormControl(
        OnlineServicesProperties.always as FloatLabelType
      ),
    });
  }

  constructor(
    private loginRegService: LoginRegService,
    private router: Router,
    @Inject(MAT_DIALOG_DATA) public data: Boolean,
    public dialog: MatDialog,
    private _snackBar: MatSnackBar
  ) {}

  login($event: Event, isLogin: boolean) {
    let submitText: string = "";
    if (isLogin) {
      let em = this.myForm.controls[OnlineServicesProperties.email].value;
      this.loginRegService
        .login(
          this.myForm.controls[OnlineServicesProperties.email].value,
          this.myForm.controls[OnlineServicesProperties.pwd].value
        )

        .subscribe({
          next: (response: any) => {
            this.dialog.open(SearchServiceComponent);
            this.loginRegService.isLogin = true;
            this.user = response;
            this.loginRegService.setUserDetails(this.user);
            submitText = "Hi " + this.user.firstName;
            this._snackBar.open(submitText, "", {
              duration: 2000,
            });
          },
          error: (err) => {
            if (err?.status === HttpStatusCode.BadRequest) {
              this.dialog.open(LoginComponent, { data: true });
              submitText =
                "Check your Login creadentials. Inavlid mail or password";
              this._snackBar.open(submitText, "Ok", { duration: 40000 });
              console.log("error in login");
            }
          },
        });
    } else {
      this.router.navigateByUrl(
        OnlineServicesProperties.backslash + OnlineServicesProperties.reg
      );
      this.loginRegService.setStatus(false);
      submitText = "successfully logged out";
    }
  }

  public logout() {
    let params: any;
    let isLogout: Boolean = false;
    let mail;
    if (localStorage.getItem(OnlineServicesProperties.email) != null) {
      mail = localStorage.getItem(OnlineServicesProperties.email);

      if (
        this.loginRegService.getUserDetails() !== null &&
        this.loginRegService.isLogin &&
        mail != null
      ) {
        this.loginRegService.logout(mail).subscribe((response) => {
          if (response) {
            this.loginRegService.setStatus(false);
          }
          this.router.navigateByUrl("");
        });
      }
    }
  }

  openRegDialog() {
    this.dialog.open(RegistrationComponent);
  }
}
