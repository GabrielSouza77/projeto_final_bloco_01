package generation.pchardware.model;

public class PlacaMae extends Produto {
    private String socket;   
    private String chipset;

    public PlacaMae(int id, String nome, String marca, int tipo, float preco, String socket, String chipset) {
        super(id, nome, marca, tipo, preco);
        this.socket = socket;
        this.chipset = chipset;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Socket: " + socket);
        System.out.println("Chipset: " + chipset);
    }
}
