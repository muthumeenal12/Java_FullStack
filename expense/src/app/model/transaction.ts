export interface transaction
{
    id: string;
    date: Date;
    amount: number;
    description: string;
    type: 'income' | 'expense';
    category: string; 
}