import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { Browse } from './pages/browse/browse';


export const routes: Routes = [
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'browse',
        component: Browse
    }
];
