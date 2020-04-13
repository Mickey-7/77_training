import { Component, OnInit, ViewChild } from '@angular/core';
import { Supervisor } from 'src/app/domain/supervisor';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { SupervisorService } from 'src/app/service/supervisor.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Employee } from 'src/app/domain/employee';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-view-sup',
  template: `
  <hr/>
  <br/>
  <h3 style="text-align:center">View Supervisor</h3>

  <div class="flex-container">

    <div style="flex-grow:6">
    <!-- for filter -->
    <mat-form-field>
      <mat-label>Filter</mat-label>
      <input matInput (keyup)="applyFilter($event)" placeholder="Ex. Type something">
    </mat-form-field>
    </div>

    <div style="flex-grow:1">
    <button  mat-flat-button 
      [routerLink]="['/addSup']" routerLinkActive="router-link-active" 
    >
      Add Supervisor
    </button>
    </div>

  </div>


  <div class="mat-elevation-z8">
    <!-- sort table -->
    <table mat-table [dataSource]="dataSource" matSort>

    <!--- Note that these columns can be defined in any order.
          The actual rendered columns are set as a property on the row definition" -->

    <!-- ID Column -->
    <ng-container matColumnDef="id">
      <!-- sort column -->
      <th mat-header-cell *matHeaderCellDef mat-sort-header> ID </th>
      <td mat-cell *matCellDef="let element"> {{element.id}} </td>
    </ng-container>

    <!-- firstName Column -->
    <ng-container matColumnDef="first_name">
      <!-- sort column -->
      <th mat-header-cell *matHeaderCellDef mat-sort-header> First Name </th>
      <td mat-cell *matCellDef="let element"> {{element.firstName}} </td>
    </ng-container>

    <!-- lastName Column -->
    <ng-container matColumnDef="last_name">
      <!-- sort column -->
      <th mat-header-cell *matHeaderCellDef mat-sort-header> Last Name </th>
      <td mat-cell *matCellDef="let element"> {{element.lastName}} </td>
    </ng-container>

    <!-- gender Column -->
    <ng-container matColumnDef="gender">
    <!-- sort column -->
      <th mat-header-cell *matHeaderCellDef mat-sort-header> Gender </th>
      <td mat-cell *matCellDef="let element"> {{element.gender}} </td>
    </ng-container>


    <!-- delete Column -->
    <ng-container matColumnDef="del">
      <th mat-header-cell *matHeaderCellDef> Delete </th>
      <td mat-cell *matCellDef="let element">
      <!-- passing employee id -->
      <button (click)="deleteSupervisor(element.id)"  mat-flat-button >Remove</button>
      </td>
    </ng-container>

    <!-- update Column -->
    <ng-container matColumnDef="update">
      <th mat-header-cell *matHeaderCellDef> Update </th>
      <td mat-cell *matCellDef="let element">
      <!-- passing employee id -->
      <a  mat-flat-button 
        routerLink="/editSup/{{element.id}}" routerLinkActive="router-link-active" 
      >
        Edit
      </a>
      </td>
    </ng-container>



    <!-- addEmployeeToSupervisor Column -->
    <ng-container matColumnDef="addEmpToSup">
      <th mat-header-cell *matHeaderCellDef> Select Employee </th>
      <!-- element holds supervisor data -->
      <td mat-cell *matCellDef="let element">

      <!-- Start of MatSelect -->
      
        <!-- selected supervisor click event function  to get id-->
        <mat-select (click)="selectedSup(element.id)" placeholder="Employees">
          <!-- select employee click event function to get id-->
          <mat-option *ngFor="let employee of employees" (click)="selectedEmp(employee.id)">
              {{"ID : "+employee.id+" Name : "+employee.firstName}}
          </mat-option>
        </mat-select>

      </td>
    </ng-container>


    <!-- Confirm addEmployeeToSupervisor Column -->
    <ng-container matColumnDef="confirm">
      <th mat-header-cell *matHeaderCellDef> Confirm </th>
      <!-- element holds supervisor data -->
      <td mat-cell *matCellDef="let element">
      <button (click)="addEmployeeToSupervisor()"  mat-flat-button >Confirm</button>
      </td>
    </ng-container>


    <!--  viewSupById Column -->
    <ng-container matColumnDef="viewSupById">
      <th mat-header-cell *matHeaderCellDef> View </th>
      <!-- element holds supervisor data -->
      <td mat-cell *matCellDef="let element">
      <button mat-flat-button
        routerLink="/viewSupById/{{element.id}}" routerLinkActive="router-link-active"   
      >
        View Details
      </button>
      </td>
    </ng-container>




    <tr mat-header-row *matHeaderRowDef="displayedColumns"></tr>
    <tr mat-row *matRowDef="let row; columns: displayedColumns;"></tr>

   </table>
   
    <!-- for paginator -->
    <mat-paginator [pageSizeOptions]="[5, 10, 20]" showFirstLastButtons></mat-paginator>

  </div>
  `,
  styles: [`
  table {
    width : 100%;
  }
  .mat-form-field {
    font-size: 14px;
  }
  .flex-container{
    display:flex;
    align-items : center;
    margin-left: 10vh;
    margin-right: 10vh;
  }
  
  `]
})
export class ViewSupComponent implements OnInit {
  //seeting displayedColumns
  displayedColumns: string[] = [
    'id', 'first_name', 'last_name', 'gender','del',"update","addEmpToSup","confirm","viewSupById"
  ];
  //matColumnDef = pertains to displayedColumns
  //*matHeaderCellDef = pertains to Column name
  //*matCellDef = pertains to element of dataSource


  //seeting dataSource to none
  dataSource = new MatTableDataSource<Supervisor>();
 

  // for pagination
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  // for sort
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  //invoking service
  constructor(private supervisorService : SupervisorService,
    //invoking snack bar for delete 
    private  snackbar : MatSnackBar ,
    //invoking employee service for addEmployeeToSupervisor
    private employeeService : EmployeeService
  ) { }

  //storage for employees 
  employees : Employee[] = [];

  ngOnInit(): void {
    //invoking service method then subscribe to it
    this.supervisorService.viewSupervisors().subscribe(supervisors => {
      //seeting dataSource to subscribe variable
      this.dataSource.data = supervisors

      // set dataSource to  pagination
      this.dataSource.paginator = this.paginator
      // set dataSource to sort
      this.dataSource.sort = this.sort;
    })

    //invoking service getting all employees 
    this.employeeService.viewEmployees().subscribe(emps => {
      this.employees = emps;
    })

  }

  //for filter
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  //deleteEmployee
  //invoking service method then subscribe to it
  deleteSupervisor(id){
    console.log(id);
    this.supervisorService.deleteSupervisor(id).subscribe(sup => {
      console.log(sup);

      //need for the page to reflect the effect of delete action
      this.ngOnInit();

      //invoking snack bar
      this.snackbar.open("Successfully deleted Employee with ID : "+ id),
        "Close", {duration: 2000, verticalPosition : "bottom"}

    })
  }

  //storage for selected supervisor & employee id
  supId : number;
  empId : number;

  selectedSup(id){
    console.log(id);
    this.supId = id;
  }

  selectedEmp(id){
    console.log(id);
    this.empId = id;
  }
  

  //addEmployeeToSupervisor
  addEmployeeToSupervisor(){
    this.supervisorService.addEmployeeToSupervisor(this.supId,this.empId).subscribe(data => {
      console.log(data);


      //invoking snack bar
      this.snackbar.open("Successfully added Employee to Supervisor"),
      "Close", {duration: 10000, verticalPosition : "bottom"}
    })
  }


}
