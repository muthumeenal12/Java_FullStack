import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'dateFormat'
})
export class DateFormatPipe implements PipeTransform {
  transform(value: string | Date): string {
    const date = new Date(value); // Ensures string is converted to Date
    if (isNaN(date.getTime())) return 'Invalid Date'; // Handle invalid dates
    return date.toLocaleDateString('en-IN', { year: 'numeric', month: 'long', day: 'numeric' });
  }
}
