import { Injectable } from '@angular/core';
import { Todo } from '../domain/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  //to make id auto-increment
  //declare initial here (para global sa methods)
  private toDoId = 1;
  //create toDos with datatype of Todo class and blank array initial value
  //var_name : datatype = intial_value
  //mock holder of all Todo
  public toDos : Todo[] = [];

  //addTodo(input_param : datatype)
  public addTodo(todo : Todo){
    todo.id = this.toDoId;
    //to make id auto-increment
    this.toDoId++;
    todo.status = false;
    this.toDos.push(todo)
  } 

  //removeTodo
  public removeTodo(id){
    for (let i = 0; i < this.toDos.length; i++) {
      if (this.toDos[i].id===id) {
        this.toDos.splice(i,1);
      }
    }
  }

  public complete(id){
    for (const i in this.toDos) {
      if (this.toDos[i].id===id) {
        // this.toDos[i].status=true;
        //settling for toggle
        this.toDos[i].status = !this.toDos[i].status;
      }
    }
  }


  //return todo of the given id to be updated
  public getTodoById(id:number){
    return this.toDos.find(t=>t.id===id);
  }


  //seeting of updated todo
  public editTodo(id:number, newTodo : Todo){
    this.toDos.filter(t=>t.id===id).forEach(t=>{
      t.title = newTodo.title;
      t.description = newTodo.description;
    });
  }


  constructor() { }
}
