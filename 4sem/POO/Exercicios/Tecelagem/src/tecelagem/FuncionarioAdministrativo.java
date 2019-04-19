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
public class FuncionarioAdministrativo extends Funcionario {

    int faltas;
    double salarioLiquido;

    public FuncionarioAdministrativo(String nome, String rg, double salarioBase) {
        super(nome, rg, salarioBase);
        this.faltas = 0;
        this.salarioLiquido = this.salarioBase;
    }

    public void registrarFalta() {
        this.faltas++;
    }

    @Override
    public double salarioLiquido() {
        return this.salarioLiquido = this.salarioBase - (this.salarioBase / 30 * this.faltas);
    }

    @Override
    public void novoMes() {
        this.faltas = 0;
    }

    public void hollerith() {
        super.hollerith();
        System.out.println("Total Faltas.: " + this.faltas);
    }
}
