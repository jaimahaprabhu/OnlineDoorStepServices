import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { FloatLabelType } from "@angular/material/form-field";
import { Observable } from "rxjs";
import { map, startWith } from "rxjs/operators";
import { ServiceDto } from "../models/ServiceDto.dto";
import { ServiceDeatils } from "../services/service-details.service";
import * as OnlineServicesProperties from "../utils/online-service-properties";
@Component({
  selector: "app-search-service",
  templateUrl: "./search-service.component.html",
  styleUrls: ["./search-service.component.scss"],
})
export class SearchServiceComponent implements OnInit {
  filteredOptions: Observable<ServiceDto[]> | undefined;
  services: ServiceDto[] = [];
  constructor(private _serviceDetails: ServiceDeatils) {}
  selectedService!: string;
  myForm!: FormGroup;
  isSearch: Boolean = false;
  ngOnInit() {
    this.getServices();
    this.myForm = new FormGroup({
      service: new FormControl([], [Validators.required]),
      floatLabelControl: new FormControl(
        OnlineServicesProperties.always as FloatLabelType
      ),
    });
    this.filteredOptions = this.myForm.controls["service"].valueChanges.pipe(
      startWith(""),
      map((value) => {
        const name = typeof value === "string" ? value : value?.serviceName;
        return name ? this._filter(name as string) : this.services;
      })
    );
  }

  private getServices(): ServiceDto[] {
    this._serviceDetails.getAllService().subscribe((data: any) => {
      this.services = data;
    });
    return this.services;
  }

  displayFn(service: ServiceDto): string {
    return service && service.serviceName ? service.serviceName : "";
  }

  private _filter(name: string): ServiceDto[] {
    const filterValue = name.toLowerCase();

    return this.services.filter((option) =>
      option.serviceName.toLowerCase().includes(filterValue)
    );
  }

  findService() {
    this.services.forEach((key) => {
      if (key === this.myForm.controls["service"].value) {
        console.log("entered");
        this.isSearch = true;
        this.selectedService = key.serviceName;
      }
    });
  }
}
// import { Component, OnInit } from "@angular/core";
// import { FormControl, FormGroup } from "@angular/forms";
// import { Observable } from "rxjs";
// import { map, startWith } from "rxjs/operators";
// import { ServiceDto } from "../models/ServiceDto.dto";
// import { ServiceDeatils } from "../services/service-details.service";

// @Component({
//   selector: "app-search-service",
//   templateUrl: "./search-service.component.html",
//   styleUrls: ["./search-service.component.scss"],
// })
// export class SearchServiceComponent implements OnInit {
//   myControl = new FormControl("");
//   filteredOptions: Observable<ServiceDto[]> | undefined;
//   services: ServiceDto[] = [];
//   constructor(private _serviceDetails: ServiceDeatils) {}
//   selected!: any;
//   myForm!: FormGroup;
//   ngOnInit() {
//     this.getServices();
//     this.myForm = new FormGroup({ searchservice: this.myControl });
//     this.filteredOptions = this.myControl.valueChanges.pipe(
//       startWith(""),
//       map((value) => {
//         const name = typeof value === "string" ? value : value?.serviceName;
//         return name ? this._filter(name as string) : this.services;
//       })
//     );
//   }

//   private getServices(): ServiceDto[] {
//     this._serviceDetails.getAllService().subscribe((data: any) => {
//       this.services = data;
//     });
//     return this.services;
//   }

//   displayFn(service: ServiceDto): string {
//     return service && service.serviceName ? service.serviceName : "";
//   }

//   private _filter(name: string): ServiceDto[] {
//     const filterValue = name.toLowerCase();

//     return this.services.filter((option) =>
//       option.serviceName.toLowerCase().includes(filterValue)
//     );
//   }

//   findService() {
//     console.log(this.myForm.value);
//   }
// }
