public class CD extends Produto implements InfoGerais {
    private int numFaixas;

    public CD() {
        super();
    }

    public CD(String nome, double preco, int numFaixas) {
        super(nome, preco);
        this.numFaixas = numFaixas;
    }

    public int getNumFaixas() {
        return numFaixas;
    }

    public void setNumFaixas(int numFaixas) {
        this.numFaixas = numFaixas;
    }

    @Override
    public void exibeInformacoes() {
        System.out.println("=== Informações do CD ===");
        System.out.println("Nome: " + getNome());
        System.out.printf("Preço: R$ %.2f\n", getPreco());
        System.out.println("Número de Faixas: " + numFaixas);
    }
}