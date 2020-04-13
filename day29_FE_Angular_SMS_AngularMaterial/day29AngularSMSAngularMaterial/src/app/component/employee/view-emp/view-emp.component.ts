import { Component, OnInit, ViewChild } from '@angular/core';
import { Employee } from 'src/app/domain/employee';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { EmployeeService } from 'src/app/service/employee.service';
import { MatSnackBar } from '@angular/material/snack-bar';

//creating mock date
let employeeData : Employee[] = [
{"id":1,"firstName":"Kaja","lastName":"Bewsey","gender":"Female","salary":58616.98,"resigned":false},
{"id":2,"firstName":"Laurianne","lastName":"Harby","gender":"Female","salary":88003.65,"resigned":true},
{"id":3,"firstName":"Miguelita","lastName":"Strowlger","gender":"Female","salary":78944.50,"resigned":true},
{"id":4,"firstName":"Georgianna","lastName":"Wodham","gender":"Female","salary":52100.00,"resigned":true},
{"id":5,"firstName":"Lorelle","lastName":"Pelosi","gender":"Female","salary":50571.52,"resigned":false},
{"id":6,"firstName":"Calhoun","lastName":"Deener","gender":"Male","salary":70482.16,"resigned":true},
{"id":7,"firstName":"Carree","lastName":"Sappell","gender":"Female","salary":77240.66,"resigned":false},
{"id":8,"firstName":"Bard","lastName":"Atteridge","gender":"Male","salary":86302.95,"resigned":false},
{"id":9,"firstName":"Cecily","lastName":"O' Brian","gender":"Female","salary":87049.11,"resigned":false},
{"id":10,"firstName":"Maximo","lastName":"Wyman","gender":"Male","salary":75114.81,"resigned":true},
{"id":11,"firstName":"Costanza","lastName":"O Mullen","gender":"Female","salary":78301.62,"resigned":true},
{"id":12,"firstName":"Laurene","lastName":"Muff","gender":"Female","salary":74180.46,"resigned":false},
{"id":13,"firstName":"Gwendolen","lastName":"Aberdein","gender":"Female","salary":73473.34,"resigned":false},
{"id":14,"firstName":"Hashim","lastName":"Gegay","gender":"Male","salary":57272.83,"resigned":false},
{"id":15,"firstName":"Brianna","lastName":"Marchington","gender":"Female","salary":66288.94,"resigned":false},
{"id":16,"firstName":"Phebe","lastName":"Martelet","gender":"Female","salary":98805.09,"resigned":true},
{"id":17,"firstName":"Harriot","lastName":"Ledes","gender":"Female","salary":72196.82,"resigned":false},
{"id":18,"firstName":"Crosby","lastName":"Wartonby","gender":"Male","salary":58227.41,"resigned":false},
{"id":19,"firstName":"Briny","lastName":"Pirdue","gender":"Female","salary":72087.02,"resigned":true},
{"id":20,"firstName":"Emalia","lastName":"Puzey","gender":"Female","salary":98288.44,"resigned":true},
{"id":21,"firstName":"Denise","lastName":"Lente","gender":"Female","salary":76450.75,"resigned":false},
{"id":22,"firstName":"Artie","lastName":"Santus","gender":"Male","salary":80244.21,"resigned":true},
{"id":23,"firstName":"Helsa","lastName":"Grumbridge","gender":"Female","salary":64028.62,"resigned":true},
{"id":24,"firstName":"Karin","lastName":"Hedditch","gender":"Female","salary":78075.99,"resigned":true},
{"id":25,"firstName":"Duffy","lastName":"Jemmison","gender":"Male","salary":90992.89,"resigned":true},
{"id":26,"firstName":"Evania","lastName":"Trowell","gender":"Female","salary":85720.75,"resigned":false},
{"id":27,"firstName":"Martha","lastName":"Balham","gender":"Female","salary":61920.51,"resigned":false},
{"id":28,"firstName":"Zacharias","lastName":"Matkovic","gender":"Male","salary":52791.96,"resigned":false},
{"id":29,"firstName":"Tessy","lastName":"Peakman","gender":"Female","salary":62364.93,"resigned":true},
{"id":30,"firstName":"Binny","lastName":"Byram","gender":"Female","salary":95480.44,"resigned":true},
]

@Component({
  selector: 'app-view-emp',
  template: `
  <hr/>
  <br/>
  <h3 style="text-align:center">View Employee</h3>

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
      [routerLink]="['/addEmp']" routerLinkActive="router-link-active" 
    >
      Add Employee
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

    <!-- salary Column -->
    <ng-container matColumnDef="salary">
    <!-- sort column -->
      <th mat-header-cell *matHeaderCellDef mat-sort-header> Salary </th>
      <td mat-cell *matCellDef="let element"> {{element.salary}} </td>
    </ng-container>

    <!-- resigned Column -->
    <ng-container matColumnDef="resigned">
      <!-- sort column -->
      <th mat-header-cell *matHeaderCellDef mat-sort-header> Active </th>
      <td mat-cell *matCellDef="let element"> {{element.resigned}} </td>
    </ng-container>

    <!-- delete Column -->
    <ng-container matColumnDef="del">
      <th mat-header-cell *matHeaderCellDef> Delete </th>
      <td mat-cell *matCellDef="let element">
      <!-- passing employee id -->
      <button (click)="deleteEmployee(element.id)"  mat-flat-button >Remove</button>
      </td>
    </ng-container>

    <!-- update Column -->
    <ng-container matColumnDef="update">
      <th mat-header-cell *matHeaderCellDef> Update </th>
      <td mat-cell *matCellDef="let element">
      <!-- passing employee id -->
      <a  mat-flat-button 
        routerLink="/editEmp/{{element.id}}" routerLinkActive="router-link-active" 
      >
        Edit
      </a>
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
export class ViewEmpComponent implements OnInit {
  // //setting dataSource
  // dataSource = employeeData;

  //seeting displayedColumns
  displayedColumns: string[] = [
    'id', 'first_name', 'last_name', 'gender', 'salary','resigned','del',"update"
  ];
  //matColumnDef = pertains to displayedColumns
  //*matHeaderCellDef = pertains to Column name
  //*matCellDef = pertains to element of dataSource

  // //setting dataSource for paginator
  // //MatTableDataSource<Class-object>(array-variable)
  // dataSource = new MatTableDataSource<Employee>(employeeData);

  //seeting dataSource to none
  dataSource = new MatTableDataSource<Employee>();
 

  // for pagination
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  // for sort
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  //invoking service
  constructor(private employeeService : EmployeeService,
    //invoking snack bar for delete 
    private  snackbar : MatSnackBar 
  ) { }

  ngOnInit(): void {
    //invoking service method then subscribe to it
    this.employeeService.viewEmployees().subscribe(employees => {
      //seeting dataSource to subscribe variable
      this.dataSource.data = employees

      // set dataSource to  pagination
      this.dataSource.paginator = this.paginator
      // set dataSource to sort
      this.dataSource.sort = this.sort;
    })

  }

  //for filter
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  //deleteEmployee
  //invoking service method then subscribe to it
  deleteEmployee(id){
    console.log(id);
    this.employeeService.deleteEmployee(id).subscribe(emp => {
      console.log(emp);

      //need for the page to reflect the effect of delete action
      this.ngOnInit();

      //invoking snack bar
      this.snackbar.open("Successfully deleted Employee with ID : "+ id),
        "Close", {duration: 2000, verticalPositikon : "top"}

    })
  }
}
