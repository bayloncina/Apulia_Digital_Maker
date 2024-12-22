import { inject, Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Position } from '../interfaces/position';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PositionService {

  api = inject(ApiService);

  getDriverPosition(attributes?: Partial<Position>): Observable<Position[]> {
    return this.api.apiGet<Position>('position', attributes);
  }
}
