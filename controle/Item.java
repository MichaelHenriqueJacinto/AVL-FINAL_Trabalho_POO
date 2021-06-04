package controle;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Item {
    private int codigo;
    private Produto produto;
    private int qtd;
    private double valorTotalItem;
    LocalDate data = LocalDate.now();
    LocalDateTime dataEHora = LocalDateTime.now();

    public Item(int codigo, Produto produto, int qtd, LocalDate data, LocalDateTime dataEHora) {
        super();
        this.codigo = codigo;
        this.produto = produto;
        this.qtd = qtd;
        this.data = data;
        this.dataEHora = dataEHora;
        setValorTotalItem();
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

    public Double getValorTotalItem() {
        return valorTotalItem;
    }

    public void setValorTotalItem() {
        this.valorTotalItem = getQtd() * getProduto().getPrecoVenda();
    }
}
