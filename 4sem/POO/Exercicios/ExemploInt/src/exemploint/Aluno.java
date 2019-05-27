/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploint;

import exemploint.sorter.SorteableItem;

/**
 *
 * @author 0040481721008
 */
public class Aluno implements SorteableItem {

    private String nome;
    private int numero;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Aluno(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    @Override
    public int valueToSort() {
        return this.numero;
    }

    @Override
    public void printItem() {
        System.out.println(this.numero + " " + this.nome);
    }
}
