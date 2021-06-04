package controle;

import java.util.ArrayList;

public class Estoque {
    ArrayList<Produto> produtos = new ArrayList<>();
    ArrayList<Compra> compras = new ArrayList<>();
    ArrayList<Item> vendas = new ArrayList<>();

    public Estoque(ArrayList<Produto> produtos) {
        super();
        this.produtos = produtos;
    }

    public void consultarProdutos() {
        for (Produto p : produtos) {
            System.out.println("id: " + p.getCodigo() + " - " + p.getDescricao() + " - qtd: " + p.getQtd());
        }
    }

    public void adicionaAoEstoque(Compra compra) {
        if (compra.getQtd() > 0) {

            compras.add(compra);
            compra.getProduto().setQtd(compra.getQtd());
            System.out.println(compra.getCodigo() + " " + compra.getValorTotalCompra());
            System.out.println("Foi feita uma compra de: " + compra.getQtd() + " unidades do produto: "
                    + compra.getProduto().getDescricao() + " no valor de " + compra.getValorTotalCompra());

        } else {
            System.out.println("Valor Invalido");
        }
    }

    public void verificarEstoque(Item item) {
        if (item.getQtd() > produtos.get(item.getProduto().getCodigo()).getQtd() || item.getQtd() <= 0) {
            System.out.println("Quantidade de produtos indisponivel!!");
        }
    }

    public void venderItens(ArrayList<Item> itens) {
        for (Item i : itens) {
            for (Produto p : produtos) {
                if (i.getProduto().getCodigo() == p.getCodigo()) {
                    p.setQtd(-i.getQtd());
                    vendas.add(i);
                }
            }
        }
    }

    public void relatorioFinanceiro() {
        Double valorTotalVendas = 0.0;
        Double valorTotalCompras = 0.0;
        Double valorTotalBruto = 0.0;
        Double valorTotalLiquido = 0.0;
        Double valorTotalLiquidoVendas = 0.0;
        Double lucro = 0.0;
        System.out.println("-----------------------------------");
        if (vendas.size() > 0) {
            System.out.println("Vendas");
            for (Item v : vendas) {
                System.out.println(v.getProduto().getDescricao() + " quantidade: " + v.getQtd() + " valor: "
                        + v.getValorTotalItem());
                valorTotalVendas += v.getValorTotalItem();
                valorTotalLiquido += (v.getProduto().getPrecoCusto()) * v.getQtd();
            }
            lucro = valorTotalVendas - valorTotalLiquido;
            System.out.println("Total vendido: " + valorTotalVendas);
            System.out.println("Lucro: " + lucro);
        } else {
            System.out.println("não foi vendido nada");
        }

        System.out.println("-----------------------------------");
        if (compras.size() > 0) {
            System.out.println("Compras");
            for (Compra c : compras) {
                System.out.println(c.getProduto().getDescricao() + " quantidade: " + c.getQtd() + " custo: "
                        + c.getProduto().getPrecoCusto() * c.getQtd());
                valorTotalCompras = c.getProduto().getPrecoCusto() * c.getQtd();
            }
            System.out.println("Total comprado: " + valorTotalCompras);
        } else {
            System.out.println("Não foi comprado nada");
        }

        System.out.println("-----------------------------------");
        System.out.print("Valor total bruto em estoque: ");
        for (Produto p : produtos) {
            valorTotalBruto += p.getPrecoVenda() * p.getQtd();
        }
        System.out.println(valorTotalBruto);
        System.out.print("Valor total liquido em estoque: ");
        for (Produto p : produtos) {
            valorTotalLiquidoVendas += p.getPrecoCusto() * p.getQtd();
        }
        System.out.println(valorTotalBruto - valorTotalLiquidoVendas);
        System.out.println("-----------------------------------");
    }
}