/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio;

/**
 *
 * @author 0040481721008
 */
public class Exercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaFuncionario lf;
        lf = new ListaFuncionario(5);
        
        Funcionario jose = new Funcionario("Jose da Silva", 1000.00);
        lf.add(jose);
        
        lf.add(new Funcionario("João", 2000.00));
        lf.add(new Funcionario("Maria", 5000.00));
        lf.add(new Funcionario("Manoel", 1200.00));
        lf.add(new Funcionario("Miguel", 4000.00));
        
        lf.print();      
    }
}
