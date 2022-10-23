import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FooterComponent } from "./footer/footer.component";
import { MaterialModule } from "../material/material.module";
import { HeaderComponent } from "./header/header.component";
import { AppRoutingModule } from "../app-routing.module";

@NgModule({
  declarations: [FooterComponent, HeaderComponent],
  imports: [CommonModule, MaterialModule, AppRoutingModule],
  exports: [HeaderComponent, FooterComponent],
})
export class SharedModule {}
