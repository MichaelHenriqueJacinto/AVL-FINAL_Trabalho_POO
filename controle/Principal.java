package controle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

class Principal {
    public static ArrayList<Item> itens = new ArrayList<Item>();
    public static Item item;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int idProduto = 0;
        int idItem = 1;
        int idCompra = 0;
        int opc = 0;

        LocalDate data = LocalDate.now();
        LocalDateTime horario = LocalDateTime.now();

        ArrayList<Produto> produtos = new ArrayList<>();
        Produto produto = new Produto(idProduto++, "Coca Cola", 6.0, 8.5, 100);
        produtos.add(produto);
        produto = new Produto(idProduto++, "Coca Cola lata", 1.80, 3.5, 50);
        produtos.add(produto);
        produto = new Produto(idProduto++, "Skol 1L", 6.0, 7.5, 50);
        produtos.add(produto);
        produto = new Produto(idProduto++, "Brahma 1L", 5.90, 7.5, 50);
        produtos.add(produto);
        produto = new Produto(idProduto++, "Antartica", 6.2, 7.5, 60);
        produtos.add(produto);
        produto = new Produto(idProduto++, "Sub zero", 4.5, 7.0, 30);
        produtos.add(produto);
        produto = new Produto(idProduto++, "Refrigerante Mogi", 3.0, 5.0, 20);
        produtos.add(produto);
        produto = new Produto(idProduto++, "Salgadinho Cheetos", 1.60, 3.0, 50);
        produtos.add(produto);

        Estoque estoque = new Estoque(produtos);

        estoque.consultarProdutos();
        do {

            System.out.println("================================");
            System.out.println("1- Vender");
            System.out.println("2- Comprar");
            System.out.println("3- Consultar estoque");// por produto ou geral
            System.out.println("4- Imprimir relatorio");// vendas ou compras
            System.out.println("0- Sair");
            System.out.println("================================");
            System.out.print("Escolha uma opção: ");
            opc = Integer.parseInt(scanner.nextLine());

            switch (opc) {
                case 1:
                    int pararVenda = 0;
                    Double valorTotalVenda = 0.0;
                    do {

                        System.out.print("Digite o codigo do produto: ");
                        int codigoProduto = Integer.parseInt(scanner.nextLine());
                        Produto produtoVenda;
                        produtoVenda = produtos.get(codigoProduto);

                        System.out.print("Quantidade: ");
                        int quantidade = Integer.parseInt(scanner.nextLine());

                        item = new Item(idItem++, produtoVenda, quantidade, data, horario);
                        estoque.verificarEstoque(item);
                        valorTotalVenda += item.getValorTotalItem();
                        itens.add(item);
                        System.out.print("1 - para continuar comprando\n 0 - para parar: ");
                        pararVenda = Integer.parseInt(scanner.nextLine());
                    } while (pararVenda != 0);
                    estoque.venderItens(itens);
                    System.out.println("--------------------------------");
                    for (Item i : itens) {
                        System.out.println(i.getCodigo() + " - " + i.getProduto().getDescricao() + " Qtd " + i.getQtd()
                                + " : " + i.getValorTotalItem());
                    }
                    System.out.println("--------------------------------");
                    System.out.println("TOTAL: " + valorTotalVenda);
                    System.out.println("--------------------------------");

                    itens.clear();
                    idItem = 1;
                    break;

                case 2:
                    System.out.print("Digite o codigo do produto que deseja comprar: ");
                    int codigoProduto = Integer.parseInt(scanner.nextLine());
                    Produto produtoCompra;
                    produtoCompra = produtos.get(codigoProduto);
                    System.out.print("Quantidade: ");
                    int qtd = Integer.parseInt(scanner.nextLine());
                    Compra compra = new Compra(idCompra++, produtoCompra, qtd, data, horario);
                    estoque.adicionaAoEstoque(compra);
                    break;

                case 3:
                    estoque.consultarProdutos();
                    break;
                case 4:
                    estoque.relatorioFinanceiro();
                    break;
                default:
                    break;
            }

        } while (opc != 0);
    }
}