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
public class FuncionarioProducao extends Funcionario {

    int horasDiurnas, horasNoturnas;

    public FuncionarioProducao(String nome, String rg, double salarioBase) {
        super(nome, rg, salarioBase);
        this.horasDiurnas = 0;
        this.horasNoturnas = 0;
    }

    public void registrarHorasDiurnas(int horas) {
        this.horasDiurnas += horas;
    }

    public void registrarHorasNoturnas(int horas) {
        this.horasNoturnas += horas;
    }

    @Override
    public double salarioLiquido() {
        return this.salarioBase = this.salarioBase * this.horasDiurnas + ((this.salarioBase * this.horasNoturnas) * 1.30);
    }

    @Override
    public void novoMes() {
        this.horasDiurnas = 0;
        this.horasNoturnas = 0;
    }

    public void hollerith() {
        super.hollerith();
        System.out.println("Horas dia....: " + this.horasDiurnas);
        System.out.println("Horas noite..: " + this.horasNoturnas);
    }
}
