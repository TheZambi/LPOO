public class Withdrawal implements Transaction{
    ATM atm;
    Session session;
    Card card;
    double amount;

    public Withdrawal(ATM atm, Session session, Card card, int amount) {
        this.atm = atm;
        this.session = session;
        this.card = card;
        this.amount = amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Withdrawal at ATM " +
                this.atm.getID() +
                " (" + atm.getCity() + ", " + this.atm.getBanco()+ ") of " +
                String.format("%.2f",this.amount).replace(",",".");
    }
}
