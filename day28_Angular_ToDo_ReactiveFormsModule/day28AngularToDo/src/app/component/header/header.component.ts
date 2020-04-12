import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  template: `
    <nav>
      <h3>
        <a [routerLink]="['/add']" routerLinkActive="router-link-active" >Add Todo</a>
      </h3>
      <hr/>
      <h3>
        <a [routerLink]="['/view']" routerLinkActive="router-link-active" >View Todo</a>
      </h3>
      <hr/>
    </nav>
  `,
  styles: [
  ]
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
