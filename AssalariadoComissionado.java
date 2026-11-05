public class AssalariadoComissionado extends Comissionado {
    private double salarioBase;

    public AssalariadoComissionado(String nome, double vendas,
                                  double taxaComissao, double salarioBase) {
        super(nome, vendas, taxaComissao);
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularPagamento() {
        return (salarioBase * 1.10) + super.calcularPagamento();
    }
}
