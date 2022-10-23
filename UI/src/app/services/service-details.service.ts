import { Injectable } from "@angular/core";
import { Observable, Subject } from "rxjs";
import { GlobalService } from "../global.service";
import { ServiceDto } from "../models/ServiceDto.dto";

import * as OnlineServicesProperties from "../utils/online-service-properties";
@Injectable({
  providedIn: "root",
})
export class ServiceDeatils {
  public notify = new Subject();
  constructor(public globalService: GlobalService) {}

  // public getService(serviceName: string): Observable<ServiceDto[]> {
  //   return this.globalService.getRequest(
  //     OnlineServicesProperties.masterUrl + OnlineServicesProperties.getServices,
  //     serviceName
  //   );
  // }

  public getAllService(): Observable<ServiceDto[]> {
    return this.globalService.getRequest(
      OnlineServicesProperties.masterUrl + OnlineServicesProperties.getServices
    );
  }
}
