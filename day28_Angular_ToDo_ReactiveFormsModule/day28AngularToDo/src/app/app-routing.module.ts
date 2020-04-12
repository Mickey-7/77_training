import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewComponent } from './component/view/view.component';
import { AddComponent } from './component/add/add.component';
import { EditComponent } from './component/edit/edit.component';


const routes: Routes = [
  { path: "", redirectTo: "/", pathMatch: "full" },
  { path: "add", component: AddComponent},
  { path: "view", component: ViewComponent },
  { path: "edit/:id", component : EditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
