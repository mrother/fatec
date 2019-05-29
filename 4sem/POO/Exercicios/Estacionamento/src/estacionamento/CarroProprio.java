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
public class CarroProprio extends Carro {

    public String dataCompra;
    public double valorCompra;

    // Construtor tem os parâmetros necessários para instanciar os objetos (não são deduzíveis)
    // Nesse caso, os mesmos da classe ancestral + os parâmetros específicos deste descendente
    public CarroProprio(String placa, String ano, String modelo, String dataCompra, double valorCompra) {
        super(placa, ano, modelo); // Invoca o construtor da classe ancestral
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
    }

    // Faz uma sobreposição do método existente na classe ancestral
    // e imprime dados adicionais
    @Override
    public void imprimeDados() {
        super.imprimeDados(); // Invoca o método da classe ancestral
        System.out.println("Dt. Compra.: " + this.dataCompra); // Comandos adicionais
        System.out.println("Vl. Compra.: " + this.valorCompra);    
    }

    // Faz uma sobrecarga do método existente na classe ancestral    
    @Override
    public boolean oferta(double valor) {
        return valor >= this.valorCompra * 1.10;
    }
}
