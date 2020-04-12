import { Component, OnInit } from '@angular/core';
import { TodoService } from 'src/app/service/todo.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Todo } from 'src/app/domain/todo';

@Component({
  selector: 'app-add',
  template: `
    <h3 style="text-align : center">Add Todo</h3>
        <!-- snippet : a-formG -->
    <form [formGroup]="toDoForm" (ngSubmit)="addTodo()">
      <label>Title :
        <!-- snippet : a-formC -->
        <input formControlName="title"  type="text" placeholder="Enter ToDo Title">
      </label>
      <label>Description :
        <!-- snippet : a-formC -->
        <input formControlName="description"  type="text" placeholder="Enter ToDo Description">
      </label>
      <!-- if inputs are not valid then submit not -->
      <button [disabled]="!toDoForm.valid" type="submit">Submit ToDo</button>
    </form>
  `,
  styles: [
  ]
})
export class AddComponent implements OnInit {
  //seeting validation on form group
  toDoForm = new FormGroup({
    title : new FormControl("",[Validators.required]),
    description : new FormControl("",[Validators.required])
  })

  //invoking service
  constructor(private todoService : TodoService) { }

  addTodo(){
    //setting toDoForm to todo input for addTodo
    const todo : Todo = this.toDoForm.value;
    this.todoService.addTodo(todo);
    //clear input fields
    this.toDoForm.reset();
  }

  ngOnInit(): void {
  }

}
