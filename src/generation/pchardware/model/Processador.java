package generation.pchardware.model;

public class Processador extends Produto {

    private int nucleos;
    private double clock;

    public Processador(int id, String nome, String marca, int tipo, float preco, int nucleos, double clock) {
        super(id, nome, marca, tipo, preco);
        this.nucleos = nucleos;
        this.clock = clock;
    }

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(int nucleos) {
        this.nucleos = nucleos;
    }

    public double getClock() {
        return clock;
    }

    public void setClock(double clock) {
        this.clock = clock;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Núcleos: " + this.nucleos);
        System.out.println("Clock: " + this.clock + " GHz");
    }
}