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
public class Agenda {

    private Contato Lista[];
    private int count;

    public Agenda(int qtdd) {
        Lista = new Contato[qtdd];
        this.count = 0;
    }

    public boolean add(Contato ct) {
        if (count >= Lista.length) {
            return false;
        }
        Lista[count] = ct;
        count++;
        return true;
    }

    public void printCli() {
        for (int i = 0; i < count; i++) {
            if (Lista[i] instanceof Cliente) {
                Cliente c = (Cliente) Lista[i];
                c.print();
            }
        }
    }

    public void printAmigo() {
        for (int i = 0; i < count; i++) {
            if (Lista[i] instanceof Amigo) {
                Amigo a = (Amigo) Lista[i];
                a.print();
            }
        }
    }
}
