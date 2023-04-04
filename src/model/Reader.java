package model;

public class Reader extends Person {
    private int budget = 0;
    private boolean loyalCustomer = false;

    public Reader() {

    }
    public Reader(String firstName, String lastName, int age, int phone, int budget, boolean loyalCustomer) {
        super(firstName, lastName, age, phone);
        this.budget = budget;
        this.loyalCustomer = loyalCustomer;
    }

    void budgetChange(int sum) {
        this.budget += sum;
    }
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public boolean isLoyalCustomer() {
        return loyalCustomer;
    }

    public void setLoyalCustomer(boolean loyalCustomer) {
        this.loyalCustomer = loyalCustomer;
    }

    public String toString() {
        return super.toString() + "\nBudget = " + this.budget + "\nLoyal Customer = " + this.loyalCustomer;
    }
}
