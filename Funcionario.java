
public abstract class Funcionario implements Payable {

    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract double calcularPagamento();

    @Override
    public double getPaymentAmount() {
        return calcularPagamento();
    }
}
