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
public abstract class Funcionario {

    protected String nome, rg;
    protected double salarioBase;

    public Funcionario(String nome, String rg, double salarioBase) {
        this.nome = nome;
        this.rg = rg;
        this.salarioBase = salarioBase;
    }

    public abstract double salarioLiquido();

    public abstract void novoMes();

    public void hollerith() {
        System.out.println("Nome.........: " + this.nome);
        System.out.println("R.G..........: " + this.rg);
        System.out.println("Salario Base.: " + this.salarioBase);
        System.out.println("Salario Líq..: " + this.salarioLiquido());
    }
}
