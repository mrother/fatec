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
public class FuncionarioVendedor extends Funcionario {

    double totalVendas;

    public FuncionarioVendedor(String nome, String rg, double salarioBase) {
        super(nome, rg, salarioBase);
        this.totalVendas = 0;
    }

    public void registrarVenda(double valor) {
        this.totalVendas += valor;
    }

    @Override
    public double salarioLiquido() {
        return this.salarioBase + (this.totalVendas * 0.03);
    }

    @Override
    public void novoMes() {
        this.totalVendas = 0;
    }

    public void hollerith() {
        super.hollerith();
        System.out.println("Total Vendas.: " + this.totalVendas);
    }
}
