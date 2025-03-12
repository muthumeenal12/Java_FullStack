import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'transactionType'
})
export class TransactionTypePipe implements PipeTransform {
  transform(value: string): string {
    return value === 'income' ? '🔵 Income' : '🔴 Expense';
  }
}
