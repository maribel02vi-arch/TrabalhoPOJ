public class Comissionado extends Funcionario {
    private double vendas;
    private double taxaComissao;

    public Comissionado(String nome, double vendas, double taxaComissao) {
        super(nome);
        this.vendas = vendas;
        this.taxaComissao = taxaComissao;
    }

    @Override
    public double calcularPagamento() {
        return vendas * taxaComissao;
    }
}
