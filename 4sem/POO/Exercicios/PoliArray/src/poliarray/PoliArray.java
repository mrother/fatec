/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poliarray;

/**
 *
 * @author 0040481721008
 */
public class PoliArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Agenda ag = new Agenda(5);
        
        ag.add(new Amigo("Zé", "19992233332", "11/02/1990"));
        ag.add(new Amigo("João", "12123451212", "01/06/1997"));
        ag.add(new Cliente("Mauricio Rother", "19998220064", "Codered"));
        ag.add(new Cliente("Luis Amaral", "19123451314", "Camaliam"));
        ag.add(new Cliente("Andre Margato", "19981815916", "Digicomm"));
        
        ag.printAmigo();
        ag.printCli();
    }
    
}
