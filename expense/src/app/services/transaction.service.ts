import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { transaction } from '../model/transaction';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private apiUrl = 'http://localhost:4500'; // Adjust API URL if needed

  private totalExpensesSubject = new BehaviorSubject<number>(0);
  totalExpenses$ = this.totalExpensesSubject.asObservable();

  constructor(private http: HttpClient) {
    this.loadTotalExpenses();
  }

  /** Fetch Total Expenses from API */
  getTotalExpenses(): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/total-expenses`).pipe(
      tap((total) => this.totalExpensesSubject.next(total))
    );
  }

  /** Fetch Transactions */
  getTransactions(): Observable<transaction[]> {
    return this.http.get<transaction[]>(`${this.apiUrl}/transactions`);
  }

  /** Add a New Transaction & Update Total Expenses */
  addTransaction(transaction: transaction): Observable<any> {
    return this.http.post(`${this.apiUrl}/transactions`, {
      ...transaction,
      id: Date.now().toString() // Unique timestamp-based ID
    }).pipe(
      tap(() => this.updateTotalExpenses())
    );
  }

  /** Delete a Transaction & Update Total Expenses */
  deleteTransaction(id: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/transactions/${id}`).pipe(
      tap(() => this.updateTotalExpenses())
    );
  }

  /** Fetch Descriptions */
  getDescriptions(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/descriptions`);
  }

  /** Add a New Description */
  addDescription(description: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/descriptions`, { description });
  }

  /** Load Total Expenses from API */
  private loadTotalExpenses(): void {
    this.getTotalExpenses().subscribe();
  }

  /** Update Total Expenses by Summing All Expenses */
  private updateTotalExpenses(): void {
    this.getTransactions().subscribe((transactions) => {
      const totalExpense = transactions
        .filter(txn => txn.type === 'expense')
        .reduce((sum, txn) => sum + txn.amount, 0);
        console.log(totalExpense)

      // Update API
      this.http.patch(`${this.apiUrl}/total-expenses`, totalExpense).subscribe(() => {
        this.totalExpensesSubject.next(totalExpense);
      });
    });
  }
}
