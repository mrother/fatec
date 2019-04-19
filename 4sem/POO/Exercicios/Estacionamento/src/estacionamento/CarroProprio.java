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

    public CarroProprio(String placa, String ano, String modelo, String dataCompra, double valorCompra) {
        super(placa, ano, modelo);
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
    }

    @Override
    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Dt. Compra.: " + this.dataCompra);
        System.out.println("Vl. Compra.: " + this.valorCompra);    
    }

    @Override
    public boolean oferta(double valor) {
        return valor >= this.valorCompra * 1.10;
    }
}
