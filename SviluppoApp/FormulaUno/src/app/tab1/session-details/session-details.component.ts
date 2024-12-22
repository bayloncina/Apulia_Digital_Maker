import { Component, inject, Input } from '@angular/core';
import {IonItem,
  IonLabel, IonList,
  IonImg, IonContent,
  IonButtons,IonBackButton,
  IonSegment, IonButton, IonSegmentButton,IonSelect, IonSelectOption, IonCard, IonCardHeader, IonCardTitle, IonCardSubtitle,
  IonHeader, IonToolbar, IonTitle,} from '@ionic/angular/standalone';
import { DriverService } from 'src/app/shared/services/driver.service';
import { Driver } from 'src/app/shared/interfaces/driver';
import { ActivatedRoute } from '@angular/router';
import { PositionService } from 'src/app/shared/services/position.service';
import { ChartModule } from 'primeng/chart';
import { SessionService } from 'src/app/shared/services/session.service';
import { Session } from 'src/app/shared/interfaces/session';
import { CommonModule } from '@angular/common';
export type SegmentSessionDetail = 'drivers' | 'positions';

@Component({
  selector: 'app-session-details',
  templateUrl: './session-details.component.html',
  styleUrls: ['./session-details.component.scss'],
  standalone: true,
  imports: [
    IonTitle,
    IonToolbar, IonHeader,
    IonCardSubtitle,IonCardTitle,
    IonCardHeader,IonCard,
    IonSegmentButton,IonButton, ChartModule,
    IonImg, IonItem,
    IonLabel,IonList,IonContent, IonButtons, IonBackButton, IonSegment,IonLabel, ChartModule, IonItem,
    IonContent, IonSelect,IonSelectOption,CommonModule,],})

    export class SessionDetailsComponent {
  segmentValue: 'drivers' | 'positions' = 'drivers';
  apiSession = inject(SessionService);
  apiPosition = inject(PositionService);
  apiDriver = inject(DriverService);
  private _activatedRoute = inject(ActivatedRoute);
  sessionKey: number;
  sessions: Session[] = [];
  drivers: Driver[] = [];
  selectedDrivers: number[] = [];
  data: any;
  teamColour: string = '';

  options = {
    responsive: true,
    plugins: {
      legend: {
        position: 'top',
      },
    },
    scales: {
      x: {
        title: {
          display: true,
          text: 'Tempo',
        },
      },
      y: {
        title: {
          display: true,
          text: 'Posizione',
        },
      },
    },
  };

  constructor() {
    this.sessionKey = this._activatedRoute.snapshot.params['idSession'];
    this.apiSession
      .getSessions({ session_key: this.sessionKey })
      .subscribe((data) => {
        this.sessions = data;
      });

    this.apiDriver
      .getDrivers({ session_key: this.sessionKey })
      .subscribe((data) => {
        this.drivers = data;
      });
  }

  onDriversChange(event: any) {
    this.selectedDrivers = event.detail.value;
    this.loadDriversPosition();
  }

  loadDriversPosition() {
    if (this.selectedDrivers.length === 0) {
      this.data = null;
      return;
    }

    const datasets: {
      label: string;
      data: number[];
      fill: boolean;
      borderColor: string;
      tension: number;
    }[] = [];

    this.selectedDrivers.forEach((driverNumber) => {
      this.apiPosition
        .getDriverPosition({
          session_key: this.sessionKey,
          driver_number: driverNumber,
        })
        .subscribe((positions) => {
          const labels = positions.map((pos) =>
            new Date(pos.date).toLocaleTimeString()
          );
          const dataSet = positions.map((pos) => pos.position);

          datasets.push({
            label: `Pilota ${driverNumber}`,
            data: dataSet,
            fill: false,
            borderColor: this.getRandomColor(),
            tension: 0.4,
          });

          if (datasets.length === this.selectedDrivers.length) {
            this.data = {
              labels: labels,
              datasets: datasets,
            };
          }
        });
    });
  }

  getRandomColor(): string {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
  }
  onSegmentChange(event: any) {
    this.segmentValue = event.detail.value as SegmentSessionDetail;
  }
}
