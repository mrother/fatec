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
public class ListaFuncionario {

    private Funcionario Lista[];
    private int count;

    public ListaFuncionario(int qtdd) {
        Lista = new Funcionario[qtdd];
        count = 0;
    }

    public boolean add(Funcionario f) {
        if (count >= Lista.length) {
            return false;
        }
        Lista[count] = f;
        count++;
        return true;
    }

    public void print(int index) {
        if (index < 0 || index > count) {
            return;
        }
        Lista[index].print();
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            Lista[i].print();
        }
    }

    public double salario() {
        double soma = 0;

        for (int i = 0; i < count; i++) {
            soma += Lista[i].getSalario();
        }
        return soma;
    }

    public double salario(int index) {
        if (index < 0 || index >= count) {
            return 0;
        }
        return Lista[index].getSalario();
    }
}
