import { HttpClient, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private _http = inject(HttpClient);
  private _apiRoot = environment.apiRoot;
  


  mapAttributes<T>(attributes: Partial<T>) : HttpParams {
    let params = new HttpParams();

    Object.keys(attributes).forEach((keys) => {
      Object.keys(attributes).forEach((key) => {
        const value = attributes[key as keyof T];
        if (value) {
          params = params.set(key, value.toString());
        }
      });
    });

    return params;
  }


  apiGet<T>(endpoint: string, attributes?: Partial<T>) : Observable<T[]>{
    let params = new HttpParams();
    
      if(attributes) {
        params = this.mapAttributes<T>(attributes);
      }

      return this._http.get<T[]>(`${this._apiRoot}${endpoint}`, {params});
  }

  constructor() { }
}

