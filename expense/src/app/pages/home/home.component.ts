import { Component, OnInit } from '@angular/core';
import { TransactionService } from '../../services/transaction.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'] // Fixed typo: `styleUrls` instead of `styleUrl`
})
export class HomeComponent implements OnInit {
  totalExpenses = 100;

  constructor(private transactionService: TransactionService) {}

  ngOnInit() {
    this.transactionService.getTotalExpenses().subscribe({
      next: (total) => {
        this.totalExpenses = total;
        console.log('Updated total expenses:', this.totalExpenses); // Moved inside subscribe
      },
      error: (err) => console.error('Error fetching total expenses:', err)
    });
  }
}
