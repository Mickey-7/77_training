import { Component, OnInit } from '@angular/core';
import { TodoService } from 'src/app/service/todo.service';
import { Todo } from 'src/app/domain/todo';

@Component({
  selector: 'app-view',
  template: `
  <h3 style="text-align:center">View Todo</h3>
  <table border="1">
    <tr>
      <th>ID</th>
      <th>Title</th>
      <th>Description</th>
      <th>Status</th>
      <th>Delete</th>
      <th>Complete</th>
      <th>Modify</th>
    </tr>
    <tr *ngFor="let todo of todos">
      <td>{{ todo.id }}</td>
      <td>{{ todo.title }}</td>
      <td>{{ todo.description }}</td>
      <td>{{ todo.status }}</td>
      <td>
        <button (click)="removeTodo(todo.id)"  type="button"  >Remove</button>
      </td>
      <td>
        <input (click)="completeTodo(todo.id)" type="checkbox" />
      </td>
      <td>
        <button type="button">
          <a
          routerLink="/edit/{{todo.id}}" routerLinkActive="router-link-active" >
            Edit Todo
          </a>
        </button>
      </td>
    </tr>
  </table>
  `,
  styles: [
  ]
})
export class ViewComponent implements OnInit {
  //create temporary array of Todo
  //related to todos above and toDos mock of all todo
  todos : Todo[] = [];

  //invoking service
  constructor(private todoService : TodoService) { }

  ngOnInit(): void {
    //set mock of all Todo to temporary Todo
    //notice the toDos and todos !!!!!!!
    this.todos = this.todoService.toDos
  }

  removeTodo(id){
    this.todoService.removeTodo(id);
  }

  completeTodo(id){
    this.todoService.complete(id);
  }

}
