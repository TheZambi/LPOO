public class Pendular extends Comboio {
    public Pendular(String nome) {
        super(nome);
        this.setServicoABordo(new ServicoSemEnjoos());
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Pendular " + this.getNome() + ", " + getNumCarruagens();
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

}
