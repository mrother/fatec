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
public class CarroConsignado extends Carro {

    public String nomeProprietario;
    public double valorVenda;

    // Construtor tem os parâmetros necessários para instanciar os objetos (não são deduzíveis)
    // Nesse caso, os mesmos da classe ancestral + os parâmetros específicos deste descendente
    public CarroConsignado(String placa, String ano, String modelo, String nomeProprietario, double valorVenda) {
        super(placa, ano, modelo); // Invoca o construtor da classe ancestral
        this.nomeProprietario = nomeProprietario;
        this.valorVenda = valorVenda;
    }

    public void imprimeDados() {
        System.out.println("Placa........: " + this.placa);
        System.out.println("Ano..........: " + this.ano);
        System.out.println("Modelo.......: " + this.modelo);
        System.out.println("Proprietario.: " + this.nomeProprietario);
        System.out.println("Vl. Venda....: " + this.valorVenda);
        System.out.println("Disponível...: " + this.disponivel);
        if (!this.disponivel()) {
            System.out.println("Vendedor.....: " + this.nomeVendedor);
        }
    }

    public boolean oferta(double valor) {
        if (valor < this.valorVenda * 1.05) {
            return false;
        } else {
            return true;
        }
    }
}
