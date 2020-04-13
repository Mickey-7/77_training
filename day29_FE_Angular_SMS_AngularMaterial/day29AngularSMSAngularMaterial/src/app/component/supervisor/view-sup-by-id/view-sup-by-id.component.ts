import { Component, OnInit } from '@angular/core';
import { SupervisorService } from 'src/app/service/supervisor.service';
import { Supervisor } from 'src/app/domain/supervisor';
import { Employee } from 'src/app/domain/employee';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-sup-by-id',
  template: `
  <hr/>
  <br/>

  <div class="flexbox">

    <div>
    <h3 style="text-align:center">Supervisor Details</h3>
 
    <mat-list *ngIf="supervisor">
      <mat-list-item>First Name : {{supervisor.firstName}}</mat-list-item>
      <mat-divider></mat-divider>
      <mat-list-item>Last Name : {{supervisor.lastName}}</mat-list-item>
      <mat-divider></mat-divider>
      <mat-list-item>Gender : {{supervisor.gender}}</mat-list-item>
    </mat-list>
    </div>

  <hr/>


    <div>
    <h3 style="text-align:center">Employee Details</h3>
      <mat-list *ngFor="let employee of supervisor.employees">
        <mat-list-item>First Name : {{employee.firstName}}</mat-list-item>
        <mat-divider></mat-divider>
        <mat-list-item>Last Name : {{employee.lastName}}</mat-list-item>
        <mat-divider></mat-divider>
        <mat-list-item>Gender : {{employee.gender}}</mat-list-item>
        <mat-divider></mat-divider>
        <mat-list-item>Salary : {{employee.salary}}</mat-list-item>
        <mat-divider></mat-divider>
        <mat-list-item>Resigned : {{employee.resigned}}</mat-list-item>
      </mat-list>
    </div>

  </div>

  `,
  styles: [`
    .mat-list{
      width : 50vw;
    }
    .flexbox {
      display : flex;
    }

  `]
})
export class ViewSupByIdComponent implements OnInit {

  //invoke service
  constructor(private supervisorService : SupervisorService,
    //invoke ActivatedRoute
    private router : ActivatedRoute
  ) { }

  //storage for id, supervisor and employees
  id : number;
  supervisor : Supervisor;
  employees : Employee[] = [];

  ngOnInit(): void {
    //create blank supervisor array - storage for the selected supervisor
    this.supervisor = new Supervisor();
    //get the id of the selected supervisor by url route
    this.id = this.router.snapshot.params["id"];
    this.supervisorService.viewSupervisorById(this.id).subscribe(supData => {
      console.log(supData);
      //seetnig blank supervisor to selected supervisor (supData)
      this.supervisor = supData;

    })
  }

}
