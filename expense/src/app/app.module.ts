import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { TransactionsComponent } from './pages/transactions/transactions.component';
import { TransactionListComponent } from './pages/transaction-list/transaction-list.component';
import { ReportComponent } from './pages/report/report.component';
import { LoginComponent } from './common/login/login.component';
import { MenuBarComponent } from './common/menu-bar/menu-bar.component';
import { DateFormatPipe } from './pipes/date-format.pipe';
import { CurrencyFormatPipe } from './pipes/currency-format.pipe';
import { TransactionTypePipe } from './pipes/transaction-type.pipe';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatToolbarModule } from '@angular/material/toolbar';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { TransactionFilterPipe } from './pipes/transaction-filter.pipe';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TransactionsComponent,
    TransactionListComponent,
    ReportComponent,
    LoginComponent,
    MenuBarComponent,
    DateFormatPipe,
    CurrencyFormatPipe,
    TransactionTypePipe,
    TransactionFilterPipe,
  ],
  imports: [
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserModule,
    FormsModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatChipsModule,
    MatToolbarModule
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
