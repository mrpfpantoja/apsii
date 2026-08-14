package exercicio1;

import java.util.ArrayList;

public class MinhaAgendaDeAniversarios implements AgendaDeAniversarios {
    private ArrayList<Aniversariante> aniversariantes;

    public MinhaAgendaDeAniversarios() {
        this.aniversariantes = new ArrayList<>();
    }

    @Override
    public void adicionarAniversariante(String nome, int dia, int mes) {
        this.aniversariantes.add(new Aniversariante(nome, dia, mes));
    }

    @Override
    public ArrayList<String> obterAniversariantesDoDia(int dia, int mes) {
        ArrayList<String> nomes = new ArrayList<>();
        for (Aniversariante a : this.aniversariantes) {
            DataAniversario data = a.getDataAniversario();
            if (data != null && data.getDia() == dia && data.getMes() == mes) {
                nomes.add(a.getNome());
            }
        }
        return nomes;
    }

    @Override
    public void removerAniversariante(String nome) {
        this.aniversariantes.removeIf(a -> a.getNome().equalsIgnoreCase(nome));
    }

    public ArrayList<Aniversariante> getAniversariantes() {
        return aniversariantes;
    }
}
