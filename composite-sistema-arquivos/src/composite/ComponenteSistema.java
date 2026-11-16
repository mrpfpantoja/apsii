package composite;

/**
 * Component: interface comum para Arquivo (folha) e Pasta (composto).
 * O cliente trata os dois da mesma forma (polimorfismo).
 */
public interface ComponenteSistema {
    String getNome();

    /** Tamanho em KB. Para uma pasta, é a soma de tudo que ela contém. */
    long getTamanho();

    /** Exibe o componente com indentação (usado para montar a árvore). */
    void exibir(String indentacao);
}
