package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite: guarda outros componentes (arquivos ou outras pastas)
 * e delega as operações para eles.
 */
public class Pasta implements ComponenteSistema {
    private final String nome;
    private final Pasta pai;
    private final List<ComponenteSistema> filhos = new ArrayList<>();

    public Pasta(String nome, Pasta pai) {
        this.nome = nome;
        this.pai = pai;
    }

    public Pasta(String nome) {
        this(nome, null);
    }

    public Pasta getPai() {
        return pai;
    }

    public List<ComponenteSistema> getFilhos() {
        return filhos;
    }

    public void adicionar(ComponenteSistema componente) {
        if (buscar(componente.getNome()) != null) {
            throw new IllegalArgumentException("Já existe '" + componente.getNome() + "' nesta pasta.");
        }
        filhos.add(componente);
    }

    public boolean remover(String nomeComponente) {
        return filhos.removeIf(c -> c.getNome().equals(nomeComponente));
    }

    public ComponenteSistema buscar(String nomeComponente) {
        for (ComponenteSistema c : filhos) {
            if (c.getNome().equals(nomeComponente)) {
                return c;
            }
        }
        return null;
    }

    /** Recursão: soma o tamanho de cada filho, seja arquivo ou outra pasta. */
    @Override
    public long getTamanho() {
        long total = 0;
        for (ComponenteSistema c : filhos) {
            total += c.getTamanho();
        }
        return total;
    }

    @Override
    public void exibir(String indentacao) {
        System.out.println(indentacao + "📁 " + nome + "/ (" + getTamanho() + " KB)");
        for (ComponenteSistema c : filhos) {
            c.exibir(indentacao + "   ");
        }
    }

    @Override
    public String getNome() {
        return nome;
    }
}
