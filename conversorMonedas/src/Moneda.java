public class Moneda {
    private String tipoMoneda;
    private Double tipoCambio;

    public Moneda() {
    }

    public Moneda(String tipoMoneda , Double tipoCambio) {
        this.tipoCambio = tipoCambio;
        this.tipoMoneda = tipoMoneda;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
}
