import java.util.Objects;

public class Ponto implements Comparable{
    int x;
    int y;
    public Ponto(int i, int i1) {
        this.x = i;
        this.y = i1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+this.x+", "+this.y+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return x == ponto.x &&
                y == ponto.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Object o) {
        int x = ((Ponto)o).getX();
        int y = ((Ponto)o).getY();
        if(this.x!=x)
            return (this.x>x ? 1 : 0);
        return (this.y>y ? 1 : 0);
    }
}
