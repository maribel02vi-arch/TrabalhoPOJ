
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Payable> pagamentos = new ArrayList<>();

        pagamentos.add(new Assalariado("Luiz", 1500));
        pagamentos.add(new Horista("Ignacio", 40,
                new double[]{8, 8, 8, 8, 13}));
        pagamentos.add(new Comissionado("Andre", 10000, 0.08));
        pagamentos.add(new AssalariadoComissionado(
                "Erika", 3600, 0.10, 600));

        pagamentos.add(new Invoice("Caderno", 5, 20));

        double totalFuncionarios = 0;

        for (Payable pagamento : pagamentos) {

            if (pagamento instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) pagamento;

                if (funcionario instanceof Horista) {
                    Horista horista = (Horista) funcionario;

                    try {
                        horista.verificarHorasExtrasDiarias();
                    } catch (ExcessoHorasExtrasException e) {
                        System.out.println("ALERTA: " + e.getMessage());
                    }
                }

                System.out.printf("%s: R$ %.2f%n",
                        funcionario.getNome(),
                        funcionario.getPaymentAmount());

                if (funcionario instanceof Horista) {
                    Horista horista = (Horista) funcionario;

                    if (horista.temExcessoDiario()) {
                        System.out.println(
                                "ATENCAO: Excesso de horas extras!");
                    }
                }

                totalFuncionarios += funcionario.getPaymentAmount();

            } else if (pagamento instanceof Invoice) {
                Invoice nota = (Invoice) pagamento;

                System.out.printf("Nota %s: R$ %.2f%n",
                        nota.getDescricao(),
                        nota.getPaymentAmount());
            }
        }

        System.out.printf("Total da folha: R$ %.2f%n",
                totalFuncionarios);
    }
}
