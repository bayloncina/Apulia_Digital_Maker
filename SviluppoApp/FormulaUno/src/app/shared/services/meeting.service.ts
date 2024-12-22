import { inject, Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Meeting } from '../interfaces/meeting';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MeetingService {
  api = inject(ApiService);

  getMeetings(attributes?: Partial<Meeting>): Observable<Meeting[]> {
    return this.api.apiGet<Meeting>('meetings', attributes);
  }
}
