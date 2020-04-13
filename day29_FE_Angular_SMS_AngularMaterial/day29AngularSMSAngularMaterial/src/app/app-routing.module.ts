import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEmpComponent } from './component/employee/add-emp/add-emp.component';
import { EditEmpComponent } from './component/employee/edit-emp/edit-emp.component';
import { ViewEmpComponent } from './component/employee/view-emp/view-emp.component';
import { AddSupComponent } from './component/supervisor/add-sup/add-sup.component';
import { EditSupComponent } from './component/supervisor/edit-sup/edit-sup.component';
import { ViewSupComponent } from './component/supervisor/view-sup/view-sup.component';
import { ViewSupByIdComponent } from './component/supervisor/view-sup-by-id/view-sup-by-id.component';


const routes: Routes = [
  {path:"", pathMatch:"full", redirectTo:"/"},
  {path:"addEmp", component : AddEmpComponent},
  {path:"viewEmp", component : ViewEmpComponent},
  {path:"editEmp/:id", component : EditEmpComponent},
  {path:"addSup", component : AddSupComponent},
  {path:"viewSup", component : ViewSupComponent},
  {path:"editSup/:id", component : EditSupComponent},
  {path:"viewSupById/:id", component : ViewSupByIdComponent},


]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
