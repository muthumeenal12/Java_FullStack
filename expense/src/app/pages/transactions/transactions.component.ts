import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TransactionService } from '../../services/transaction.service';
import { transaction } from '../../model/transaction';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
  @ViewChild('transactionForm') transactionForm!: NgForm;

  newTransaction: transaction = {
    id: '',
    date: new Date(),
    description: '',
    amount: 0,
    type: 'expense',
    category: '',
  };

  showForm = false;
  descriptions: string[] = [];
  showCustomDescriptionInput = false;

  constructor(private transactionService: TransactionService) {}

  ngOnInit() {
    this.loadDescriptions();
  }

  toggleForm() {
    this.showForm = !this.showForm;
  }

  // ✅ Fetch descriptions from API
  loadDescriptions() {
    this.transactionService.getDescriptions().subscribe({
      next: (data: any[]) => {
        if (Array.isArray(data)) {
          this.descriptions = data.map(item =>
            typeof item === 'string' ? item : item.description
          );
        } else {
          console.error('Invalid descriptions format from API:', data);
        }
      },
      error: err => console.error('Error fetching descriptions:', err),
    });
  }

  // ✅ Add Transaction
  addTransaction() {
    if (this.newTransaction.amount <= 0) {
      alert('Amount must be a positive number.');
      return;
    }

    if (!this.newTransaction.description) {
      alert('Please select a description.');
      return;
    }

    // ✅ If "Other" is selected and input is filled, add it to descriptions
    if (this.showCustomDescriptionInput && this.newTransaction.description.trim() !== '') {
      this.addNewDescription(this.newTransaction.description);
    }

    // ✅ Save transaction
    this.transactionService.addTransaction(this.newTransaction).subscribe({
      next: () => {
        alert('Transaction added successfully!');
        this.resetForm();
      },
      error: error => console.error('Error adding transaction:', error),
    });
  }

  // ✅ Handle description selection change
  handleDescriptionChange(event: Event) {
    const selectedValue = (event.target as HTMLSelectElement).value;
    this.showCustomDescriptionInput = selectedValue === 'Other';
    this.newTransaction.description = this.showCustomDescriptionInput ? '' : selectedValue;
  }

  // ✅ Add new description to the list & API
  addNewDescription(newDesc: string) {
    if (newDesc.trim() !== '' && !this.descriptions.includes(newDesc)) {
      this.descriptions.push(newDesc);

      this.transactionService.addDescription(newDesc).subscribe({
        next: () => console.log('Description added successfully!'),
        error: err => console.error('Error updating descriptions:', err),
      });
    }
  }

  // ✅ Reset form without breaking ViewChild reference
  resetForm() {
    Object.assign(this.newTransaction, {
      id: '',
      date: new Date(),
      description: '',
      amount: 0,
      type: 'expense',
      category: '',
    });
    this.showCustomDescriptionInput = false;

    if (this.transactionForm) {
      this.transactionForm.resetForm();
    }
  }
}
