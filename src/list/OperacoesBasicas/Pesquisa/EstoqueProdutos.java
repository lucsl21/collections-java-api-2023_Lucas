package list.OperacoesBasicas.Pesquisa;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    //atributos
    private Map<Long, Produto> estoqueProsutosMap;

    public EstoqueProdutos() {
        this.estoqueProsutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        estoqueProsutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos() {
        System.out.println(estoqueProsutosMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotalEstoque = 0d;
        if (!estoqueProsutosMap.isEmpty()) {
            for (Produto p : estoqueProsutosMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if (!estoqueProsutosMap.isEmpty()) {
            for (Produto p : estoqueProsutosMap.values()) {
                if (p.getPreco() > maiorPreco){
                    produtoMaisCaro = p;
                }
            }
        }
        return produtoMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.exibirProdutos();

        estoque.adicionarProduto(1l, "Produto A", 10, 5.0);
        estoque.adicionarProduto(2l, "Produto B", 5, 10.0);
        estoque.adicionarProduto(3l, "Produto C", 2, 15.0);
        estoque.adicionarProduto(8l, "Produto D", 2, 20);

        estoque.exibirProdutos();

        System.out.println("Valor total de estoque: R$" + estoque.calcularValorTotalEstoque());
        System.out.println("Produto mais caro: R$" + estoque.obterProdutoMaisCaro());
    }
}
