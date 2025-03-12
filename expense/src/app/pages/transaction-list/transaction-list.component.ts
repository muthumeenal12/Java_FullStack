import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../../services/transaction.service';
import { transaction } from '../../model/transaction';

@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {
  transactions: transaction[] = [];
  totalIncome: number = 0;
  totalExpense: number = 0;
  balance: number = 0;
  searchTerm: string = '';
  displayedColumns: string[] = ['date', 'description', 'amount', 'type', 'action'];
  constructor(private transactionService: TransactionService) {}

  ngOnInit(): void {
    this.fetchTransactions();
  }

  fetchTransactions(): void {
    this.transactionService.getTransactions().subscribe((data: transaction[]) => {
      this.transactions = data;
      this.calculateTotals();
    });
  }

  calculateTotals(): void {
    this.totalIncome = this.transactions
      .filter(txn => txn.type === 'income')
      .reduce((sum, txn) => sum + txn.amount, 0);

    this.totalExpense = this.transactions
      .filter(txn => txn.type === 'expense')
      .reduce((sum, txn) => sum + txn.amount, 0);

    this.balance = this.totalIncome - this.totalExpense;
  }

  deleteTransaction(id: string): void {
    this.transactions = this.transactions.filter(txn => txn.id !== id);
    this.calculateTotals();
  }
}
