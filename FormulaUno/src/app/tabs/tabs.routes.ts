import { Routes } from '@angular/router';
import { TabsPage } from './tabs.page';
export const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'tab1',
        loadComponent: () =>
          import('../tab1/tab1.page').then((m) => m.Tab1Page),
      },
      {
        path: 'tab1/:idMeeting',
        loadComponent: () =>
          import('../tab1/meeting-details/meeting-details.component').then(
            (m) => m.MeetingDetailsComponent
          ),
      },
      {
        path: 'tab1/:idMeeting/:idSession',
        loadComponent: () =>
          import('../tab1/session-details/session-details.component').then(
            (m) => m.SessionDetailsComponent
          ),
      },

      {
        path: 'tab2',
        loadComponent: () =>
          import('../tab2/tab2.page').then((m) => m.Tab2Page),
      },

      {
        path: '',
        redirectTo: '/tabs/tab1',
        pathMatch: 'full',
      },
    ],
  },
  {
    path: '',
    redirectTo: '/tabs/tab1',
    pathMatch: 'full',
  },
];
