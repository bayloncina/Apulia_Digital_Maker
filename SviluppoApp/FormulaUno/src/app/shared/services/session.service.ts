import { inject, Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { Session } from '../interfaces/session';
import { map, Observable } from 'rxjs';
import { Meeting } from '../interfaces/meeting';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class SessionService {
  api = inject(ApiService);

  http = inject(HttpClient);

  getSessionsByMeetingId(meetingKey: number): Observable<Session[]> {
    return this.http.get<Session[]>(
      `${this.api.apiGet}/sessions?meetingKey=${meetingKey}`
    );
  }

  getSessions(attributes?: Partial<Session>): Observable<Session[]> {
    return this.api.apiGet<Session>('sessions', attributes);
  }

  
}
