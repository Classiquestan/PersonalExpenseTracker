
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Stanniss
 */
public class PersonalExpenseTracker {
    public static void main(String[] args) {
        // Setting up the budget
        Budget budget = new Budget(500, 200,150,100,80,90); // Example budget for each category (Food, Transport, Entertainment, Other)
        ExpenseTracker tracker = new ExpenseTracker(2000, budget); // Total monthly income: $2000

        // Adding expenses
        tracker.addExpense(new Expense("WamartStore", 310, ExpenseCategory.GROCERY, new Date()));
        tracker.addExpense(new Expense("Bus fare", 65, ExpenseCategory.TRANSPORT, new Date()));
        tracker.addExpense(new Expense("Hydro", 100, ExpenseCategory.UTILITIES, new Date()));
        tracker.addExpense(new Expense("Movie ticket", 25, ExpenseCategory.ENTERTAINMENT, new Date()));
        tracker.addExpense(new Expense("Fido", 35, ExpenseCategory.SUBSCRIPTION, new Date()));
        tracker.addExpense(new Expense("Transfer", 100, ExpenseCategory.MISCELLANEOUS, new Date()));

        // Display all expenses
        tracker.displayAllExpenses();

        // Generate monthly report
        tracker.generateReport("monthly");

        // Generate weekly report
        tracker.generateReport("weekly");

        // Calculate and display savings
        System.out.println("Total savings: $" + tracker.calculateSavings());
    }
    
}
