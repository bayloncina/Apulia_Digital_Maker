import { Component, inject } from '@angular/core';
import {
  IonHeader,
  IonToolbar,
  IonTitle,
  IonContent,
  IonList,
  IonSkeletonText,
  IonLabel,
  IonButton,
  IonItem,
  IonCard,
  IonCardHeader,
  IonCardTitle,
  IonCardSubtitle,
  IonCardContent,
  IonSelect,
  IonSelectOption,
  IonText,
  IonPicker,
  IonFab,
  IonFabButton,
  IonIcon,
  IonAvatar,
  IonInfiniteScroll,
  IonInfiniteScrollContent,
  IonButtons,
} from '@ionic/angular/standalone';
import { ExploreContainerComponent } from '../explore-container/explore-container.component';
import { catchError, of } from 'rxjs';
import { AlertController } from '@ionic/angular';
import { Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MeetingService } from '../shared/services/meeting.service';
import { Meeting } from '../shared/interfaces/meeting';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  standalone: true,
  imports: [
    IonButtons,
    IonInfiniteScrollContent,
    IonInfiniteScroll,
    IonAvatar,
    IonIcon,
    IonFabButton,
    IonFab,
    IonPicker,
    IonText,
    IonCardContent,
    IonCardSubtitle,
    FormsModule,
    IonCardTitle,
    IonCardHeader,
    CommonModule,
    IonCard,
    IonItem,
    IonButton,
    IonLabel,
    IonSkeletonText,
    IonList,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonContent,
    ExploreContainerComponent,
    RouterModule,
    IonSelect,
    IonSelectOption,
  ],
})
export class Tab1Page {
  isLoading = false;
  isError = false;

  years: number[] = [];
  selectedYear: number | null = null;

  private api = inject(MeetingService);
  private alertCtrl = inject(AlertController);
  meeting: Meeting[] = [];
  private _router = inject(Router);

  constructor() {
    this.api
      .getMeetings()
      .pipe(
        catchError((err) => {
          this.isError = true;
          this.presentAlert(err.message);
          this.isLoading = false;
          return of([]);
        })
      )
      .subscribe((data) => {
        this.isLoading = false;
        this.meeting = data;
        this.years = Array.from(new Set(data.map((gp) => gp.year))).sort(
          (a, b) => b - a
        );
      });
  }

  getFilteredGranPrix() {
    if (this.selectedYear) {
      return this.meeting.filter((gp) => gp.year === this.selectedYear);
    } else {
      return this.meeting; // Show all grand prix if no year is selected
    }
  }
  OnRefreshPage() {
    location.reload();
  }
  async presentAlert(message: string) {
    const alert = await this.alertCtrl.create({
      header: 'OPS',
      message: `Si è verificato un errore: ${message}`,
      buttons: ['OK'],
    });
    await alert.present();
  }
}
