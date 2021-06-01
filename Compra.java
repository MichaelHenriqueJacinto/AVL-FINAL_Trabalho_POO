package controle;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Compra {
    private int codigo;
    private Produto produto;
    private int qtd;
    private LocalDate data;
    private LocalDateTime dataEHora;
    private Double valorTotalCompra;

    public Compra(int codigo, Produto produto, int qtd, LocalDate data, LocalDateTime dataEHora) {
        this.codigo = codigo;
        this.produto = produto;
        this.qtd = qtd;
        this.data = data;
        this.dataEHora = dataEHora;
        this.setValorTotalCompra();
    }

    public int getCodigo() {
        return this.codigo;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public int getQtd() {
        return this.qtd;
    }

    public LocalDate getData() {
        return this.data;
    }

    public LocalDateTime getDataEHora() {
        return this.dataEHora;
    }

    public Double getValorTotalCompra() {
        return this.valorTotalCompra;
    }

    public void setValorTotalCompra() {
        this.valorTotalCompra = (double)this.getQtd() * this.getProduto().getPrecoCusto();
    }
}
