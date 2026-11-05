
public class Invoice implements Payable {

    private String descricao;
    private int quantidade;
    private double precoUnitario;

    public Invoice(String descricao, int quantidade, double precoUnitario) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public double getPaymentAmount() {
        return quantidade * precoUnitario;
    }
}
