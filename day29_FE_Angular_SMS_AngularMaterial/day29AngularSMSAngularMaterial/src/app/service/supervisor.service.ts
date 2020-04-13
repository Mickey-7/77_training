import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Supervisor } from '../domain/supervisor';
import { Observable } from 'rxjs';
import { Employee } from '../domain/employee';

@Injectable({
  providedIn: 'root'
})
export class SupervisorService {
  //create string for url used in BE - /employee is the @RequestMapping
  private url = "http://localhost:8080/supervisor"

  //invoking HttpClient
  constructor(private http : HttpClient) { }

  //the Observable datatype coresponds to the http method datatype
  //if no Observable then there should be no datatype on http method - delete

  //addEmployee 
  //function_name(input :datatype):Observable<datatype>
  addSupervisor(supervisor : Supervisor):Observable<Supervisor>{
    //return this.http.post<datatype>(url,body)
    return this.http.post<Supervisor>(this.url,supervisor)
  }

  //editEmployee
  editSupervisor(id:number,supervisor: Supervisor):Observable<Supervisor>{
    // @PutMapping("edit/{id}") from BE - put<datatype>(url,body)
   return this.http.put<Supervisor>(this.url+"/edit/"+id,supervisor);

  }

  //deleteEmployee
  deleteSupervisor(id:number){
    // @DeleteMapping("delete/{id}") from BE - delete<datatype>(url)
    return this.http.delete(this.url+"/delete/"+id)
  }

  //viewEmployees
  viewSupervisors():Observable<Supervisor[]>{
    // @GetMapping
    return this.http.get<Supervisor[]>(this.url);
  }

  //viewEmployeeById - for update
  viewSupervisorById(id:number):Observable<Supervisor>{
    // @GetMapping("view/{id}") from BE
    return this.http.get<Supervisor>(this.url+"/view/"+id);
  }

  //addEmployeeToSupervisor
  addEmployeeToSupervisor(supId: number, empId: number ):Observable<Employee>{
    //the Employee body pertains to employee with empId
    return this.http.post<Employee>(this.url+"/"+supId+"/add/"+empId, Employee);
  }

}
