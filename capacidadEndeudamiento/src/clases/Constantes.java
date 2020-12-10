package clases;

public class Constantes {
    final String  menIngresosTotales;
    final String  menGastosFijos;
    final String  menGastosVariables;
    final String  menContinuar;

    public Constantes() {
        this.menIngresosTotales = "Ingrese sus ingresos mensuales";
        this.menGastosFijos = "Ingrese sus gastos fijos";
        this.menGastosVariables = "Ingrese sus gastos variable";
        this.menContinuar = " o ingrese la palbra 'Si' para continuar";
    }

    public String getMenIngresosTotales() {
        return menIngresosTotales;
    }

    public String getMenGastosFijos() {
        return menGastosFijos;
    }

    public String getMenGastosVariables() {
        return menGastosVariables;
    }

    public String getMenContinuar() {
        return menContinuar;
    }
}
