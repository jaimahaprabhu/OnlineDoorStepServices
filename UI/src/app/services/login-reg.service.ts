import { HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { EMPTY, Observable } from "rxjs";
import { GlobalService } from "../global.service";
import { UserDto } from "../models/UserDto.dto";
import * as OnlineServicesProperties from "../utils/online-service-properties";

@Injectable({
  providedIn: "root",
})
export class LoginRegService {
  public isLogin = false;
  user!: UserDto;

  constructor(public globalService: GlobalService) {}

  setStatus(isLog: boolean) {
    this.isLogin = isLog;
  }

  setUserDetails(userDto: UserDto) {
    this.user = userDto;
    localStorage.setItem("email", userDto.email);
  }

  getUserDetails() {
    return this.user;
  }

  //login with credentials : email, password
  public login(email: string, pwd: string): Observable<any> {
    const params = new HttpParams().set("email", email).set("password", pwd);
    return this.globalService.postRequest(
      OnlineServicesProperties.masterUrl + OnlineServicesProperties.login,
      params,
      ""
    );
  }

  //to create new user by passing user data
  public register(): Observable<any> {
    const params = new HttpParams();
    return this.globalService.postRequest(
      OnlineServicesProperties.masterUrl + OnlineServicesProperties.reg,
      params,
      this.getUserDetails()
    );
  }

  //logout based on email
  public logout(email: string): Observable<any> {
    let params = new HttpParams().set("email", email);
    return this.globalService.putRequest(
      OnlineServicesProperties.masterUrl + OnlineServicesProperties.logout,
      params,
      ""
    );
  }
}
