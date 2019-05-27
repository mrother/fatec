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
public class Funcionario {

    private String nome;
    private double salario;

    public Funcionario(String nome, double Salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public void print() {
        System.out.println(
                "Nome: " + nome + "\n"
                + "Salario: " + salario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
