package br.projeto.shopping.modelos;

import java.util.ArrayList;
import java.util.List;

public class Cartao {
    private double saldoCartao;
    private double saldoRestante;
    private List<Produtos> produtos;


    public Cartao(double saldoCartao) {
        this.saldoCartao = saldoCartao;
        this.saldoRestante = saldoCartao;
        this.produtos = new ArrayList<>();
    }

    public double getSaldoCartao() {
        return saldoCartao;
    }

    public double getSaldoRestante() {
        return saldoRestante;
    }

    public List<Produtos> getCompras() {
        return produtos;
    }

    public boolean adicionaCompra (Produtos compra) {
        if (this.saldoCartao > compra.getValorProduto()){
            this.saldoCartao -= compra.getValorProduto();
            produtos.add(compra);
            return true;
        } else {
            return false;
        }
    }
}
