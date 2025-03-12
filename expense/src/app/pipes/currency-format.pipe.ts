import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'currencyFormat'
})
export class CurrencyFormatPipe implements PipeTransform {
  transform(value: number): string {
    return value < 0 ? `- ₹${Math.abs(value)}` : `₹${value}`;
  }
}
