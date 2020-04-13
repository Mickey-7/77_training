import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-header',
  template: `
  <mat-toolbar color="primary">
  <mat-toolbar-row >
      <span style="text-align: center;">Employee Management System</span>
      <!-- fill-space -->
      <span style="width: 50%;"></span>
      <!-- link for view employee -->
      <button [routerLink]="['/viewEmp']" routerLinkActive="router-link-active"  mat-flat-button color="primary">View Employee</button>
      <!-- link for view supervisor -->
      <button [routerLink]="['/viewSup']" routerLinkActive="router-link-active"  mat-flat-button color="primary">View Supervisor</button>
    </mat-toolbar-row>
  </mat-toolbar>
  `,
  styles: [
  ]
})
export class HeaderComponent implements OnInit {
  constructor() { 

  }

  ngOnInit(): void {

  }

}
