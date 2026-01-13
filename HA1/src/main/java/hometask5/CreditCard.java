package hometask5;

public class CreditCard {
    private final String accountNumber;
    private double balance;

    public CreditCard(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public CreditCard(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double addToBalance(double sum){
        balance = balance + sum;
        return sum;
    }
    public double withdrawFromBalance(double sum){
        balance = balance - sum;
        return sum;
    }
    public void cardInformation(){
        System.out.println(getAccountNumber());
        System.out.println(getBalance());
    }
}
