import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConductDetailsComponent } from './conduct-details/conduct-details.component';
import { ConductListComponent } from './conduct-list/conduct-list.component';
import { CreateConductComponent } from './create-conduct/create-conduct.component';
import { UpdateConductComponent } from './update-conduct/update-conduct.component';

const routes: Routes = [
  { path: '', redirectTo: 'counduct', pathMatch: 'full' },
  { path: 'counduct', component: ConductListComponent },
  { path: 'add', component: CreateConductComponent },
  { path: 'update/:id', component: UpdateConductComponent },
  { path: 'details/:id', component: ConductDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
