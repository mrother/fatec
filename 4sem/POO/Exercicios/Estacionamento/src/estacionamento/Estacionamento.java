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
public class Estacionamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarroProprio cp = new CarroProprio("EDF1244", "2008", "Peugeot 206", "2019-10-10", 15000);
        System.out.println(cp.disponivel());
        
        cp.venderCarro("Zezinho", 20000);
        
        System.out.println(cp.disponivel());
        System.out.println(cp.nomeVendedor);
    }

}
