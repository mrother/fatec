/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tecelagem;

/**
 *
 * @author 0040481721008
 */
public class Tecelagem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FuncionarioAdministrativo antonio = new FuncionarioAdministrativo("Antonio", "123", 100);

        antonio.registrarFalta();
        antonio.registrarFalta();
        antonio.registrarFalta();
        
        antonio.hollerith();
    }
    
}
