public class Aluguel {
    private Fita fita;
    private int diasAlugada;

    public Aluguel(Fita fita, int diasAlugada) {
        this.fita = fita;
        this.diasAlugada = diasAlugada;
    }

    public Fita getFita() {
        return fita;
    }

    public int getDiasAlugada() {
        return diasAlugada;
    }

    // Refatoração 1: Move Method - Cálculo do valor transferido de Cliente para Aluguel
    public double getValorDoAluguel() {
        double valorCorrente = 0;
        switch (fita.getCodigoDePreco()) {
            case Fita.NORMAL:
                valorCorrente += 2;
                if (diasAlugada > 2) {
                    valorCorrente += (diasAlugada - 2) * 1.5;
                }
                break;
            case Fita.LANCAMENTO:
                valorCorrente += diasAlugada * 3;
                break;
            case Fita.INFANTIL:
                valorCorrente += 1.5;
                if (diasAlugada > 3) {
                    valorCorrente += (diasAlugada - 3) * 1.5;
                }
                break;
        }
        return valorCorrente;
    }

    // Refatoração 2: Move Method - Cálculo de pontos transferido para Aluguel
    public int getPontosDeAlugadorFrequente() {
        if (fita.getCodigoDePreco() == Fita.LANCAMENTO && diasAlugada > 1) {
            return 2;
        }
        return 1;
    }
}