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
        super();
        this.codigo = codigo;
        this.produto = produto;
        this.qtd = qtd;
        this.data = data;
        this.dataEHora = dataEHora;
        setValorTotalCompra();
    }

    public int getCodigo() {
        return codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQtd() {
        return qtd;
    }

    public LocalDate getData() {
        return data;
    }


    public LocalDateTime getDataEHora() {
        return dataEHora;
    }

    public Double getValorTotalCompra() {
        return valorTotalCompra;
    }

    public void setValorTotalCompra() {
        this.valorTotalCompra = this.getQtd() * this.getProduto().getPrecoCusto();
    }


}