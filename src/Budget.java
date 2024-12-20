/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Stanniss
 */
// Budget class to track the user's budget per category
public class Budget {
    
    private double grocery;
    private double transport;
    private double subscription;
    private double utility;
    private double entertainment;
    private double miscellaneous;
    
    
    public Budget(double grocery, double transport,double subscription, double utility, double entertainment, double miscellaneous) {
        this.grocery = grocery;
        this.transport = transport;
        this.subscription = subscription;
        this.utility = utility;
        this.entertainment = entertainment;
        this.miscellaneous = miscellaneous;
    }
    
    public double getCategoryBudget(ExpenseCategory category) {
        switch(category) {
            case GROCERY:
                return grocery;
            case TRANSPORT:
                return transport;
            case SUBSCRIPTION:
                return subscription;
            case UTILITIES:
                return utility;
            case ENTERTAINMENT:
                return entertainment;
            case MISCELLANEOUS:
                return miscellaneous;
            default:
                return 0;
                        
        }
        
        
    }

    
}
