import { Component, inject, Input, OnInit } from '@angular/core';
import { Session } from 'src/app/shared/interfaces/session';
import { SessionService } from 'src/app/shared/services/session.service';
import {
  IonCard,
  IonCardHeader,
  IonCardTitle,
  IonCardSubtitle,
  IonCardContent,
  IonList,
  IonItem,
  IonContent,
  IonButtons,
  IonBackButton,
  IonSegment,
  IonSegmentButton,
  IonLabel,
  IonButton,
  IonHeader,
  IonToolbar,
  IonTitle,
} from '@ionic/angular/standalone';
import { Driver } from 'src/app/shared/interfaces/driver';
import { DriverService } from 'src/app/shared/services/driver.service';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
export type SegmentMeetingDetail = 'sessions' | 'drivers';

@Component({
  selector: 'app-meeting-details',
  templateUrl: './meeting-details.component.html',
  styleUrls: ['./meeting-details.component.scss'],
  standalone: true,
  imports: [
    IonTitle,
    IonToolbar,
    IonHeader,
    IonButton,
    IonLabel,
    IonSegmentButton,
    IonSegment,
    IonBackButton,
    IonButtons,
    IonContent,
    IonItem,
    IonList,
    IonCardContent,
    IonCardSubtitle,
    IonCardTitle,
    IonCardHeader,
    IonCard,
    RouterModule,
  ],
})
export class MeetingDetailsComponent {
  segmentValue: 'sessions' | 'drivers' = 'sessions';
  meetingKey: string;
  sessions: Session[] = [];
  drivers: Driver[] = [];
  apiDriver = inject(DriverService);
  apiSession = inject(SessionService);
  router = inject(Router);
  private _activatedRoute = inject(ActivatedRoute);

  constructor() {
    this.meetingKey = this._activatedRoute.snapshot.params['idMeeting'];
    this.apiSession
      .getSessions({ meeting_key: parseInt(this.meetingKey) })
      .subscribe((data) => {
        this.sessions = data;
      });
    this.apiDriver
      .getDrivers({ meeting_key: parseInt(this.meetingKey) })
      .subscribe((data) => {
        this.drivers = data;
      });
  }

  openDetailPage(sessionKey: string) {
    this.router.navigate([`/tabs/tab1/${sessionKey}`]);
  }

  onSegmentChange(event: any) {
    this.segmentValue = event.detail.value as SegmentMeetingDetail;
  }
}
