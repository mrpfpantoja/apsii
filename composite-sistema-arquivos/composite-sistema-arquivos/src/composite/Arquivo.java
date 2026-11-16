package composite;

/** Leaf: elemento simples, não possui filhos. */
public class Arquivo implements ComponenteSistema {
    private final String nome;
    private final long tamanhoKb;

    public Arquivo(String nome, long tamanhoKb) {
        this.nome = nome;
        this.tamanhoKb = tamanhoKb;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public long getTamanho() {
        return tamanhoKb;
    }

    @Override
    public void exibir(String indentacao) {
        System.out.println(indentacao + "📄 " + nome + " (" + tamanhoKb + " KB)");
    }
}
