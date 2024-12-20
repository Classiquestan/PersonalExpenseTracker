

import java.util.Date;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Stanniss
 */
// Enumerate expenses into category. Categorize expenses in a type-safe manner. 
enum ExpenseCategory {
    GROCERY, TRANSPORT, SUBSCRIPTION, UTILITIES, ENTERTAINMENT, MISCELLANEOUS
}

//Expense class to track individual expenses
public class Expense {
    
    private String description;
    private double amount;
    private ExpenseCategory category;
    private Date date;

    public Expense(String description, double amount, ExpenseCategory category, Date date) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
    
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public Date getDate() {
        return date;
    }
    
    @Override
    public String toString() {
        return date + ": " + category + " - $" + amount + " (" + description + ")";
    }
    
}
