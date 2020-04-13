import { Injectable } from '@angular/core';
import { Employee } from '../domain/employee';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  //create string for url used in BE - /employee is the @RequestMapping
  private url = "http://localhost:8080/employee"

  //invoking HttpClient
  constructor(private http : HttpClient) { }

  //the Observable datatype coresponds to the http method datatype
  //if no Observable then there should be no datatype on http method - delete

  //addEmployee 
  //function_name(input :datatype):Observable<datatype>
  addEmployee(employee : Employee):Observable<Employee>{
    //return this.http.post<datatype>(url,body)
    return this.http.post<Employee>(this.url,employee)
  }

  //editEmployee
  editEmployee(id:number,employee: Employee):Observable<Employee>{
    // @PutMapping("edit/{id}") from BE - put<datatype>(url,body)
   return this.http.put<Employee>(this.url+"/edit/"+id,employee);

  }

  //deleteEmployee
  deleteEmployee(id:number){
    // @DeleteMapping("delete/{id}") from BE - delete<datatype>(url)
    return this.http.delete(this.url+"/delete/"+id)
  }

  //viewEmployees
  viewEmployees():Observable<Employee[]>{
    // @GetMapping
    return this.http.get<Employee[]>(this.url);
  }

  //viewEmployeeById - for update
  viewEmployeeById(id:number):Observable<Employee>{
    // @GetMapping("view/{id}") from BE
    return this.http.get<Employee>(this.url+"/view/"+id);
  }


}
