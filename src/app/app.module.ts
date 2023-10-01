import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { PrincipalEntidadeComponent } from './faces/entidade/entidades.cadastrar';
import { PrincipalPatrimonioComponent } from './faces/patrimonio/patrimonio.cadastrar';
import { SearchBoxComponent } from './shared/search-box/search-box.component';
import { TableComponent } from './shared/table/table.component';
import { AuthComponent } from './servico/auth/auth.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { AutocompleteFilterExample } from './shared/autocomplete-filter-example/autocomplete-filter-example.component';
import { MatAutocompleteModule } from '@angular/material/autocomplete';

@NgModule({
  declarations: [
    AppComponent,    
    PrincipalEntidadeComponent,
    PrincipalPatrimonioComponent,
    SearchBoxComponent,
    TableComponent,
    AuthComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    AutocompleteFilterExample,
    MatAutocompleteModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
