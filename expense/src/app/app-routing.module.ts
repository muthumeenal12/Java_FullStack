import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { TransactionsComponent } from './pages/transactions/transactions.component';
import { ReportComponent } from './pages/report/report.component';
import { TransactionListComponent } from './pages/transaction-list/transaction-list.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path:'transactions', component: TransactionsComponent},
  {path:'report', component: ReportComponent},
  {path:'transaction-list', component: TransactionListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
