public class Account {
    double balance;
    String name;
    public Account(String name, double v) {
        this.name = name;
        this.balance = v;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }


}
