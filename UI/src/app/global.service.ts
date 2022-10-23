import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpStatusCode,
} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, map, Observable, throwError } from "rxjs";
import { HttpResoponseError } from "./models/HttpResponseError";

@Injectable({
  providedIn: "root",
})
export class GlobalService {
  constructor(private httpClient: HttpClient) {}

  public getRequest(url: string, serviceName?: string): Observable<any> {
    return this.httpClient
      .get(url)
      .pipe(catchError((error) => this.handleError(error)));
  }

  public postRequest(
    url: string,
    urlParameters: HttpParams,
    postBody?: any
  ): Observable<any> {
    return this.httpClient
      .post(url, postBody, this.getReqOptions(urlParameters))
      .pipe(catchError((error) => this.handleError(error)));
  }

  public putRequest(
    url: string,
    urlParameters: HttpParams,
    postBody?: any
  ): Observable<any> {
    return this.httpClient
      .put(url, postBody, this.getReqOptions(urlParameters))
      .pipe(catchError((error) => this.handleError(error)));
  }

  // private handleResponse(response: any) {
  //   let responseJSON = response;
  //   if (responseJSON.errorMessage) {
  //     throw new HttpResoponseError(
  //       200,
  //       responseJSON.errorMessage,
  //       responseJSON.errorDescription
  //     );
  //   }
  //   return responseJSON;
  // }

  private handleError(error: any): Observable<any> {
    return this.errorHandler(error);
  }

  private getReqOptions(urlParameters: HttpParams): any {
    let reqOptions = {};
    if (urlParameters) {
      reqOptions = {
        headers: new HttpHeaders({ "Content-Type": "application/json" }),
        params: urlParameters,
      };
    } else {
      reqOptions = {
        headers: new HttpHeaders({ "Content-Type": "application/json" }),
      };
    }
    return reqOptions;
  }

  errorHandler(error: HttpResoponseError) {
    return throwError(
      () =>
        new HttpResoponseError(error.status, error.errorMessage, "bad request")
    );
  }
}
