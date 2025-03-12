import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../../services/transaction.service';
import { transaction } from '../../model/transaction';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  transactions: transaction[] = [];
  filteredTransactions: transaction[] = [];
  startDate: Date | null = null;
  endDate: Date | null = null;

  totalIncome: number = 0;
  totalExpense: number = 0;
  balance: number = 0;

  displayedColumns: string[] = ['date', 'description', 'amount', 'type'];

  constructor(private transactionService: TransactionService) {}

  ngOnInit(): void {
    this.fetchTransactions();
  }

  fetchTransactions(): void {
    this.transactionService.getTransactions().subscribe((data: transaction[]) => {
      this.transactions = data;
      this.filteredTransactions = [...this.transactions];
      this.calculateTotals();
    });
  }

  filterTransactions(): void {
    if (!this.startDate || !this.endDate) {
      this.filteredTransactions = [...this.transactions];
    } else {
      this.filteredTransactions = this.transactions.filter(txn => {
        const txnDate = new Date(txn.date);
        return txnDate >= this.startDate! && txnDate <= this.endDate!;
      });
    }
    this.calculateTotals();
  }

  calculateTotals(): void {
    this.totalIncome = this.filteredTransactions
      .filter(txn => txn.type === 'income')
      .reduce((sum, txn) => sum + txn.amount, 0);

    this.totalExpense = this.filteredTransactions
      .filter(txn => txn.type === 'expense')
      .reduce((sum, txn) => sum + txn.amount, 0);

    this.balance = this.totalIncome - this.totalExpense;
  }
}
