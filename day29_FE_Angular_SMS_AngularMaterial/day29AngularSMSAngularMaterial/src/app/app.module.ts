import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


import { AddEmpComponent } from './component/employee/add-emp/add-emp.component';
import { EditEmpComponent } from './component/employee/edit-emp/edit-emp.component';
import { ViewEmpComponent } from './component/employee/view-emp/view-emp.component';
import { AddSupComponent } from './component/supervisor/add-sup/add-sup.component';
import { ViewSupComponent } from './component/supervisor/view-sup/view-sup.component';
import { EditSupComponent } from './component/supervisor/edit-sup/edit-sup.component';
import { HeaderComponent } from './component/header/header.component';
import { ViewSupByIdComponent } from './component/supervisor/view-sup-by-id/view-sup-by-id.component';

//manually imported
import {HttpClientModule} from '@angular/common/http';
//for anuglar material
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
//must be together - MatFormFieldModule & MatInputModule
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatCardModule} from '@angular/material/card';
import {ReactiveFormsModule} from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';
//must be together - MatDividerModule & MatListModule
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';

@NgModule({
  declarations: [
    AppComponent,
    AddEmpComponent,
    EditEmpComponent,
    ViewEmpComponent,
    AddSupComponent,
    ViewSupComponent,
    EditSupComponent,
    HeaderComponent,
    ViewSupByIdComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    //imported manually
    HttpClientModule,
    //for anuglar material
    MatToolbarModule,
    MatButtonModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    //must be together - MatFormFieldModule & MatInputModule
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatCardModule,
    ReactiveFormsModule,
    MatSnackBarModule,
    MatDividerModule,
    MatListModule
    
    

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
