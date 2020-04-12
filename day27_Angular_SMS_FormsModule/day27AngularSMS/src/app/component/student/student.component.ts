import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student',
  template: `
  <p style="text-align:center">
    student works!
  </p>

    ID : <input [(ngModel)]="id" type="number" placeholder="Enter Student ID">
    Name : <input [(ngModel)]="name" type="text" placeholder="Enter Student Name">
    Grade : <input [(ngModel)]="grade" type="text" placeholder="Enter Student Grade">
    <button type="submit" (click)="addStudent()">Add Student</button>

  <hr/>
  <table border="1">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Grade</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <tr *ngFor="let student of students" >
        <td>{{student.id}}</td>
        <td>{{student.name}}</td>
        <td>{{student.grade}}</td>
        <td><button (click)="remove(student.id)">Remove</button></td>
      </tr>
    </tbody>
  <table>
  `,
  styles: [
  ]
})
export class StudentComponent implements OnInit {
  //field_name : datatype
  id: number;
  name : string;
  grade: number;

  //creating array ob student
  students : Array<{
    id:number,
    name:string,
    grade:number
  }> = [{
    id:1,
    name:"student1",
    grade:87.0
  }]

  addStudent(){
    this.students.push({
      id:this.id,
      name:this.name,
      grade:this.grade
    })
    //clear input fields
    this.id=null;
    this.name=null;
    this.grade=null;
  }

  remove(id){
    for (const i in this.students) {
      if (this.students[i].id===id) {
        this.students.splice(Number.parseFloat(i),1);
      }
    }
  }
  constructor() { }

  ngOnInit(): void {
  }

}
