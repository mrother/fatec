/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploint;

import exemploint.sorter.SortedList;

/**
 *
 * @author 0040481721008
 */
public class ExemploInt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Aluno a = new Aluno("Mauricio Rother", 15);
        Aluno b = new Aluno("Antonio Lima", 5);
        Aluno c = new Aluno("Daniel", 20);
        Aluno d = new Aluno("Eduardo", 1);
        Aluno e = new Aluno("Fulano", 40);

        SortedList s = new SortedList(5);

        s.Add(a);
        s.Add(b);
        s.Add(c);
        s.Add(d);
        s.Add(e);
        
        s.sort();
        s.printAll();

    }

}
