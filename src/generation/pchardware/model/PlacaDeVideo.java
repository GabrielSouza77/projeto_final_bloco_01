package generation.pchardware.model;

public class PlacaDeVideo extends Produto {
	
    private int memoriaVRAM;
    private String chipGrafico;

    public PlacaDeVideo(int id, String nome, String marca, int tipo, float preco, int memoriaVRAM, String chipGrafico) {
        super(id, nome, marca, tipo, preco);
        this.memoriaVRAM = memoriaVRAM;
        this.chipGrafico = chipGrafico;
    }

    public int getMemoriaVRAM() {
        return memoriaVRAM;
    }

    public void setMemoriaVRAM(int memoriaVRAM) {
        this.memoriaVRAM = memoriaVRAM;
    }

    public String getChipGrafico() {
        return chipGrafico;
    }

    public void setChipGrafico(String chipGrafico) {
        this.chipGrafico = chipGrafico;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Chipset gráfico: " + chipGrafico);
        System.out.println("Memória VRAM: " + memoriaVRAM + " GB");
    }
}
