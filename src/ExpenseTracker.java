

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Stanniss
 */
enum ExpenseCategory {
    GROCERY, TRANSPORT, SUBSCRIPTION, UTILITIES, ENTERTAINMENT, MISCELLANEOUS
}
//Expense tracker to track expenses and calculate savings
public class ExpenseTracker {
    private List<Expense> expenses = new ArrayList<>();
    private double totalIncome;
    private Budget budget;
    
    public ExpenseTracker(double totalIncome, Budget budget) {
        this.totalIncome = totalIncome;
        this.budget = budget;
    }
   
    //method to add expense
   public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    // Method to calculate total expenses by category
    public double calculateTotalExpensesByCategory(ExpenseCategory category) {
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getCategory() == category) {
                total += expense.getAmount();
            }
        }
        return total;
    }

    // Method to calculate savings
    public double calculateSavings() {
        double totalExpenses = 0;
        for (ExpenseCategory category : ExpenseCategory.values()) {
            totalExpenses += calculateTotalExpensesByCategory(category);
        }
        return totalIncome - totalExpenses;
    }

    // Method to generate a monthly report (Polymorphism)
    public void generateReport(String format) {
        switch (format.toLowerCase()) {
            case "monthly":
                generateMonthlyReport();
                break;
            case "weekly":
                generateWeeklyReport();
                break;
            default:
                System.out.println("Invalid report format!");
        }
    }

    // Monthly report
    private void generateMonthlyReport() {
        System.out.println("Generating Monthly Report...");
        for (ExpenseCategory category : ExpenseCategory.values()) {
            double total = calculateTotalExpensesByCategory(category);
            System.out.println("Total " + category + " expenses: $" + total);
            double budgetLimit = budget.getCategoryBudget(category);
            System.out.println("Budget for " + category + ": $" + budgetLimit);
            System.out.println("Remaining budget for " + category + ": $" + (budgetLimit - total));
        }
        System.out.println("Total Savings: $" + calculateSavings());
    }

    // Weekly report
    private void generateWeeklyReport() {
        System.out.println("Generating Weekly Report...");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_YEAR, -1); // Set date to one week ago
        Date oneWeekAgo = cal.getTime();

        for (ExpenseCategory category : ExpenseCategory.values()) {
            double total = 0;
            for (Expense expense : expenses) {
                if (expense.getCategory() == category && expense.getDate().after(oneWeekAgo)) {
                    total += expense.getAmount();
                }
            }
            System.out.println("Total " + category + " expenses in the last week: $" + total);
        }
        System.out.println("Total Savings in the last week: $" + calculateSavings());
    }

    // Method to display all expenses
    public void displayAllExpenses() {
        System.out.println("Expenses List:");
        for (Expense expense : expenses) {
            System.out.println("Expense: " + expense.getCategory() + " - $" + expense.getAmount() + " on " + expense.getDate());
        }
    }
    
    
    
  
    
}
