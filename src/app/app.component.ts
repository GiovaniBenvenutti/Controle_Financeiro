import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['../../src/styles.css']
})
export class AppComponent {
  title = 'Controle Financeiro';


constructor(private router: Router) {}
  navigateTo(route: string) {
    this.router.navigate([route]);
}}
