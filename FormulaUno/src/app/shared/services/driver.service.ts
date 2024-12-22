import { inject, Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Driver } from '../interfaces/driver';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DriverService {
  api = inject(ApiService);

  getDrivers(attributes?: Partial<Driver>): Observable<Driver[]> {
    return this.api.apiGet<Driver>('drivers', attributes);
  }
}
