public class Deposit implements Transaction{
    ATM atm;
    Session session;
    Card card;
    double amount;

    public Deposit(ATM atm, Session session, Card card, int amount) {
        this.atm = atm;
        this.session = session;
        this.card = card;
        this.amount = amount;
    }
}
