import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PrincipalEntidadeComponent } from './cadastrar/entidades.cadastrar';

const routes: Routes = [
  { path : 'entidades-cadastrar', component: PrincipalEntidadeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
