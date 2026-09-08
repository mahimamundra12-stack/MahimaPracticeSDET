package OopConcept;

class BankAccount {

    private String accountHolder;
    private double balance;

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void deposit(double amount) {

        if (amount > 0) {
            balance = balance + amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class EncapsulationPrac {

      public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.setAccountHolder("Mahima");

        account.deposit(5000);

        System.out.println(account.getBalance());
    }
    
}
