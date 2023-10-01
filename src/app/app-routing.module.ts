import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PrincipalEntidadeComponent } from './faces/entidade/entidades.cadastrar';
import { PrincipalPatrimonioComponent } from './faces/patrimonio/patrimonio.cadastrar';


const routes: Routes = [
  { path : 'entidades-cadastrar', component: PrincipalEntidadeComponent },
  { path : 'patrimonio-cadastrar', component: PrincipalPatrimonioComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
