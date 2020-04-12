import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TeacherComponent } from './component/teacher/teacher.component';
import { StudentComponent } from './component/student/student.component';


const routes: Routes = [
  { path: "", redirectTo: "/", pathMatch: "full" },
  { path: "teacher", component: TeacherComponent },
  { path: "student", component : StudentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
