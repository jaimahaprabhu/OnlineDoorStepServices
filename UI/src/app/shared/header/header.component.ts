import { Component, OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { Router } from "@angular/router";
import { LoginComponent } from "src/app/login/login.component";
import { RegistrationComponent } from "src/app/registration/registration.component";
import { LoginRegService } from "src/app/services/login-reg.service";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.scss"],
})
export class HeaderComponent implements OnInit {
  constructor(
    private router: Router,
    private loginRegService: LoginRegService,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {}

  getStatus(): any {
    return this.loginRegService.isLogin;
  }

  openDialog(val: Boolean) {
    this.dialog.open(LoginComponent, { data: val });
  }
  openRegDialog() {
    this.dialog.open(RegistrationComponent);
  }

  logout() {}
}
