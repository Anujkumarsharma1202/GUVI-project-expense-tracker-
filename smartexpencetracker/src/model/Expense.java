package model;

public class Expense {
    private int userId;
    private String category;
    private double amount;
    private String date;

    public Expense(int userId, String category, double amount, String date) {
        this.userId = userId;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public int getUserId() { return userId; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
}
