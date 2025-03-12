import { Pipe, PipeTransform } from '@angular/core';
import { transaction } from '../model/transaction';

@Pipe({
  name: 'transactionFilter'
})
export class TransactionFilterPipe implements PipeTransform {

  transform(transactions: transaction[], searchTerm: string): transaction[] {
    if (!transactions || !searchTerm) {
      return transactions; // Return all if no search term
    }
    return transactions.filter(txn =>
      txn.description.toLowerCase().includes(searchTerm.toLowerCase())
    );
  }

}
