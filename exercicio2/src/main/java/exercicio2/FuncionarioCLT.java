package exercicio2;

public class FuncionarioCLT extends Funcionario {
    private double valeTransporte;
    private double valeAlimentacao;

    public FuncionarioCLT(String nome, String matricula, double salarioBase, String dataAdmissao,
                          double valeTransporte, double valeAlimentacao) {
        super(nome, matricula, salarioBase, dataAdmissao);
        this.valeTransporte = valeTransporte;
        this.valeAlimentacao = valeAlimentacao;
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    public double getValeAlimentacao() {
        return valeAlimentacao;
    }

    @Override
    public double calcularSalario() {
        // Reaproveita o salarioBase da superclasse e soma os benefícios
        return super.calcularSalario() + this.valeTransporte + this.valeAlimentacao;
    }

    @Override
    public double calcularDesconto() {
        // Reaproveita o desconto padrão de Funcionario e acrescenta R$ 50,00
        return super.calcularDesconto() + 50.0;
    }
}