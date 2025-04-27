import br.projeto.shopping.modelos.Cartao;
import br.projeto.shopping.modelos.Produtos;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("*** SEJA BEM VINDO AO MENU DE COMPRAS ***\n");

        System.out.println("Digite o limite do seu cartão: ");
        double limite = leitura.nextDouble();
        Cartao cartao = new Cartao(limite);

        int sair = 1;

        while(sair != 0){
            System.out.println("Digite o produto que deseja comprar: ");
            String produto = leitura.next();

            System.out.println("Digite o valor do produto que deseja comprar: ");
            double valor = leitura.nextDouble();

            Produtos compra = new Produtos(produto, valor);
            boolean compraFeita = cartao.adicionaCompra(compra);

            if (compraFeita == true){
                System.out.println("Compra realizada com sucesso\n");
                System.out.println("Se deseja continuar a comprar, digite qualquer número diferente de 0: ");
                sair = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        cartao.getCompras().sort(Comparator.comparing(Produtos::getValorProduto));

        for (Produtos produto : cartao.getCompras()) {
            System.out.println(produto.getNomeProduto() + " - " +produto.getValorProduto());
        }
        System.out.println("\n***********************");

        System.out.println("\nSaldo do cartão: " +cartao.getSaldoCartao());
    }
}
