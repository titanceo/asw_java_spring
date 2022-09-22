import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { TurnsComponent } from './components/turns/turns.component';

const routes: Routes = [
  {
    path:'',
    component:LoginComponent
  },
  {
    path:'turns',
    component: TurnsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
