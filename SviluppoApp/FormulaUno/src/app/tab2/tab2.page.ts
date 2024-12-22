import { Component, inject } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonCard, IonList, IonSkeletonText, IonCardHeader, IonCardTitle, IonCardSubtitle, IonLabel, IonButton, IonButtons } from '@ionic/angular/standalone';
import { ExploreContainerComponent } from '../explore-container/explore-container.component';
import { DriverService } from '../shared/services/driver.service';
import { Driver } from '../shared/interfaces/driver';
import { catchError, of } from 'rxjs';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss'],
  standalone: true,
  imports: [IonButtons, IonButton, IonLabel, IonCardSubtitle, IonCardTitle, IonCardHeader, IonSkeletonText, IonList, IonCard, IonHeader, IonToolbar, IonTitle, IonContent, ExploreContainerComponent],
})

export class Tab2Page {

  isLoading = false;
  isError = false;

  api = inject(DriverService);
  alertCtrl = inject(AlertController);

  drivers: Driver[] = [];

  constructor() {
    this.api.getDrivers().pipe(catchError((err) => {
      this.isError = true;
      this.presentAlert(err.message)
      this.isLoading = false;
      return of([]);
    }))
    .subscribe((data) => {
      this.isLoading = true;

      // Filtra i piloti per driver_number unico
      const uniqueDrivers = Array.from(new Map(data.map(driver => [driver.driver_number, driver])).values());
      this.drivers = uniqueDrivers;
    });
  }

  OnRefreshPage() {
    location.reload();
  }

  async presentAlert(message: string) {
    const alert = await this.alertCtrl.create({
      header: 'OPS',
      message:`Si è verificato un errore: ${message}`,
      buttons: ['OK'],
    });

    await alert.present();
  }
}