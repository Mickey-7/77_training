import { Component, OnInit } from '@angular/core';
import { TodoService } from 'src/app/service/todo.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Todo } from 'src/app/domain/todo';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit',
  template: `
  <h3 style="text-align : center">Edit Todo</h3>
    <!-- snippet : a-formG -->
  <form [formGroup]="toDoForm" (ngSubmit)="editTodo()">
  <label>Title :
    <!-- snippet : a-formC -->
    <input formControlName="title"  type="text" placeholder="Enter new ToDo Title">
  </label>
  <label>Description :
    <!-- snippet : a-formC -->
    <input formControlName="description"  type="text" placeholder="Enter new ToDo Description">
  </label>
  <!-- if inputs are not valid then submit not -->
  <button [disabled]="!toDoForm.valid" type="submit">Submit New ToDo</button>
  </form>
  `,
  styles: [
  ]
})
export class EditComponent implements OnInit {
  //seeting validation on form group
  toDoForm = new FormGroup({
    title : new FormControl("",[Validators.required]),
    description : new FormControl("",[Validators.required])
  })

  //invoking service
  constructor(private todoService : TodoService,
    //invoking router for getting id on URL
    private router :ActivatedRoute
  ) { }

  ngOnInit(): void {
  }

  //geeting id of todo to be updated
  id : number = +this.router.snapshot.paramMap.get("id");
  //set temporaty storage of new Todo to selected todo
  newTodo : Todo = this.todoService.getTodoById(this.id);

  editTodo(){
    //set the parameter needed for editTodo to form values
    this.newTodo = this.toDoForm.value;
    this.todoService.editTodo(this.id,this.newTodo);
    //clear input form
    this.toDoForm.reset();

  }



}
