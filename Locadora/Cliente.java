import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private List<Aluguel> alugueis = new ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionaAluguel(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public String extrato() {
        final String fimDeLinha = System.getProperty("line.separator");
        StringBuilder resultado = new StringBuilder("Registro de Alugueis de " + getNome() + fimDeLinha);

        for (Aluguel cada : alugueis) {
            resultado.append("\t")
                     .append(cada.getFita().getTitulo())
                     .append("\t")
                     .append(cada.getValorDoAluguel())
                     .append(fimDeLinha);
        }

        // Consultas diretas aos métodos especialistas (Replace Temp with Query)
        resultado.append("Valor total devido: ").append(getValorTotal()).append(fimDeLinha);
        resultado.append("Voce acumulou ").append(getPontosTotaisDeAlugadorFrequente())
                 .append(" pontos de alugador frequente");
        return resultado.toString();
    }

    // Replace Temp with Query: método que calcula o valor total
    public double getValorTotal() {
        double total = 0;
        for (Aluguel cada : alugueis) {
            total += cada.getValorDoAluguel();
        }
        return total;
    }

    // Replace Temp with Query: método que totaliza os pontos
    public int getPontosTotaisDeAlugadorFrequente() {
        int pontos = 0;
        for (Aluguel cada : alugueis) {
            pontos += cada.getPontosDeAlugadorFrequente();
        }
        return pontos;
    }
}