import java.util.Objects;

public class ATM {
    int id;
    String city;
    String banco;
    public ATM(int id, String city, String banco) {
        this.id = id;
        this.city = city;
        this.banco = banco;
    }

    public int getID() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getBanco() {
        return banco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return id == atm.id &&
                Objects.equals(city, atm.city) &&
                Objects.equals(banco, atm.banco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, banco);
    }
}
