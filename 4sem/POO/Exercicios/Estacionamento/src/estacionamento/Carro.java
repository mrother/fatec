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

    public Carro(String placa, String ano, String modelo) {
        this.placa = placa;
        this.ano = ano;
        this.modelo = modelo;
        this.disponivel = true;
        this.nomeVendedor = "";
    }

    public boolean disponivel() {
        return disponivel;
    }

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
