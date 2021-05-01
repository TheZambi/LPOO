import java.util.ArrayList;
import java.util.List;

public class City implements SumProvider{
    List<House> houses = new ArrayList<>();

    City(List<House> houses){
        this.houses = houses;
    }

    public double sum(){
        double soma = 0;
        for(House house:houses){
            soma += house.getArea();
        }
        return soma;
    }
}
