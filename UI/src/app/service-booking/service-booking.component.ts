import { Component, OnInit } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { ServiceDto } from "../models/ServiceDto.dto";

@Component({
  selector: "app-service-booking",
  templateUrl: "./service-booking.component.html",
  styleUrls: ["./service-booking.component.scss"],
})
export class ServiceBookingComponent implements OnInit {
  selectedService!: string;
  ELEMENT_DATA: ServiceDto[] = [
    {
      id: "1",
      serviceName: "Hydrogen",
      serviceDetailId: "Hi",
    },
    {
      id: "1",
      serviceName: "Hydrogen",
      serviceDetailId: "Hi",
    },
    {
      id: "1",
      serviceName: "Hydrogen",
      serviceDetailId: "Hi",
    },
  ];
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);
  constructor() {}

  ngOnInit(): void {}
}
