import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SupervisorService } from 'src/app/service/supervisor.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Supervisor } from 'src/app/domain/supervisor';

@Component({
  selector: 'app-add-sup',
  template: `
  <hr/>
  <br/>
  <h3 style="text-align:center">Add Supervisor</h3>

  <!-- for ReactiveFormsModdule -->
  <form [formGroup]="supervisorForm" (ngSubmit)="addSupervisor()">

  <!-- no need since id is autogenerated on BE
  <mat-form-field  appearance="outline">
  <mat-label>ID</mat-label>

    <input matInput formControlName="id" type="number" class="example-right-align">
  </mat-form-field>
  -->

  <mat-form-field appearance="outline">
    <mat-label>Supervisor First Name</mat-label>
    <!-- add formControlName property -->
    <input matInput formControlName="firstName" placeholder="Enter Supervisor First Name">
    <mat-hint>First Name</mat-hint>
  </mat-form-field>

  <mat-form-field appearance="outline">
    <mat-label>Supervisor Last Name</mat-label>
    <!-- add formControlName property -->
    <input matInput formControlName="lastName" placeholder="Enter Supervisor Last Name">
    <mat-hint>Last Name</mat-hint>
  </mat-form-field>

  <mat-form-field appearance="outline">
  <mat-label>Gender</mat-label>
  <!-- add formControlName property -->
  <mat-select [(value)]="gender" formControlName="gender">
    <mat-option>None</mat-option>
    <mat-option value="male">Male</mat-option>
    <mat-option value="female">Female</mat-option>
  </mat-select>
  </mat-form-field>


  <button style="width:80%"  mat-flat-button [disabled]="!supervisorForm.valid" >Submit</button>
  </form>
  `,
  styles: [`
  .mat-form-field{
    width:80%;
    margin-left: 10vh;
    margin-right: 10vh;
  }
  button {
    margin-left: 10vh;
    margin-right: 10vh;
  }

  `]
})
export class AddSupComponent implements OnInit {
  supervisorForm = new FormGroup({
    // id : new FormControl("",[Validators.required]),
    firstName : new FormControl("",[Validators.required]),
    lastName : new FormControl("",[Validators.required]),
    gender : new FormControl("",[Validators.required]),
  })

  //storage for gender
  gender : string;

  //invoke service
  constructor(private supervisorService: SupervisorService,
    //invoke MatSnackBar  
    private snackbar : MatSnackBar
  ) { }

  ngOnInit(): void {
  }

  addSupervisor(){
    console.log(this.supervisorForm.value);
    //create employee then set to employeeForm to get values
    const supervisor : Supervisor = this.supervisorForm.value;
    this.supervisorService.addSupervisor(supervisor).subscribe(sup =>{
      console.log(sup);
      //clear input fields
      this.supervisorForm.reset();

      //invoke snackbar
      this.snackbar.open("Successfully added Supervisor with ID : "+supervisor.id),
        "Close", {duration : 2000, verticalPosition : "bottom"}

    })
  
  }
}
