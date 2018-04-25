import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UserCreateComponent } from './user-create/user-create.component';
import { UserLoginComponent } from './user-login/user-login.component';
 
const routes: Routes = [
  {path: 'user', component: UserListComponent},
  {path: 'user/create', component: UserCreateComponent},
  {path: 'user/edit/:user_id', component: UserCreateComponent},
  {path: 'user/login', component: UserLoginComponent}
  // { path: '', redirectTo: '/user', pathMatch: 'full' }
];
 
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }