import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-teacher',
  template: `
    <p style="text-align:center">
      teacher works!
    </p>

    ID : <input [(ngModel)]="id" type="number" placeholder="Enter Teacher ID">
    Name : <input [(ngModel)]="name" type="text" placeholder="Enter Teacher Name">
    <button type="submit" (click)="addTeacher()">Add Teacher</button>
    
    <hr/>
    <table border="1">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let teacher of teachers" >
          <td>{{teacher.id}}</td>
          <td>{{teacher.name}}</td>
          <td><button (click)="remove(teacher.id)">Remove</button></td>
        </tr>
      </tbody>
    <table>
  `,
  styles: [
  ]
})
export class TeacherComponent implements OnInit {
  //declaring the fields involve and their datatype
  id: number;
  name : string;

  // create array for teacher
  // array_name : datatype = initial_values
  teachers : Array<{
    id : number;
    name : string;
  }> = [{
    id:1,
    name:"teacher1"
  }];

  addTeacher(){
    console.log(`${this.id} ${this.name}`)
    this.teachers.push({
      id : this.id,
      name : this.name
    });
    // clearing the form
    this.id = null;
    this.name = null;
  }

  remove(id){
    console.log(id);
    for (let i = 0; i < this.teachers.length; i++) {
      if (this.teachers[i].id===id) {
        this.teachers.splice(i,1);
      }
      
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}
