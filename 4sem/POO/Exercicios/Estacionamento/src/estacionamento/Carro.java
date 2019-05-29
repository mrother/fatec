/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estacionamento;

/**
 *
 * @author 0040481721008
 */
public abstract class Carro {

    public String placa, ano, modelo, nomeVendedor;
    public boolean disponivel;

    // O Construtor recebe os parâmetros que não são deduzíveis pelo sistema
    // Como os parâmetros estão no construtor, eles devem ser passados quando instanciar o objeto
    public Carro(String placa, String ano, String modelo) {
        this.placa = placa;
        this.ano = ano;
        this.modelo = modelo;
        this.disponivel = true; // O carro é sempre disponível quando inicializado
        this.nomeVendedor = ""; // O nome do vendedor é vazio quando incializado
    }

    public boolean disponivel() {
        return disponivel;
    }

    // Classe abstrata, só pode ser implementada nos descendentes.
    public abstract boolean oferta(double valor);

    public boolean venderCarro(String vendedor, double valorVenda) {
        if (this.disponivel() && this.oferta(valorVenda)) {
            this.disponivel = false;
            this.nomeVendedor = vendedor;
            return true;
        } else {
            return false;
        }
    }

    public void imprimeDados() {
        System.out.println("Placa......: " + this.placa);
        System.out.println("Ano........: " + this.ano);
        System.out.println("Modelo.....: " + this.modelo);
        System.out.println("Disponível.: " + (this.disponivel ? "sim" : "Não"));
        System.out.println("Vendedor...: " + this.nomeVendedor);
    }
}
