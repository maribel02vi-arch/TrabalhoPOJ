
public class Horista extends Funcionario {
    private double valorHora;
    private double[] horasPorDia;
    private boolean excessoDiario;

    public Horista(String nome, double valorHora, double[] horasPorDia) {
        super(nome);
        this.valorHora = valorHora;
        this.horasPorDia = horasPorDia;
    }

    public void verificarHorasExtrasDiarias() throws ExcessoHorasExtrasException {
        for (int i = 0; i < horasPorDia.length; i++) {
            double horasExtras = Math.max(0, horasPorDia[i] - 8);

            if (horasExtras > 2) {
                excessoDiario = true;
                throw new ExcessoHorasExtrasException(
                    "Mais de 2 horas extras no dia " + (i + 1));
            }
        }
    }

    public boolean temExcessoDiario() {
        return excessoDiario;
    }

    @Override
    public double calcularPagamento() {
        double horasSemana = 0;

        for (double horas : horasPorDia) {
            horasSemana += horas;
        }

        if (horasSemana <= 40) {
            return horasSemana * valorHora;
        }

        return 40 * valorHora
                + (horasSemana - 40) * valorHora * 1.5;
    }
}

