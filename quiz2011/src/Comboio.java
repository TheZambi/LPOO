import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class Comboio {
    private String nome;
    private List<Carruagem> carruagems = new ArrayList<>();
    private int numPassegeiros = 0;
    private ServicoABordo serviço;

    public Comboio(String nome) {
        this.nome = nome;
        serviço = new ServicoRegular();
    }

    public String getNome() {
        return nome;
    }

    public void setServicoABordo(ServicoABordo serviço) {
        this.serviço = serviço;
    }

    public int getNumLugares() {
        int total=0;
        for(Carruagem car : carruagems){
            total += car.getNumLugares();
        }
        return total;
    }

    public int getNumCarruagens() {
        return carruagems.size();
    }

    public void addCarruagem(Carruagem a1) {
        this.carruagems.add(a1);
    }

    public Carruagem getCarruagemByOrder(int i) {
        int pos=0;
        for(Carruagem car : carruagems)
        {
            if(pos == i)
                return car;
            pos++;
        }
        return null;
    }

    public void removeAllCarruagens(int i) {
        carruagems.removeIf(car -> car.getNumLugares() == i);
    }

    public int getNumPassageiros() {
        return numPassegeiros;
    }

    public int getLugaresLivres() {
        return this.getNumLugares() - numPassegeiros;
    }

    public void addPassageiros(int i) throws PassengerCapacityExceeded {
        if(i > getLugaresLivres())
            throw new PassengerCapacityExceeded();
        this.numPassegeiros += i;
    }

    public void removePassageiros(int i) throws PassengerCapacityExceeded {
        if(numPassegeiros-i<0)
            throw new PassengerCapacityExceeded();
        this.numPassegeiros -= i;
    }

    public void removePassageiros(){
        this.numPassegeiros = 0;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Comboio " + this.getNome() + ", " + getNumCarruagens();
        if(getNumCarruagens() == 1)
            ret += " carruagem, " + this.getNumLugares();
        else
            ret += " carruagens, " + this.getNumLugares();

        if(this.getNumLugares() == 1)
            ret += " lugar, " + this.getNumPassageiros();
        else
            ret += " lugares, " + this.getNumPassageiros();

        if(this.getNumPassageiros() == 1)
            ret += " passageiro";
        else
            ret += " passageiros";

        return ret;
    }

    @Override
    public boolean equals(Object o) {
        List<Carruagem> aux1 = new ArrayList<>(this.carruagems);
        List<Carruagem> aux2 = new ArrayList<>(((Comboio) o).carruagems);
        if(this.carruagems.size() != ((Comboio)o).carruagems.size())
            return false;
        for(int i = 0 ; i<this.carruagems.size();i++){
            if(aux1.get(i).getNumLugares()!=aux2.get(i).getNumLugares())
                return false;
        }
        return true;
    }

    public String getDescricaoServico() {
        return this.serviço.getTipo();
    }

    public ServicoABordo getServicoABordo() {
        return this.serviço;
    }
}
